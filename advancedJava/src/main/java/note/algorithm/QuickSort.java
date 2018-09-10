package note.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public List<Integer> quickSort(List<Integer> array){
        int length = array.size();
        if(length<=1){
            return array;
        }

        int pivot = length/2;

        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        List<Integer> middle = new ArrayList();
        int mid = array.get(pivot);

        for(int i = 0; i< length; i++){
            if(array.get(i) < mid){
                left.add(array.get(i));
            }else if(array.get(i) == mid){
                middle.add(mid);
            }else{
                right.add(array.get(i));
            }
        }

        List<Integer> leftReturn = quickSort(left);
        List<Integer> rightReturn = quickSort(right);

        leftReturn.addAll(middle);
        leftReturn.addAll(rightReturn);
        return leftReturn;
    }

    public static void main(String[] args) {
        Integer[] array = {1,8,-6,9,4,3,3,7,-4,-7,2};

        QuickSort qs = new QuickSort();
        System.out.println(qs.quickSort(new ArrayList(Arrays.asList(array))));
    }
}
