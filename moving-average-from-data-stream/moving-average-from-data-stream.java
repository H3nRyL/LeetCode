class MovingAverage {
    private int count = 0;
    private int sum = 0;
    private int size = 0;
    private Queue<Integer> queue = new ArrayDeque<>();
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        count += 1;
        queue.add(val);
        int tail = count > size ? (int)queue.poll() : 0;
        sum = sum - tail + val;
        return sum * 1.0 / Math.min(count, size);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */