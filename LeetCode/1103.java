class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int num_candies = 1;
        int[] allocation = new int[num_people];
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                candies = candies - num_candies;
                if (candies <= 0) {
                    allocation[i] = allocation[i] + candies + num_candies;
                    break;
                }
                allocation[i] = allocation[i] + num_candies;
                num_candies++;
            }
        }
        return allocation;
    }
}