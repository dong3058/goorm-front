package objects.chap07;

public final class YalcoChickenDT extends YalcoChicken {//클래스의 파이널은 정관수술
    //즉 얄코치킨 DT를 상속받는 클래스는 생성이 불가능하다.
    public YalcoChickenDT(int no, String name) {
        super(no, name);
    }

    //  ⚠️ 불가
    public void fryChicken () {
        System.out.println("염지, 반죽입히기, 미원, 튀김");
    }
    //부모의 메서드가 FINAL이 붙어있기에 수정이불가 즉 오버라이드가 불가능하다.

    // 생성자 추가할 것
}