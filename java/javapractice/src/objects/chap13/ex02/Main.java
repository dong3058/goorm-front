package objects.chap13.ex02;

public class Main {


    Button button1 = new Button("Enter");
    Button button2 = new Button("CapsLock");
    Button button3 = new Button("ShutDown");

    //  ⭐️ IDE에서 회색으로 표시 : 이후 배울 람다로 대체
    //다른 방법으론 익명 크래스가아닌 파일을 한개 만들어서onclick을 임플리먼트만 클래스를 한개만들고 해야되나
    //익명클래스면 편하게 사용이가능하다.
        button1.setOnClickListener(new OnClickListener() {
        @Override// 익명 함수로 추상 함수를 구현하는것처럼 애도 인터페이스를 지금여기서 익명 클래스로 구현하고잇는것이다.
        public void onClick() {
            System.out.println("줄바꿈");
            System.out.println("커서를 다음 줄에 위치");
        }
    });

        button2.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick() {
            System.out.println("기본입력 대소문자 전환");
        }
    });

        button3.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick() {
            System.out.println("작업 자동 저장");
            System.out.println("프로그램 종료");
        }
    });

        for (Button button : new Button[] {button1, button2, button3}) {
        button.func();
    }
}
