package objects.chap10;

public class ex01 {

        public static void main(String[] args) {
            System.out.println(a); // ⚠️ 클래스 메소드에서 인스턴스 필드 사용 불가
        }//스태틱 이므로 클래스 메서드.

        private String y = x; // ⚠️ 클래스 내 필드의 스코프 : 해당 클래스 안
        private int a = 1;
        private int b = a + 1;//필드끼리는 연산이 가능;
        private int c = d + 1; // ⚠️ 메소드 내 변수의 스코프 : 해당 메소드 안

        public void func1 () {
            System.out.println(a + b);
            int d = 2;
        }

        public void func2 () {
            System.out.println(d); // ⚠️
        }




}
