package objects.Generic;

public class Main {
    public static void main(String[] args) {



        int randNum = pickRandom(123, 456);//제네릭을 쓰므로 전부다 ㄱ같은형
        //즉 return과 인자가 같아야된다.
        boolean randBool = pickRandom(true, false);
        String randStr = pickRandom("마루치", "아라치");

        //  import sec05.chap08.ex01.YalcoChicken;
        YalcoChicken store1 = new YalcoChicken("판교");
        YalcoChicken store2 = new YalcoChicken("역삼");
        YalcoChicken randStore = pickRandom(store1, store2);

        //  ⚠️ 타입이 일관되지 않고 묵시적 변환 불가하면 오류
        //  double randFlt = pickRandom("hello", "world");
        double randDbl = pickRandom(12, 34);//묵시적 정수->실수변환이가능.





        //  원시값 배열(double[])을 쓰면 오류 - 배열로는 오토박싱이 안 되므로
        Double[] array1 = new Double[] {
                1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8
        };
        Character[] array2 = new Character[] {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'
        };

        arraySwap(array1, 3, 5);
        arraySwap(array2, 2, 7);






        // 셔플
        for (int i = 0; i < 100; i++) {
            arraySwap(
                    array2,
                    (int) Math.floor(Math.random() * array2.length),
                    (int) Math.floor(Math.random() * array2.length)
            );
        }



    }








    //  제네릭 메소드
    //  T : 타입변수. 원하는 어떤 이름으로든 명명 가능
    public static <T> T pickRandom (T a, T b) {
        return Math.random() > 0.5 ? a : b;

    }







    public static <T> void arraySwap (T[] array, int a, int b) {
        if (array.length <= Math.max(a, b)) return;
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }









    //  선언시 아래와 같이 자료형에 각 타입변수의 자료형을 명시
    //  - 제내릭에는 원시값이 아닌 클래만 사용 가능
    //  - (래퍼 클래스의 또 다른 존재 이유)
    Pocket<Double, Double, Double> size3d1 =
            new Pocket<>(123.45, 234.56, 345.67);

    //  타입추론도 가능은 함
    Pocket<Double, Double, Double> size3d2 =
            new Pocket<>(123.45, 234.56, 345.67);

    double width = size3d1.getFieldA();
    double height = size3d1.getFieldB();
    double depth = size3d1.getFieldC();

    Pocket<String, Integer, Boolean> person =
            new Pocket<>("홍길동", 20, false);

    //  제네릭 클래스는 배열 생성시 new로 초기화 필수 new Pocket 이 필수라는말.
    Pocket<String, Integer, Boolean>[] people = new Pocket[] {
            new Pocket<>("홍길동", 20, false),
            new Pocket<>("전우치", 30, true),
            new Pocket<>("임꺽정", 27, true),
    };









    //  💡 T는 Number를 상속한 클래스이어야 한다는 조건
    public static <T extends Number> double add2Num(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
    //  ❓ 그냥 Number를 인자 자료형으로 하면 되지 않을까? 이렇게써도 동작은 같긴하다.


    double sum1 = add2Num(12, 34.56);
    double sum2 = add2Num("1" + true); // ⚠️ 불가


    //  ⭐ 상속받는 클래스와 구현하는 인터페이스(들)을 함께 조건으로
    //  여기서는 클래스와 인터페이스 모두 extends 뒤에 &로 나열
    public static <T extends Mamal & Hunter & Swimmer>//3개다 충족한애만 가능.
    void descHuntingMamal (T animal)  {
        //  ⭐️ 조건에 해당하는 필드와 메소드 사용 가능
        System.out.printf("겨울잠 %s%n", animal.hibernation ? "잠" : "자지 않음");
        animal.hunt();
    }

    public static <T extends Flyer & Hunter>
    void descFlyingHunter (T animal) {
        animal.fly();
        animal.hunt();
    }



    descHuntingMamal(new PolarBear());
    descHuntingMamal(new GlidingLizard()); // ⚠️ 불가

    descFlyingHunter(new Eagle());
    descFlyingHunter(new GlidingLizard());
    descFlyingHunter(new PolarBear()); // ⚠️ 불가

}
