package interview;

import java.util.*;

/**
 * The idea is to put all intervals into map but eliminate smaller ranges and merge consecutive ranges at the same time:
 * [1,5] [2,4] [9,12]------- [2,4] will be eliminated due to the smaller range than [1,5]
 * [1,3] [2,4] [9,12]-------  [1,3] and [2,4] will be merged to [1,4]
 */
public class Intervals {
    private List<Integer> in = new ArrayList<>();

    /**
     * get a map with [min -> max], [min -> max] structure
     * @param intervals
     * @return
     */
    public Map<Integer, Integer> getIntervalsMap(List<List<Integer>> intervals){

        Map<Integer, Integer> map =new HashMap<>();

        for(List<Integer> meeting : intervals){
            int start = meeting.get(0);
            int end = meeting.get(1);

            if(map.containsKey(start) && map.get(start) > end){
                continue;
            }
            map.put(start, end);
        }

        return map;

    }

    public void getIntervals(Map<Integer, Integer> intervals, int lastEnd){
        if(intervals.size() == 0){
            return;
        }

        int start = Collections.min(intervals.keySet());

        //interval start and end
        if(lastEnd < start){
            in.add(lastEnd);
            in.add(start);
        }

        int end = intervals.get(start);
        intervals.remove(start);

        getIntervals(intervals, end);
    }

    public static void main(String[] args) {
        List<List<Integer>> Integers = new ArrayList<>();
        List<Integer> line1 = new ArrayList<>();
        line1.add(1);
        line1.add(3);

        List<Integer> line2 = new ArrayList<>();
        line2.add(6);
        line2.add(7);

        List<Integer> line3 = new ArrayList<>();
        line3.add(2);
        line3.add(4);

        List<Integer> line4 = new ArrayList<>();
        line4.add(2);
        line4.add(3);

        List<Integer> line5 = new ArrayList<>();
        line5.add(9);
        line5.add(12);

        Integers.add(line1);
        Integers.add(line2);
        Integers.add(line3);
        Integers.add(line4);
        Integers.add(line5);

        Intervals i = new Intervals();
        Map<Integer, Integer> map = i.getIntervalsMap(Integers);
        //the end cannot be smaller than the min start value on first recursive call
        i.getIntervals(map, Collections.min(map.keySet()));

        for(int item : i.in){
            System.out.print(item+",");
        }

    }
}
