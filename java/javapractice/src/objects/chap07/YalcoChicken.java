package objects.chap07;

public class YalcoChicken {
    protected static final String CREED = "우리의 튀김옷은 얄팍하다.";//수정불가

    private final int no;//여기서 초기화를 하지않으면 생성자에서 초기화를 반드시 해줘야됨.
    //FINAL이 아닐경우에는 굳히 해줄 필요는없다.
    public String name;

    //  ⭐️ 필수 - no가 final이고 초기화되지 않았으므로
    public YalcoChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void changeFinalFields () {
        // ⚠️ 불가
        this.no++;
    }

    public final void fryChicken () {
        System.out.println("염지, 반죽입히기, 튀김");
    }
}