package lambda;

@FunctionalInterface
//이런애들은 추상 메서드가 딱 한개만 있어야됨.즉 특정 한개만 작업하기위한게 functionalinterface이기떄문.
//사실 저게없어도 쓸수있긴한대 그러면 메서드가 2개이상이면 오류가안뜸.
public interface Printer {
    void print ();

    //  void say (); // ⚠️ 둘 이상의 메소드는 불가
}

//왜냐 자바는 파이선이나js처럼 어떤 독립적인 1급책에 함수가 없기떄문.