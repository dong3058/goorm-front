package objects.chap07;

public class Main {


    String ycCreed = YalcoChicken.CREED;
    YalcoChicken.CREED = "우리의 튀김옷은 바삭하다"; // ⚠️ 불가

    final YalcoChicken store1 = new YalcoChicken(3, "판교");

    //  ⚠️ 불가
    store1 = new YalcoChicken(17, "강남");
    //  💡 요소 변경은 가능
    store1.name = "선릉";//그러나 참조 자료형의 FIANL과 같기에 안의 내용물을 바꿀수가있다.
}
