package objects.chap10;

public class ex03 {

        public static void main(String[] args) {
            new ex03().printKings();
        }

        String king = "사자";

        void printKings () {
            String king = "여우"; // 💡 그럼 이건 뭔가요?? 인스턴스의 필드로써의 king과
            //그냥 변수 king은 다르다. 알아두자.

            //  ⭐️ 인스턴스의 필드는 다른 영역으로 간주
            System.out.printf(
                    "인스턴스의 왕은 %s, 블록의 왕은 %s%n",
                    this.king, king
            );
        }




}
