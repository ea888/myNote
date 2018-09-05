package note.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    <U> List<U> test(List<U> list){
        return null;
    }

    public static void main(String[] args){
//        GenericMethods<String> gm = new GenericMethods<>();
        GenericMethods gm = new GenericMethods();

        List<Integer> list = gm.test(new ArrayList<>());
        List<String> list2 = gm.test(new ArrayList<>());

//        List<Integer> list = new ArrayList<>();
//        List<Integer> listI = gm.test(list);
    }
}
