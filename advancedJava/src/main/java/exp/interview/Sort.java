package com.chandler.exp.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sort {
	private int counter = 0;
	public boolean print = true;
	
	public Sort(){
		
	}
	
	public Integer[] insertionSort(Integer[] array){
		this.counter=0;
		int temp;
		//loop array
		for(int i=0;i<array.length;i++){
			//set A is the array already looped and ordered. (only first item in A at the beginning)
			//set B is the remaining array that is not looped yet.
			for(int j=i+1;j>0 && j<array.length;j--){
				//if the first item in B (i+1) is bigger than the last item in A, it means no bigger items possible in A (A is already sorted)
				if(array[j]>array[j-1]){
					break;
				}else{//switch the order of two nearby items
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					counter++;
				}
			}
		}
		
		return array;
	}

	public void printArray(Integer[] array){
		System.out.println(array.length+" elements in total.");	
		if(this.print){
			for(int a: array)
				System.out.print(a+",");
			System.out.println("");			
		}
		System.out.println("Runs:"+this.counter+" times.");	
		System.out.println("----------------------------------------");
	}
	
	public void printList(List<Integer> array){
		System.out.println(array.size()+" elements in total.");
		if(this.print){	
			for(int a: array)
				System.out.print(a+",");
			System.out.println("");			
		}	
		System.out.println("Runs:"+this.counter+" times.");
		System.out.println("-------------------------------------");
	}
	
	public Integer[] shellSort(Integer[] array){
		this.counter=0;
		for(int gap = array.length/2; gap>0; gap/=2){
			int temp;
			//the same logic as insertionSort, but replace 1 with gap.
			for(int i=0;i<array.length;i++){
				//J>gap-1 to make sure it does not have "outOfBounds" exception
				for(int j=i+gap;j>gap-1&&j<array.length;j-=gap){
					
					if(array[j]>array[j-gap]){
						break;
					}else{
						temp = array[j-gap];
						array[j-gap] = array[j];
						array[j] = temp;
						counter++;
					}
				}
			}
		}
		
		return array;
	}
	
	public List<Integer> mergeSortRecursive(List<Integer> array){
		
		int start = 0;
		int length = array.size();
		int mid = array.size()/2;
		//split the array into two until only one element exists in each array
		List<Integer> temp1 = array.subList(start, mid);
		//always the 2nd one has 2 elements at then end if array size is odd
		List<Integer> temp2 = array.subList(mid, length);			
		
		//array size is even
		if(length%2==0 && length/2==1){			
			return merge(temp1,temp2);
		}else if(length%2!=0 && length/2==1){//always the 2nd one has 2 elements at then end if array size is odd
			List<Integer> temp3 = mergeSortRecursive(temp2);
			return merge(temp1,temp3);
		}else{
			temp1 = mergeSortRecursive(temp1);
			temp2 = mergeSortRecursive(temp2);
		}
		
		return merge(temp1,temp2);
	}
	
	private List<Integer> merge(List<Integer> temp1, List<Integer> temp2){
		List<Integer> result = new ArrayList<Integer>();
		
		int i=0;
		int j=0;		
		while(i<temp1.size()||j<temp2.size()){
			//if one of the ordered list already used up
			if(i==temp1.size()){
				result.addAll(temp2.subList(j, temp2.size()));
				break;
			}
			
			if(j==temp2.size()){
				result.addAll(temp1.subList(i, temp1.size()));
				break;
			}
			
			int item1 = temp1.get(i);
			int item2 = temp2.get(j);
			//put the small one into result
			if(item1<=item2){
				this.counter++;
				result.add(item1);
				i++;
			}else{
				this.counter++;
				result.add(item2);
				j++;
			}
		}		
		
		return result;
	}
	
	public Integer[] generateRandomArray(int size){
		Integer[] list = new Integer[size];
		 Random random = new Random();

		 for (int i = 0; i < size; i++){
			 list[i]=random.nextInt(size);
		 }
		 return list;
	}
	
	private List<Integer> swap(List<Integer> array, int x, int y) {
		int temp = array.get(x);
		array.set(x, array.get(y));
		array.set(y, temp);
		return array;
	}
	
	
	/**
	 * We can consider the pivot as a "hole" which needs to be filled.
	 * We do not care where the pivot goes since it will always be the convergence point/index
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public List<Integer> quickSort(List<Integer> array, int left, int right){
		
		//left<right means the array is not converged to size 1 yet
		if(left<right){
			int i=left;
			int j=right;
			int pivot = array.get(left);//first element as pivot/key
			
			//loop the array from right to left then left to right.
			while(i<j){
				//loop from right to left and find the index which points to an element smaller than pivot
				while(j>i && array.get(j)>=pivot)
					j--;
				if(j>i){//extra check
					swap(array,i,j);//swap the small element and pivot's
					i++;
//					counter++;
				}
				
				//loop from left to right and the index which points to an element greater than pivot
				while(i<j && array.get(i)<pivot)
					i++;
				if(i<j){
					swap(array,i,j);//swap the greater element and pivot
					j--;
//					counter++;
				}			
			}			
			
			//recursive call for the rest of element not including the pivot.
			quickSort(array,left,i-1);
			quickSort(array,i+1,right);
		}
		
		return array;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Sort is = new Sort();
		is.print = false;
		
		Integer[] array = is.generateRandomArray(100000);
		System.out.println("Insertion Sort:");
		
		Integer[] result;
		Integer[] temp = array.clone();
		long from = System.currentTimeMillis();
		result = is.insertionSort(temp);
		System.out.println("Time spent:"+(System.currentTimeMillis()-from));
		is.printArray(result);
		
		System.out.println("Shell Sort:");
		temp = array.clone();
		from = System.currentTimeMillis();
		result = is.shellSort(temp);
		System.out.println("Time spent:"+(System.currentTimeMillis()-from));
		is.printArray(result);
		
		List<Integer> lt = Arrays.asList(array.clone());
		System.out.println("Merge Sort:");	
		is.counter=0;
		from = System.currentTimeMillis();
		List<Integer> ltResult = is.mergeSortRecursive(lt);
		System.out.println("Time spent:"+(System.currentTimeMillis()-from));
		is.printList(ltResult);
		
		List<Integer> lt2 = Arrays.asList(array.clone());
		System.out.println("Quick Sort:");	
		is.counter=0;
		from = System.currentTimeMillis();
		List<Integer> ltResult2 = is.quickSort(lt2, 0, lt2.size()-1);
		System.out.println("Time spent:"+(System.currentTimeMillis()-from));
		is.printList(ltResult2);
				
	}

}
