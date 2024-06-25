package objects.chap08.ex01;

public class YalcoChicken extends YalcoGroup {
    public static String getCreed () {
        return CREED.formatted("튀김옷은");
    }
    protected static int lastNo = 0;

    public YalcoChicken(String name) {
        super(++lastNo, name);
    }

    //  💡 반드시 구현 - 제거해 볼 것
    @Override
    public void takeOrder () {
        System.out.printf("얄코치킨 %s 치킨을 주문해주세요.%n", super.intro());
    }
    // 추상 메서드로 정의돈건 반드시 자식에서 정의를 해줘야도미 안그면 오류가남.
}
