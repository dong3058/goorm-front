package objects.chap09.ex01;

public class Main {
    public static void main(String[] args) {
        //  ⭐ 다형성
        PolarBear polarBear = new PolarBear();
        Mamal mamal = polarBear;//추상클래스
        Swimmer swimmer = polarBear;//인터페이스
        //러프하게 보자면 인터페이스 일종의 클래스인셈이다.
        //힌크래스에 여러개의 인터페이스가되며 인퍼페이스의 필드는 public final static임.

        //메서드도 public abstract가 기본.
        GlidingLizard glidingLizard = new GlidingLizard();
        Eagle eagle = new Eagle();

        Hunter[] hunters = {
                polarBear, glidingLizard, eagle
        };

        //  💡 인터페이스 역시 다형성에 의해 자료형으로 작용 가능
        for (Hunter hunter : hunters) {
            hunter.hunt();
        }
    }
}
