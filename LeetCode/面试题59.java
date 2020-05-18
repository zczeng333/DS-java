class MaxQueue {
    public ArrayList<Integer> queue;
    public int max;

    public MaxQueue() {
        queue = new ArrayList<Integer>();
        max = Integer.MIN_VALUE;
    }

    public int max_value() {
        if (queue.size() == 0) {
            return -1;
        }
        return max;
    }

    public void push_back(int value) {
        queue.add(value);
        if (value > max) {
            max = value;
        }
    }

    public int pop_front() {
        if (queue.size() == 0) {
            return -1;
        }
        int pop_v = queue.get(0);
        queue.remove(0);
        if (pop_v == max) {
            max = Integer.MIN_VALUE;
            for (int i = 0; i < queue.size(); i++) {
                max = Math.max(max, queue.get(i));
            }
        }
        return pop_v;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */