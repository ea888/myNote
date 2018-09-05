package note.designPattern.strategy;

public class SortAlgrithmFactory {
    public static Sort getAlgorithm(String name){
        if("quicksort".equals(name)){
            return new Quicksort();
        }else{
            return new InsertionSort();
        }
    }
}
