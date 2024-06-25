package objects.chap03.ex02;

public class YalcoChicken {

    static String brand = "얄코치킨";
    static String contact () {
        return "%s입니다. 무엇을 도와드릴까요?".formatted(brand);
    }
    static int lastNo = 0; // ⭐️

    int no;
    //int no = ++lastNo; // 이렇게 해도 됨
    //no = ++lastNo; 그냥 이렇게ㅐ 해줘도됨. 즉 초기화가 인스턴스 생성시마다 일어난다는말이다.
    String name;

    YalcoChicken(String name) {
        // 클래스 변수를 활용하여 생성마다 새 번호 부여 (또는 위처럼)
        no = ++lastNo;//생성자 실행시 즉 인스턴ㅅ 생성시 바로 카운트를 추가.
        //앞에서 설명했듯이 생성자에 같은 변수가 아닌이상 this 생략하면 그냥
        //인스턴스의 변수르 말함.
        this.name = name;
    }

    String intro () {
        return "안녕하세요, %s %d호 %s호점입니다." // 🔴
                .formatted(brand, no, name);
    }
}