package objects.chap02.ex03;

public class ChickenMenu {
    String name;
    int price;
    String cook = "fry";

    ChickenMenu (String name, int price) {
        this.name = name;
        this.price = price;
    }
    //메서드 오버로딩 생성자도 메서드이므로 이렇게쓰는것이 가능하다.
    //위 생성자는 cook에 fry가 들어갈것이다.
    ChickenMenu (String name, int price, String cook) {
        this.name = name;
        this.price = price;
        this.cook = cook;
    }
}