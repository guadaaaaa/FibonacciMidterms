class FibRunnable implements Runnable {
    private int n;
    public static int[] result;

    public FibRunnable(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        if(n==1){
            result[0] = 0;
            System.out.println("Fibonacci Number 1 : 0");
            return;
        }else if(n==2){
            result[1] = 1;
            System.out.println("Fibonacci Number 2 : 1");
            return;
        }
        Thread t1 = Main.threadArrayList.get(n-3);
        Thread t2 = Main.threadArrayList.get(n-2);
        try {
            t1.start();
            t2.start();
        } catch (IllegalThreadStateException e) {
        }
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        int res = result[n-2] + result[n-3];
        result[n-1] = res;
        System.out.println("Fibonacci Number " + n + " : " + res);
    }
}
