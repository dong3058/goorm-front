package objects.chap08.ex01;

public class Main {
    public static void main(String[] args) {

        //  ⚠️ 불가
        YalcoGroup yalcoGroup = new YalcoGroup(1, "서울");//생성 불가 추상 클래스니까.

        YalcoChicken ychStore1 = new YalcoChicken("판교");
        YalcoChicken ychStore2 = new YalcoChicken("강남");

        YalcoCafe ycfStore1 = new YalcoCafe("울릉", true);
        YalcoCafe ycfStore2 = new YalcoCafe("강릉", false);

    };
    //추상 클래스인 얄코그룹을 물려받기에 이렇게 슬수있고 takeorder메서드를 쓸수가있다.
    YalcoGroup[] ycStores = {
                ychStore1, ychStore2,
                ycfStore1, ycfStore2

        for (YalcoGroup ycStore : ycStores) {
            ycStore.takeOrder();
        }

        System.out.println("\n- - - - -\n");

        System.out.println(YalcoChicken.getCreed());//클래스 메서드인대 추상클래스로부터 받으므로
    //각각 자식클래스의 이름들 달고 실행한다.
        System.out.println(YalcoCafe.getCreed());





    }
}
