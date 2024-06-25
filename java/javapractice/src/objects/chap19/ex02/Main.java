package objects.chap19.ex02;

public class Main {
    public static void main(String[] args) {
        Click click1 = new Click(123, 456, 5323487);
        Click click2 = new Click(123, 456, 5323487);
        Click click3 = new Click(123, 456, 2693702);
        Click click4 = new Click(234, 567, 93827345);

        boolean bool1 = click1 == click1;//참
        boolean bool2 = click1 == click2;//거짓
        boolean bool3 = click1 == click3;//거짓
        boolean bool4 = click1 == click4;//거짓
        //기본적으로 주소가 다르므로 거짓이다.



        boolean boolA = click1.equals(click1);
        boolean boolB = click1.equals(click2);//내용이 같더라도 주소값이 다르므로false값.
        boolean boolC = click1.equals(click3);
        boolean boolD = click1.equals(click4);

        //오버 라이딩시 마지막제외 전부다 true값(equals메소드로 인해서)
    }
}
