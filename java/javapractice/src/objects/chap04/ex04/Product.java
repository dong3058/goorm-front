package objects.chap04.ex04;

public class Product {

    private static double discount = 0.2;
    private static double increaseLimit = 1.2;

    private String name;
    private int price;



    //get set이 붙은애들은 외부에서 접근이 가능하도록 즉 private를 접근이 가능하도록 해주는것이다.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) return;
        this.name = name;
    }

    public int getPrice() {
        return (int) (price * (1 - discount));
    }

    public void setPrice(int price) {
        //  ⭐ this 사용 주의
        int max = (int) (this.price * increaseLimit);// 객체내의 price와 구분을위해 this를붙임.
        this.price = price < max ? price : max;
    }
}