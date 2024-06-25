package objects.chap05.ex03;

public class Slime {
    protected double hp = 50;
    protected int attack = 8;
    protected double defense = 0.2;

    public void attack (Slime enemy) {
        enemy.hp -= this.attack * (1 - enemy.defense);//적의 attack과 구분하기위해서 this를 붙임.
    }
}