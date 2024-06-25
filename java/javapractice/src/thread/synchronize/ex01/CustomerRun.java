package thread.synchronize.ex01;

public class CustomerRun implements Runnable {
    String name;
    ATM atmToUse;
    int needed;

    public CustomerRun(String name, ATM atmToUse, int needed) {
        this.name = name;
        this.atmToUse = atmToUse;
        this.needed = needed;
    }
    @Override
    public void run() {
        while (atmToUse.getBalance() > needed) {
            atmToUse.withdraw(name, needed);

            try {
                Thread.sleep(100);
                //커스터머든 atm 이든 스레드가 휴식시가능ㄹ 가지게되는대 이게2번이다.
                //즉 스레드 내부의 sleep명령은 스레드를 쉬게만든다(어디든간에)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}