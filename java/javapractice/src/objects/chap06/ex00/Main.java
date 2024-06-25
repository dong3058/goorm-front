package objects.chap06.ex00;

public class Main {
    public static void main(String[] args) {
        //  💡 가능 - 자식 클래스는 부모 클래스에 속함
        Button button1 = new Button("Enter");
        Button button2 = new ShutDownButton();
        Button button3 = new ToggleButton("CapsLock", true);

        //  ⚠️ 불가
        ShutDownButton button4 = new Button("Enter");//부모를 자식에
        ToggleButton button5 = new ShutDownButton();//서로 상속아닌애를넣기는안됨.




        //  ⭐️ 편의 : 모두 Button이란 범주로 묶어 배열 등에서 사용 가능
        Button[] buttons = {
                new Button("Space"),
                new ToggleButton("NumLock", false),
                new ShutDownButton()
        };

        for (Button button : buttons) {
            //  ⭐️ 모든 Button들은 func 메소드를 가지므로
            button.func();//각각의 클래스에 해당되는 오버라이딩 혹은 원본 메서드를 돌려준단.

            //- 이처럼 특정 자료형의 자리에 여러 종류가 들어올 수 있는 것 - **다형성**
            //    - 상속, 오버라이딩, 이후 배울 인터페이스 등을 통해 구현 가능!!!!

        }




        Button button = new Button("버튼");
        ToggleButton toggleButton = new ToggleButton("토글", true);
        ShutDownButton shutDownButton = new ShutDownButton();

        //  true
        boolean typeCheck1 = button instanceof Button;//즉 Button의 인스턴스인지를 확인.
        boolean typeCheck2 = toggleButton instanceof Button;
        boolean typeCheck3 = shutDownButton instanceof Button;

        //  false
        boolean typeCheck4 = button instanceof ShutDownButton;//거짓
        boolean typeCheck5 = button instanceof ToggleButton;//거짓

        //  ⚠️ 컴파일 에러
        boolean typeCheck6 = toggleButton instanceof ShutDownButton;//불가
        boolean typeCheck7 = shutDownButton instanceof ToggleButton;//불가 왜냐 서로 상속하는 관계가
        //아니기 떄문.


        Button[] buttons = {
                new Button("Space"),
                new ToggleButton("NumLock", false),
                new ShutDownButton()
        };

        for (Button btn : buttons) {
            if (btn instanceof ShutDownButton) continue; // ⭐️
            btn.func();
        }


    }
}
