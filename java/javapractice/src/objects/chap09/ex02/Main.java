package objects.chap09.ex02;

public class Main {
    public static void main(String[] args) {
        FoodSafety.announcement();

        YalcoChicken store1 = new YalcoChicken();

        store1.regularInspection();// 인터페이스내부의default 로 ㄱ구현되므로 사용가능.
        store1.cleanKitchen();
        store1.employeeEducation();

        //default를 왜쓰는가? 인터페이스에 기능 추가ㅣ default가아니면 애를
        //상속한 ㅂ모드앤들이 그걸 구현해야되는 번거로움이 새ㅑㅇ김.
    }
}
