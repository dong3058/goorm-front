package thread.waitnotify;

public class CoffeeMachine {
    final int CUP_MAX = 10;
    int cups = CUP_MAX;

    synchronized public void takeout (CustomerRun customer) {
        if (cups < 1) {
            System.out.printf(
                    "[%d] 😭 %s 커피 없음%n", cups, customer.name
            );
        } else {
            try { Thread.sleep(1000);
                //스레드가 1초동안 멍떄리지만 이떄도안은 아직도 애가 자원을 혼자 독식하고있는것이다.
                //다른 스레드가 이것을 차지하게싶다면 이메서드가 끝나느 시점에서
                //혹은 notfiyall wait을쓰도록하자.
            } catch (InterruptedException e) {}

            System.out.printf(
                    "[%d] ☕️ %s 테이크아웃%n", cups, customer.name
            );
            cups--;
        }

        notifyAll();
        try { wait(); // 커피를 타고 나감
        } catch (InterruptedException e) {}
    }

    synchronized public void fill () {
        if (cups > 3) {
            System.out.printf(
                    "[%d] 👌 재고 여유 있음...%n", cups
            );
        } else {
            try { Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.printf(
                    "[%d] ✅ 커피 채워넣음%n", cups
            );
            cups = CUP_MAX;
        }

        notifyAll();
        try { wait(); // 커피를 채우고 나감
        } catch (InterruptedException e) {}
    }

    //위처럼 한 클래슨에 2개의 메서드가 동기화가 되어있다면
    //한스레드가 한 메서드를 작동중일떄 다른 메서드가 작동하지않은 동기화 메서드에
    //접근하는게 불가하다. 즉 동기화가 붙은것으은 모두 한개의 자원으로 취급되며
    //한번ㅇ데 한개의 메서드에 한개의 스레드만이 접근할수있다고 말하는것같다.
    //즉 2개의 동기화된 메서드가 동시실행될일이없다는것.
}
