package objects.chap01.ex03;

public class YalcoChicken {
    int no;
    String name;
    // 여기 필드에 쓰인 이름과 생성자 내에 쓰인애는 이름만 같을뿐 다른 변수이다.
    //즉 this를 붙여서 위의 필드값들은 객체의 값이고 생성자 함수의 인수는 순수한
    //외부 인수이다. 그러나 this를 없애버리면 서로 구분이 없어진다.
    //  ⭐ 생성자(constructor) : 인스턴스를 만드는 메소드
    //  ⭐ this : 생성될 인스턴스를 가리킴
    //즉 생성자는 필수가아니다. 그냥 외부에서 ㄱ값을ㅇ입력받을것을 필드에넣기위에서쓰는것이다.
    YalcoChicken (int no, String name) {
        this.no = no;
        this.name = name;
    }//return없어도됨. 알아서 반환함.
    //생성자함수 정확히는 yalcochicken(이름이아님)을 반환하는 이름없는 메소드다 이말.
    String intro () {
        //  String name = "몽고반"; // 주석해제 시 name 대체
        return "안녕하세요, %d호 %s점입니다." // 🔴
                .formatted(no, name);
    }
}