package objects.chap13.ex02;


public class Button {
    String name;
    public Button(String name) {
        this.name = name;
    }

    //  ⭐️ 인터페이스를 상속한 클래스 자료형
    private OnClickListener onClickListener;//애는 인터페이스를 구혆겠다는게 아니라 인터페이스 형
    //자료형으로 변수를 받겠다는 의미이다. 인터페이스도 클래스이니까.
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void func () {
        onClickListener.onClick();
    }
}