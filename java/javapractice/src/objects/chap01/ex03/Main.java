package objects.chap01.ex03;

public class Main {

    //  클래스로 인스턴스를 생성 - 💡 new 연산자 + 생성자 호출
    //  본사의 방침대로 매장을 내는 것
    YalcoChicken store1 = new YalcoChicken(3, "판교");
    YalcoChicken store2 = new YalcoChicken(17, "강남");
    YalcoChicken store3 = new YalcoChicken(24, "제주");
    //생성과동시에 인수입력.
    String[] intros = {store1.intro(), store2.intro(), store3.intro()};
}
