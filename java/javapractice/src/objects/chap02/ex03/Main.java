package objects.chap02.ex03;

public class Main {
    public static void main(String[] args) {
        ChickenMenu[] menus = {
                new ChickenMenu("후라이드", 10000),
                new ChickenMenu("양념치킨", 12000),
                new ChickenMenu("화덕구이", 15000, "bake")
        };
        YalcoChicken store1 = new YalcoChicken(3, "판교", menus);

        ChickenMenu order1 = store1.orderMenu("양념치킨");
        ChickenMenu order2 = store1.orderMenu("오븐구이");





        int int1 = 1;
        int int2 = int1;
        int1 = 2;

        String str1 = "헬로";
        String str2 = str1;
        str2 = "월드";







        ChickenMenu menu1 = new ChickenMenu("후라이드", 1000);
        ChickenMenu menu2 = menu1;
        menu1.price = 1200;//메뉴2도 같이 바뀐다.



        public static void raisePrice (int avg, ChickenMenu menu, int amount){
            avg += amount;
            menu.price += amount;
        }

            int avgChickenPrice = 12000;
            ChickenMenu chickenMenu1 = new ChickenMenu("양념치킨", 12000);

            raisePrice(avgChickenPrice, chickenMenu1, 1000);
            //치킨메뉴1의 가격은 올라가나 그러나 앞의 avgchickenprice는 올라가지안흔ㄴ다
        //오냐면 받는 인수가 원시형 자료니까.


    }
}
