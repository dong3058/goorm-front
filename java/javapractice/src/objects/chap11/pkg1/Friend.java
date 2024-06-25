package objects.chap11.pkg1;

public class Friend {
    //  Parent와 같은 패키지
    Parent parent = new Parent();

    //  int aa = new Parent().a; // ⚠️ 불가
    int bb = parent.b;
    int cc = parent.c; // 💡 protected - 같은 패키지, 비 상속관계
    int dd = parent.d;//자식이 아닌 같은 패키지내에있느것이므로 인스턴스를 정의하고 사용,
}