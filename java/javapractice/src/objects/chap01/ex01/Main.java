package objects.chap01.ex01;

public class Main {
    public static void main(String[] args) {


        Button button1 = new Button('1', 1, "DARK");
        Button buttonPlus = new Button('+', 3, "DARK");
        Button buttonClear = new Button('C', 2, "DARK");

        button1.place();//인스턴스 생성후 각각 메서드 실행.
        buttonPlus.place();
        buttonClear.place();
        //버튼 클래스를 가져온것.

    }
}
