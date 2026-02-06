public class Solution {

    public int rob(int[] nums) {
        /**
         * solved using dynamic programming
         * To counter the fact that the houses are in a circle, we use two loops 
         * one from(0 till n-1), other from (1 till n)
         * Inside the loop we check which computed value should be taken. 
         * In the end, we return the max answer of result from both loops.
         */
        int rob1 = 0;
        int rob2 = 0;
        int max1 = nums[0];
        int max2 = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max1 = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = max1;
        }
        // resetting values so they can be used again in the second loop
        rob1 = 0;
        rob2 = 0;
        /**
         * second loop is written again explicitly for my own understanding. an obvious improvement is 
         * to create a function that take parameters to run loops.
         */
        for (int i = 1; i < nums.length; i++) {
            max2 = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = max2;
        }
        return Math.max(max1, max2);

    }
}
