package interview;

public class NonConsecutiveMax {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        /**
         * The whole idea is to push forward from the 3rd element
         * The first step within loop is calculating the max between 1+3 and (the max of 1 and 2)
         *
         * The code within the loop is actually the same logic with the code above loop!
         */
        int current = nums[0]; // first number
        int maxHere = Math.max(nums[0], nums[1]); // max so far
        for (int i = 2; i < n; i++) {
            //max of index 1+3 or 2 or 1
            int max = Math.max(current + nums[i], maxHere);
            //the most important step: set the current to maxHere
            //it makes the current either item[0] or item[i] to enable the validity to calculate max - non consecutive
            current = maxHere;
            //same as the maxHere = max(item[0], item[1])
            maxHere = max;
        }

        return maxHere;
    }

    public static void main(String[] args) {
        NonConsecutiveMax ncm = new NonConsecutiveMax();
        System.out.println(ncm.rob(new int[]{6, 5, 1, 1, 0, 9}));
        System.out.println(ncm.rob(new int[]{4, 10, 3, 1, 5}));
    }
}
