package objects.chap06.ex01;

public class YalcoChicken {
    protected int no;
    protected String name;//prviate면 상속받는애들은 못슴 protectec는 사용이가능
    //단 손댈수만없는거지 상속은 가능하다.

    public YalcoChicken (int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void takeHallOrder () {
        System.out.printf("%d호 %s점 홀 주문 받음%n", no, name);
    }
}