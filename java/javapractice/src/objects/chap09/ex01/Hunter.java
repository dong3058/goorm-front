package objects.chap09.ex01;

public interface Hunter {
    String position = "포식자"; // ⭐️ final - 초기화하지 않을 시 오류 기본적으로 final
    //로 인식하기에 그냥 써도됨.
    // 기본적으로 인터페이스의 모든 값들은 전부다 final 이며
    //메서드는 default혹은 클래스 메서드 혹은 추상 메서드 3가지중 하나이다.
    void hunt ();//ㅜ추상 메서드.즉 인터페이스는 애를 가지는애가 반드시 이걸 구현해ㅑ야된다
    //라는 의미이다.
}