package objects.chap02.ex01;

public class Main {

    public static void main(String[] args) {

        Slime slime1 = new Slime();
        Slime slime2 = new Slime();

        slime1.attack(slime2);// 클래스도 참조자료형인지라 이렇게하면 실제로 슬라임2의
        //hp가 줄어듬.

    }

}
