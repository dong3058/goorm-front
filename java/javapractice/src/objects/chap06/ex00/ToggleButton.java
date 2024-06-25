package objects.chap06.ex00;

public class ToggleButton extends Button {
    private boolean on;

    public ToggleButton(String print, boolean on) {
        super(print);//애는 부모의 생성자를 불러서 자기 생성자의 변수를 넣음.
        this.on = on;
    }

    @Override
    public void func () {
        super.func(); // 💡 부모에서 정의한 메소드 호출 메서드에서는 super가 부모의 메서드를 말함.
        //즉 Button.fun()이상태랑똑같음
        this.on = !this.on;
        System.out.println(
                "대문자입력: " + (this.on ? "ON" : "OFF")
        );
    }
}