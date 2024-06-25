package objects.chap19.ex01;

public class Button {
    public enum Mode {
        LIGHT("라이트"), DARK("다크");
        Mode(String indicator) { this.indicator = indicator; }
        String indicator;
    }

    private String name;
    private Mode mode;
    private int spaces;

    public Button(String name, Mode mode, int spaces) {
        this.name = name;
        this.mode = mode;
        this.spaces = spaces;
    }

    //  ⭐️ 아래를 주석해제하고 다시 실행해 볼 것 즉 기본 메서드인 toString을 오버라이딩.
    // 기본적으로 toString은 클래스의 이름과 해시값을 반환한다.프린트하면 이름,해시를 반환.
    // @Override
     //public String toString() {
    //      return "%s %s버튼 (%d칸 차지)"
    //              .formatted(mode.indicator, name, spaces);
    //  }
}