package interview;

import java.util.ArrayList;
import java.util.List;

public class Queue {
//    private int numOfArrays = 1;
    private int start = 0;
    private int count = 0;
    private int end = 0;
    private int arraySize;
    //private List<List> container = new ArrayList();
    private List<Object> headArray;
    private List<Object> currentArray;

    public Queue(int arraySize){
        this.arraySize = arraySize;
        this.headArray = new ArrayList(arraySize);
        this.currentArray = this.headArray;
    }

    public void offer(Object o){
        //add new headArray
        if(end == currentArray.size()-2){
            List<Object> append = new ArrayList();
            this.currentArray.add(append);
            append.add(o);
            this.currentArray = append;
//            this.numOfArrays++;
        }else{
            this.currentArray.add(o);
        }
        this.count++;
    }

    public Object poll(){
        if(this.headArray == null || this.headArray.isEmpty()){
            return null;
        }

        Object res;
        if(start < this.arraySize-1 && start<this.headArray.size()){
            res = this.headArray.get(start);
            this.start++;
        }else{
            if(this.headArray.size()-1 >= this.arraySize-1) {
                //remove head array
                this.headArray = (List<Object>) this.headArray.get(this.arraySize - 1);

                this.end -= this.arraySize;
                res = this.headArray.get(0);
                this.start = 1;
            }else{
                return null;
            }
//            this.numOfArrays--;
        }
        this.count--;

        return res;
    }

    public int getSize(){
        return this.count;
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.offer("a");
        q.offer("b");
        q.offer("c");
        q.offer("d");
        q.offer("e");
        q.offer("f");
        q.offer("g");
        q.offer("h");
        q.offer("i");
        q.offer("j");

        q.offer("h");

        System.out.println(q.getSize());

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
