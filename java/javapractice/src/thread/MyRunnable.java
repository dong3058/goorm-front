package thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            // 😴

            System.out.print(2);
        }
    }
}
