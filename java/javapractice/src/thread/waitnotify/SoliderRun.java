package thread.waitnotify;

public class SoldierRun implements Runnable {
    String title;
    PhoneBooth phoneBooth;

    public SoldierRun(String title, PhoneBooth phoneBooth) {
        this.title = title;
        this.phoneBooth = phoneBooth;
    }
    @Override
    public void run() {
        while (true) {
            phoneBooth.phoneCall(this);
            //지난 동기화의 atm의 런어블과는 다르게 애는 휴식시간이없다.
            //즉 지간 atm의 동기화는 휴식기간동안 다른스레드1개가와서 접근 하도록 만든것이댄
            //애는 그단게 없으므로 계속 한스레드가 점령한다.
        }
    }
}
