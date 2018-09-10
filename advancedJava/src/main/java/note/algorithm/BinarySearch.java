package note.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	//return index
	public static int search(List<Integer> list, int key){
		int size = list.size();

		int low = 0;
		int high = size-1;
		int mid = (low+high)/2;		
		while(low <= high && low <= size-1 && high <= size-1){
			if(key == list.get(mid)){
				return mid;
			}else if(key > list.get(mid)){ //move low to mid+1
				low = mid + 1;
				mid = (low+high)/2;	
			}else{
				high = mid - 1;
				mid = (low+high)/2;	
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(7);
		list.add(8);
		list.add(12);
		list.add(15);
		list.add(17);
		list.add(19);
		list.add(27);
		list.add(35);
		list.add(47);
		
		int index = BinarySearch.search(list, 5);
		System.out.println(index);
	}

}
