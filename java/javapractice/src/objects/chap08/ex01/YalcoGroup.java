package objects.chap08.ex01;

public abstract class YalcoGroup {//추상 클래스.
    //추상 클래스는 스스로 뭘하지못한다. 보통의 클래스에서 기능을 덜어낸느낌으로
    //애를 상속한 애만이 무엇인가를 할수가있다.
    //가장 기초적으로 추상 클래스의 인스턴스조차 만들수가없다.
    //관련된 여러클래스들의 공통 분모가 되기위해서 존재.
    protected static final String CREED = "우리의 %s 얄팍하다";

    //  💡 클래스 메소드는 abstract 불가
    //  abstract static String getCreed ();

    protected final int no;
    protected final String name;

    public YalcoGroup(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String intro () {
        return "%d호 %s점입니다.".formatted(no, name);
    }
    //  이후 다른 패키지에서의 실습을 위해 public으로
    public abstract void takeOrder ();//구현부가 생략되고 abstract가 붙어있는대 이게 추상메서드임/
    // 스스로 선언만하고 구현은 하지않는 메서드이다.
    //물려 바든 자식들이 구현하는것임.
    //public없어도됨. 차피 자식이 만들라고 만든거기떄문에 안써도 무관.
    //자식에서 구현하고 원하느대로 제어자를 설정.
    //또한 클래스 메서드 즉 static 붙은애들은 추상클래스가 불가능하다. 애초에 인스턴스 단위에서
    //쓰는 메서드가 아니므로.
}