package objects.chap16.ex02;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();

        Button.ClickInfo click1 = button.func(123, 456, Button.ClickedBy.LEFT);
        Button.ClickInfo click2 = button.func(492, 97, Button.ClickedBy.LEFT);
        Button.ClickInfo click3 = button.func(12, 36, Button.ClickedBy.RIGHT);

        for (Button.ClickInfo click : new Button.ClickInfo [] { click1, click2, click3 }) {
            click.printInfo();
        }


        System.out.println("\n- - - - -\n");
        //Button.ClickInfo click6 = new Button.ClickInfo(111, 222, Button.ClickedBy.LEFT);

        //메서드를 통해서 clickinfo recored생성중이나 위와같이 static 메서드를 스는것처럼 해도된다!.
        Button.ClickInfo click4 = button.func(111, 222, Button.ClickedBy.LEFT);
        Button.ClickInfo click5 = button.func(111, 222, Button.ClickedBy.LEFT);

        //  ⭐️  레코드 역시 참조형
        //  내용이 같은지 여부는 equals 메소드로 확인
        boolean click4n5Same = click4 == click5;//다름 왜냐 참조형 자료니까
        boolean click4n5Equal = click4.equals(click5);//내용은같다 이말.
        boolean click4n1Equal = click4.equals(click1);
    }
}
