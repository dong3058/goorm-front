package whilte;

public class chap01 {
    public static void main(String[] args) {

        int i = 0;

        //  💡 while 문의 괄호에는 종료조건만
        while (i < 10) {
            // 종료조건 충족을 위한 값 변화는 외적으로
            System.out.println(i++);
        }


        //  💡 의도적인 무한 루프에 널리 쓰이는 코드
        while (true) {
            System.out.println("인간의 욕심은 끝이 없고");
            System.out.println("같은 실수를 반복한다.");
        }


        double popInBillion = 7.837;

        //  ⭐️ break 를 통한 반복 탈출
        while (true) {
            System.out.println("세계인구: " + (popInBillion -= 0.1));
            if (popInBillion <= 0) break;

            System.out.println("인간의 욕심은 끝이 없고");
            System.out.println("같은 실수를 반복한다.");
        }

        System.out.println("인류 멸종");


        //  100보다 작은 3의 배수들 출력해보기

        int i = 1;

        // ⚠️ 의도대로 작동하지 않음. 이유는?
        while (true) {
            if (i % 3 != 0) continue;  // 🔴 처음에 i가 1이라서 continue문이 진해오디서 계속 i가1임.
            System.out.println(i);

            if (i++ == 100) break;
        }



        int i = 1;

        while (true) {
            if (i++ == 100) break;//비교후에 +연산
            if ((i - 1) % 3 != 0) continue;

            System.out.println(i - 1);
        }


        int i = 1;

        //  보다 가독성을 높이고 의도를 잘 드러낸 코드
        while (true) {
            int cur = i++;

            if (cur == 100) break;
            if (cur % 3 != 0) continue;

            System.out.println(cur);

        }



        int enemies = 0;

        System.out.println("일단 사격");

        do {
            System.out.println("탕");
            if (enemies > 0) enemies--;
        } while (enemies > 0);

        System.out.println("사격중지 아군이다");



        System.out.println("\n- - - - -\n");

        int x = 1; // 10 이상으로 바꿔서 다시 실행해 볼 것
        int y = x;

        while (x < 10) {
            System.out.println("while 문: " + x++);
        }

        do {
            System.out.println("do ... while 문: " + y++);
        } while (y < 10);


        final int LINE_WIDTH = 5;

        int lineWidth = LINE_WIDTH;

        while (lineWidth > 0) {
            int starsToPrint = lineWidth--;
            while (starsToPrint-- > 0) {
                System.out.print("*");
            }
            System.out.println();
        }


    }


}
