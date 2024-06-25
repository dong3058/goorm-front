package objects.chap09.ex02;

public interface FoodSafety {
    //  ⭐️
    //  static 제거해 볼 것
    //  static abstract는 역시 불가 (추상 클래스처럼)
    static void announcement () {
        System.out.println("식품안전 관련 공지");
    }
    //푸드 세이트피가 실행하는 메서드.

    //  ⭐️
    //  default 제거해 볼 것
    default void regularInspection () {
        System.out.println("정기 체크");
    }// 추상이아닌 구상 메서드. 클래스 메서드가 아닌 인스턴스 메서드.즉위이ㅡ 2가지는 구현할필요 x


    void cleanKitchen ();
    void employeeEducation ();
}