package objects.chap05.ex02;

public class Main {
    public static void main(String[] args) {
        Button entrButton = new Button("Enter");
        ShutDownButton stdnButton = new ShutDownButton();
        ToggleButton tglButton = new ToggleButton("CapsLock", false);

        entrButton.func();

        System.out.println("\n- - - - -\n");

        stdnButton.func();

        System.out.println("\n- - - - -\n");

        tglButton.func();
        tglButton.func();
        tglButton.func();

        //부모클래스에 생성자가 없으면 자식은 생성자를 선언할필요가없으나
        // 부모에 생성자가 있다면 자식은 빈 생성자라도 선언해야된다.
    }
}
