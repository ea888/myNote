package com.chandler.exp.interview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * Implementation of priority queue
 * each node has 2 bigger children
 * @author chand
 *
 */
public class BinaryHeap {
	//the heap starts from index 1
	//left child index = parent index * 2
	//parent index = current index / 2
	Integer[] heap = new Integer[15];
	int index = 0;
	
	//the min value is always on root
	public Integer findMin(){
		return heap[1];
	}
	
	//expand heap for 2 times
	//the heap starts from index 1
	public Integer[] expandHeap(){
		Integer[] temp = heap;
		heap = new Integer[heap.length*2];
		for(int i = 1; i < temp.length; i++){
			heap[i] = temp[i];
		}
		
		return heap;
	}
	
	private void swapValues(int index1, int index2){
		Integer temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	//no duplicate input is allowed, we can scan the heap to see if there is any duplicate
	public void insert(Integer item){
		//expand heap if it's full
		if(this.index == this.heap.length-1)
			this.expandHeap();
		
		//put item at the end of heap first
		this.index++;
		heap[index] = item;
				
		//first element
		if(index == 1){
			return ;
		}		
		
		for(int i = this.index; i > 1; i=i/2){
			//already in good position
			if(item > heap[(i)/2]){
				break;
			}else if(item < heap[(i)/2]){// need to move up
				swapValues((i)/2, i);			
			}
		}		
	}
	
	
	//move the last element to root (the hole created by removing the min element)
	//then move this item along the MIN path to proper position
	public void removeMin(){
		//move the last element to root
		heap[1] = heap[index];
		heap[index--] = null;
		
		int child;
		//try to find the proper position for last element which is moved to root
		for(int i=1 ; 2*i <= index; i = child){
			//left child index
			child = 2*i;
			//right child smaller
			if(child + 1 <= index && heap[child+1] < heap[child]){
				child++;
			}
			
			if(heap[i] > heap[child]){
				swapValues(i,child);
			}else{ //if the element is smaller than child, it's good to stop looping
				break;
			}
		}
	}
	
	public void printArray(){
		System.out.println("Heap Array: "+this.index);
		for(int i=1; null != this.heap[i] && i < this.heap.length - 1; i++){
			System.out.print(this.heap[i]+",");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 10;
		Random r = new Random();
		HashSet<Integer> hs = new HashSet<Integer>();	
		BinaryHeap bh = new BinaryHeap();
		for(int i=0; i < size; i++){
			hs.add(r.nextInt(size*3));
//			bh.insert(r.nextInt(size*3));
		}
		
		// use hashSet to make the input unique
		Iterator<Integer> it = hs.iterator();
		while(it.hasNext()){
			Integer el = it.next();
			bh.insert(el);
		}
		
		bh.printArray();
		
		bh.removeMin();
		
		bh.printArray();
	}

}
