package objects.chap09.ex01;

public interface Flyer {
    String aka = "날짐승"; // ⭐️ final - 초기화하지 않을 시 오류 인터페이스는 생성자가없으니까
    //초기화를 꼭 해주도록 하자꾸나.
    void fly ();
}