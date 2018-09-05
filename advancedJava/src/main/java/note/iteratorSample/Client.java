package note.iteratorSample;

import java.util.*;

public class Client {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        for(String s : list){
            System.out.println(s);
        }

        System.out.println("---------------------------");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        Map<Integer, Integer> map = new HashMap();
        map.put(1,1);
        map.put(2,2);

        System.out.println("---------------------------");

        Iterator<Integer> it2 = map.keySet().iterator();
        while(it2.hasNext()){
            Integer key = it2.next();
            System.out.println(key+"-->"+map.get(key));
            int in = Integer.valueOf(key)+(Integer)map.get(key);
            System.out.println(in);
        }

    }
}
