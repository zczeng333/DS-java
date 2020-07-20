class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            drink = drink + empty / numExchange;
            empty = empty % numExchange + empty / numExchange;
        }
        return drink;
    }
}