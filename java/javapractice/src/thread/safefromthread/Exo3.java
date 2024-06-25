package thread.safefromthread;

public class Exo3 {

    static int count = 0;
    static AtomicInteger atomicCount = new AtomicInteger(0);
    //애는 메서드가 아닌 필드를 스레드로부터 안전하게 만드는것.
    public static void main(String[] args) {


        Runnable incCount = () -> {
            for (int i = 0; i < 10000; i++) {
                count++;
                atomicCount.getAndIncrement();
            }
        };

        Thread t1 = new Thread(incCount);
        Thread t2 = new Thread(incCount);
        Thread t3 = new Thread(incCount);

        t1.start(); t2.start(); t3.start();

        try {
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e) {}

        int result = count;//애는 스레드가 동시에 접근할수도있기에 더낮는 값이 나올수도.
        //즉 동시에 1000시점에 접근할수도있다는ㄳ.
        int atomicResult = atomicCount.get();//애는 줭확히 3만
    }




}
