package objects.chap13.ex01;
import objects.chap08.ex01.*;
public class Main{
    //  💡 와일드카드로 임포트 - import sec05.chap08.ex01.*;

    YalcoGroup store1 = new YalcoChicken("울산");
    YalcoGroup store2 = new YalcoCafe("창원", true);

    YalcoGroup store3 = new YalcoGroup (1, "포항") {
        // 추상클래스는 본디 인스턴스를 생성할수없으니 익명 클래스를 사용한ㄷ면 이것처럼 가능하다.


        //  원본 메소드에 public 추가
        @Override
        public void takeOrder() {
            System.out.printf(
                    "유일한 얄코과메기 %s 과메기를 주문해주세요.%n",
                    super.intro()
            );
        }

        public void dryFish () {//애는 익명 클래스의 자체적인 메서드로 외부에서 호출이 불가능하고
            //클래스 내부에서 호출을 해야됨. 클래스내부의 다른 메서드에서.
            //익명클래스의 인스턴스는 상속받거나 오버라이드 된 메소드만 호출 가능
            System.out.println("과메기 말리기");
        }
    };

    String store3Intro = store3.intro();
    store3.takeOrder();
    //store3.dryFish // ⚠️ 불가

    System.out.println("\n- - - - -\n");

    for (YalcoGroup store : new YalcoGroup[] {store1, store2, store3}) {
        store.takeOrder();
    }





}