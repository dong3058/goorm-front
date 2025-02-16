package objects.chap06.ex00;

public class ShutDownButton extends Button {
    public ShutDownButton () {
        super("ShutDown"); // 💡 부모의 생성자 호출 super를 생성자에서 쓰면 부모의 생성자 호출.
    }

    //  💡 부모의 메소드를 override
    @Override
    public void func () {
        System.out.println("프로그램 종료");
    }
}