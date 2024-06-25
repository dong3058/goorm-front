package objects.chap02.ex03;

public class YalcoChicken {
    int no;
    String name;
    ChickenMenu[] menus;//치킨메뉴의 배열 즉 애안에 클래스의 인스턴스가 들어갈수있음.

    YalcoChicken (int no, String name, ChickenMenu[] menus) {
        this.no = no;
        this.name = name;
        this.menus = menus;
    }

    ChickenMenu orderMenu (String name) {
        for (ChickenMenu menu : menus) {//menu하나하나는 치킨메뉴의 인스턴스
            if (menu.name.equals(name)) { // 🔴
                return menu;//또한 인스턴스를 반환하는대 이는 참조 자료형이므로 모두같은
                //애를말함
            }
        }
        return null;
    }
}