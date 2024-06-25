package thread.safefromthread;

public class Ex01 {


    //  3개의 쓰레드에서 한 해시맵에 10000개의 데이터를 주입

    Map<String, Integer> hashMap = new HashMap<>();
//해시매븨 경우 스레드의 영향으로부터 자유롭지못하다.
    //스레드가 고유한 자원을 같이 쓰기에 키,값자체는 중복이 없으나
    //size는 두번 올려버리는 상황이 종종발생함.
    Runnable toHashMap = () -> {
        for (int i = 0; i < 10000; i++) {
            hashMap.put("key" + i, i);
        }
    };

    Thread t1 = new Thread(toHashMap);
    Thread t2 = new Thread(toHashMap);
    Thread t3 = new Thread(toHashMap);

        t1.start(); t2.start(); t3.start();

        try {
        t1.join(); t2.join(); t3.join();
    } catch (InterruptedException e) {}
}
