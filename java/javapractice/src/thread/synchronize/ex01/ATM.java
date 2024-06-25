package thread.synchronize.ex01;

public class ATM {
    private int balance = 0;
    public void addMoney(int amount) {
        balance += amount;
    }
    public int getBalance() {
        return balance;
    }

    //  💡 앞에 synchronized를 붙이고 다시 실행해 볼 것
    public void withdraw (String name, int amount) {
        //synchronized 이걸 public앞에 붙여주자. 이러면 각각 한명씩만 자원에 접근이 가능하다.
        //  💡 또는 아래 내용을 이 블록으로 옮겨 볼 것
        //  - this는 현 쓰레드를 의미함
        //  - 메소드 내의 특정 작업만 동기화가 필요할 때
        //synchronized (this) {<-- 아니면 이렇게 붙이고 이안에다가 아래의 코드들을 집어넣으면된다.
        //}

        if (balance < amount) return;//스레드들은 한 프로세스안의 자원을 공유한ㄴ다. ㅈㄱ 어던 스레드가
        //일을 처리하는대 다른 스레드가 와서 여기에 접근을 해버리면 예상치 못한 일이 일어날수가있다.

        System.out.printf(
                "💰 %s 인출 요청 (현 잔액 %d)%n",
                name, balance
        );
        try {
            Thread.sleep(new Random().nextInt(700, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance -= amount;
        System.out.printf(
                "✅ %s 인출 완료 (현 잔액 %d)%n",
                name, balance
        );
    }
}