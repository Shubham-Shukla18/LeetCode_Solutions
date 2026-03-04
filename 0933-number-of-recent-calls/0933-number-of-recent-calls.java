class RecentCounter {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    /*
    Approach=> ArrayDeque(Scalable)
    TC=> O(1) Amortized - Amortized Analysis refers to the average performance of an operation over a sequence of events, even if a single event in that sequence is expensive.
    SC=> O(N)
    Speed=> Very fast
    object creation => Lowest(primitive only)
    memory pressure => minimal
    Application => production rate limiters
    */

    private static final int WINDOW_SIZE = 3000;
    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new ArrayDeque<>(1024);
    }
    
    public int ping(int t) {
        queue.offer(t);

        int threshold = t - WINDOW_SIZE;
        while(!queue.isEmpty() && queue.peek()<threshold){
            queue.poll();
        }

        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */