package interview;
import java.util.*;

public class PrefernceList {
    public List<Integer> find(List<List<Integer>> preferences){

        Map<Integer, Integer> res = new HashMap<>();
        for(List<Integer> list: preferences){
            for(int num : list){
                if(res.containsKey(num)){
                    res.put(num,res.get(num)+1);
                }else{
                    res.put(num,1);
                }
            }
        }

        return sortByValue(res);

    }

    public static List<Integer> sortByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

//        Map<Integer, Integer> result = new LinkedHashMap<>();
//        for (Map.Entry<Integer, Integer> entry : list) {
//            result.put(entry.getKey(), entry.getValue());
//        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.add(entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> preferences = new ArrayList<>();
        List<Integer> p1 = new ArrayList<Integer>() {{
            add(2);
            add(3);
            add(5);
        }};
        List<Integer> p2 = new ArrayList<Integer>() {{
            add(4);
            add(2);
            add(1);
        }};
        List<Integer> p3 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(5);
            add(6);
        }};
        List<Integer> p4 = new ArrayList<Integer>() {{
            add(4);
            add(7);
        }};
        preferences.add(p1);
        preferences.add(p2);
        preferences.add(p3);
        preferences.add(p4);

        PrefernceList pl = new PrefernceList();
        List<Integer> list = pl.find(preferences);
        Collections.reverse(list);
        for(int i:list){
            System.out.println(i);
        }
    }
}
