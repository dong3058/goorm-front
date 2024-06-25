package thread;

public class WrongsSleep {

    Thread sleeper = new Thread(
            () -> IntStream.range(0, 5)
                    .forEach(i -> {
                        try {
                            Thread.sleep(100);//100ms쉬는것.
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println('쿨');
                    })
    );
        sleeper.start();

        try {
        //  ⚠️ sleeper 쓰레드를 재우려고 했지만
        //  - sleep은 정적 메소드!
        //  - 현 쓰레드가 자버림
        //어던 특정 스레드를 재우고싶으면 그 스레드 안에다가 thread.sleep을 해야지
        //스레드이ㅡ 인스턴스에다가 sleep을 걸면 메인스레드가 잔다.
        sleeper.sleep(1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

        System.out.println("잘잤다!");
}
