public class Lucky {
    static int count = 0;
    private static State state;

    static class LuckyThread extends Thread {
        public LuckyThread(State object) {
            state = object;
        }

        @Override
        public void run() {
            state.run();
            count = state.getCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StateObject stateObject = new state();
        Thread t1 = new LuckyThread(state);
        Thread t2 = new LuckyThread(state);
        Thread t3 = new LuckyThread(state);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }
}
