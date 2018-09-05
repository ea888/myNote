package interview;
import java.util.*;


public class PlaindromePairs {
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            int left = 0, right = 0;
            while (left <= right) {
                String s = words[i].substring(left, right);
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if (j != null && i != j && isPalindrome(words[i].substring(left == 0 ? right : 0, left == 0 ? words[i].length() : left)))
                    res.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
                if (right < words[i].length()) right++;
                else left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PlaindromePairs pp =new PlaindromePairs();
        String[] test = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> rslt = pp.palindromePairs(test);
        for(List<Integer> list: rslt){
            for(int num: list){
                System.out.print(num+",");
            }
            System.out.println();
        }


        System.out.println();
        test = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        rslt = pp.findPairs(test);
        for(List<Integer> list: rslt){
            for(int num: list){
                System.out.print(num+",");
            }
            System.out.println();
        }
    }

    public boolean isPal(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;

        }

        return true;
    }

    public List<List<Integer>> findPairs(String[] words){
        List<List<Integer>> res = new ArrayList<>();


        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i==j)
                    continue;
                String tbTested = words[i]+words[j];
                if(isPal(tbTested)){
                    List<Integer> pals = new ArrayList<>();
                    pals.add(i);
                    pals.add(j);
                    res.add(pals);
                }
            }
        }


        return res;
    }

}
