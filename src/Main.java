import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Thread> threadArrayList;
    public static void main(String[] args) {
        threadArrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Fibonacci Terms: ");
        int num = sc.nextInt();
        FibRunnable.result = new int[num];

        for (int i = 0; i < num; i++) {
            threadArrayList.add(new Thread(new FibRunnable(i+1)));
        }

        Thread lastThrd = threadArrayList.get(threadArrayList.size() - 1);
        lastThrd.start();

        try {
            lastThrd.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        System.out.println("\nThe " + num + " Fibonacci numbers:");
        for (int i = 0; i < num; i++) {
            System.out.print(FibRunnable.result[i] + " ");
        }
    }
}