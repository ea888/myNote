package exp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * thread a prints 1,2,3 then thread b prints 4,5,6 then Thread a prints 7,8,9
 * again.
 * 
 * @important: the logic should be within one lock/unlock block
 * @author chand
 *
 */
public class ReentrantLockDemo {
	static class NumberWrapper {
		public int value = 1;
	}

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();

		// 第一个条件当屏幕上输出到3
		final Condition reachThreeCondition = lock.newCondition();
		// 第二个条件当屏幕上输出到6
		final Condition reachSixCondition = lock.newCondition();

		// NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
		// 注意这里不要用Integer, Integer 是不可变对象
		final NumberWrapper num = new NumberWrapper();

		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					//to make sure thread B runs first
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 需要先获得锁
				lock.lock();
				try {
					System.out.println("threadA start write");
					// A线程先输出前3个数
					while (num.value <= 3) {
						System.out.println(num.value);
						num.value++;
					}
					// 输出到3时要signal，告诉B线程可以开始了
					reachThreeCondition.signal();
					//wait for the number reaches 6 by thread B
					reachSixCondition.await();
					
					System.out.println("threadA start write");
					// 输出剩余数字
					while (num.value <= 9) {
						System.out.println(num.value);
						num.value++;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} finally {
					lock.unlock();
				}
			}

		});

		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					//wait for the number reaches 3 by Thread A
					reachThreeCondition.await();					
					
					System.out.println("threadB start write");
					while (num.value <= 6) {
						System.out.println(num.value);
						num.value++;
					}
					// 4，5，6输出完毕，告诉A线程6输出完了
					reachSixCondition.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}

		});

		// 启动两个线程
		//B must be started before A to execute first
		threadB.start();
		threadA.start();
	}
}
