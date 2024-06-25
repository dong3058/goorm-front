package thread;

public class Ex01 {
    Thread tarzanThread = new Thread(new TarzanRun(100));

    //  💡 쓰레드에 이름 붙이기
    //tarzanThread.setName("타잔송");-->thread.cruuentname의 이름으로 인식이된다.

        tarzanThread.start();
}
