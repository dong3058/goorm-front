package objects.chap19.ex01;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button("엔터", Button.Mode.DARK, 3);

        //  💡 메소드를 ctrl/command + 클릭하여 Object 클래스 사양 살펴보기
        System.out.println(button1); // ⭐️ toString() 을 붙인 것과 같음 즉 클래스+해시코드를 돌려준다.


        //println 메소드로 객체 출력시 기본적으로 이 to string 메소드의 결과값 출력
        // 이출력은 button@해시값 이런골로 반환. 즉 안의 내용이 아니라 toString의 반환값을 반환.
    }
}
