package objects.chap03.ex03;

public class Main {

    public static void main(String[] args) {

        Button button1 = new Button('1', 1);
        Button buttonPlus = new Button('+', 3);
        Button buttonClear = new Button('C', 2);

        Button[] buttons = {button1, buttonPlus, buttonClear};

        System.out.println(Button.mode);//클래스의 필드에 접근
        for (Button button : buttons) { button.place(); }//전부다 light왜냐
        //본값이light니가


        //  연속으로 붙여넣어 실행해볼 것
        Button.switchMode();//dark

        System.out.println(Button.mode);//이하 전부다 dark
        for (Button button : buttons) { button.place(); }
        //즉 공통적으로 쓸것들은 static 변수 메서드로 정의를 해주도록하자.

    }
}
