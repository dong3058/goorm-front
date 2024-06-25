package objects.chap19.ex04;

public class ShallowCopied implements Cloneable {
    String title;
    int no;

    int[] numbers;
    Click click;
    Click[] clicks;

    public ShallowCopied(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        //  Cloneable을 구현했으므로 정상 동작
        //정석적 방법. 주소가 다른애가 탄생한다. 단 얕은 복사 즉 복사본안의 참조 자료형들은
        //주소를 공유한다.
        //  - 원시값만 완전히 복사됨
        return super.clone();
    }
}