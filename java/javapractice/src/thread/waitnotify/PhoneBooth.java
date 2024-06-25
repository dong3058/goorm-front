package thread.waitnotify;

public class PhoneBooth {
    synchronized public void phoneCall (SoldierRun soldier) {
        System.out.println("☎️ %s 전화 사용중...".formatted(soldier.title));

        try { Thread.sleep(500);
        } catch (InterruptedException e) {}

        System.out.println("👍 %s 전화 사용 완료".formatted(soldier.title));

        //  💡 아래를 해제하지 않으면 첫 사용자가 혼자 다 씀
        //notifyAll();
        //try {
        //    //  💡 현 사용자를 폰부스에서 내보냄
        //    //  - sleep처럼 아래의 예외 반환 확인
        //    wait();-->현재 동기화된 자원을 쓰고잇는 스레드가 자리를 비우고 다른 스레드가 사용하게하는것.
        //이떄 양보해줘서 드러온 스레드가 스턴이 되어있다면 무한정으로 계속 정지먹은 상태의 메서드가된다.
        //즉 notifyall을 통해서 모든스레드에 대해서 아무나와서 써라 라고 말해주는 의미이다.
        //즉 notifyall과 waiat은 동기화된 자원을 모든 스레드가 쓸수잇도록 해주는것이다.,
        //추가적으로 wait은 try안에써야된다.
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}
    }
}