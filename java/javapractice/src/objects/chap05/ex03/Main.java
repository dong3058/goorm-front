package objects.chap05.ex03;

public class Main {

    public static void main(String[] args) {
        Slime slime = new Slime();
        FireSlime fireSlime = new FireSlime();

        slime.attack(fireSlime); // ⭐ 클래스가 다른데 가능한 이유 : 다음 강에서
        //파이어 슬라임이 슬라임으로 인식 즉 다형성 떄문임.
        fireSlime.attack(slime);
    }
}
