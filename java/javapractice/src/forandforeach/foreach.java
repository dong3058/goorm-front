package forandforeach;

public class foreach {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            System.out.println(i); // 🔴
        }//c와 다를게 없내 그닥.


        //  루프 블록 안에서 변수값을 바꾸는 것으로 4번 과정 대신 가능
        for (int i = 0; i < 10;) {
            System.out.println(i);
            i += 2;
        }//증가부분을 밖으로 뺴낸거.



        System.out.println("\n- - - - -\n");

        for (double d = 123.45; d > 0; d -= 32.1) {
            System.out.println(d);
        }//이런것도 가능.

        for (String s = ""; s.length() < 11; s += s.length()) {
            System.out.println(s);
        }//이런거소도디내?



        System.out.println("\n- - - - -\n");

        //  💡 쉼표로 구분하여 여럿 사용 가능
        //  ⚠️ 변수의 자료형은 한 종류만 가능 (혼용 안 됨)
        for (byte a = 0, b = 10; a <= b;) {
            System.out.printf("a: %d, b: %d%n", a++, b--);
        }//초기화를 안에다 하지않고 밖에 int a=0; double b=2.0 이렇게 정의해도됨. 그러면 서로다른 변수를 이용가능.


        System.out.println("\n- - - - -\n");

        //  윷놀이 예제에 적용
        String yuts = "도개걸윷모";
        char yut = '도';

        boolean isValid = false;
        for (int i = 0; i <= yuts.indexOf(yut); i++) {//없는애면 indexOf는 -1을 주니까 작동안함.
            isValid = true;
            System.out.println("앞으로");
        }
        if (!isValid) System.out.println("무효");


        //  종료조건이 없는 for 루프
        for (;;) {
            System.out.println("영원히");
        }
        System.out.println("닿지 않아"); // ⚠️ 실행되지 않음
        //종료조건이없음 이러면안돔.



        //  4의 배수 차례로 10개 배열에 담기
        int count = 10;
        int[] multiOf4 = new int[count];

        for (int i = 1, c = 0; c < count; i++) {
            if (i % 4 == 0) {
                multiOf4[c++] = i;
            }

        }//변수 두개써서 구하는 과정.


        //  💡 배열 순환 (기본적인 방법)
        for (int i = 0; i < multiOf4.length; i++) {
            System.out.println(multiOf4[i]);
        }




        System.out.println("\n- - - - -\n");

        //  💡 for each 문법 - 배열이나 이후 배울 콜랙션 등에 사용
        for (int num : multiOf4) {//js foreach생각해보면 num인 한개긔 엘레먼트를 의미한다.
            System.out.println(num);
        }
        //foreach 입력하면 자동으로 완성해줌. 안되는디???



        System.out.println("\n- - - - -\n");

        for (String s : "호롤롤로".split("")) {//호 롤 롤 로  이렇게 반환함.
            System.out.println(s);
        }



        //  구구단 예제
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d X %d = %2d%n", i, j, i * j);
            }
        }
        //중첩  for문


        String[][] quotesInLangs = {
                {
                        "I am vengeance.",
                        "I am night.",
                        "I am Batman.",
                },
                {
                        "나는 복수를 하지.",
                        "나는 밤이지.",
                        "나는 배트맨이지.",
                },
        };

        String result = "";
        for (String[] quotes : quotesInLangs) {//for each 문으로 가져오는대 중접이므로 첫번쨰는 배열로 받는다.
            for (String quote : quotes) {
                result += quote + " "; // 🔴
            }
            result = result.trim().concat("\n");
        }

        System.out.println(result);


        for (int i = 0; i < 100; i++) {

            //  💡 continue : 한 루프만 건너뜀
            if (i % 3 == 0) continue;

            //  💡 break : 반복 전체를 종료
            if (i == 10) break;

            System.out.println(i);

        }




            //  💡 label : 중첩 루프에서 어느쪽을 continue, break 할 지 구분
            outer:
            for (int i = 0; i < 10; i++) {

                inner:
                for (int j = 0; j < 10; j++) {
                    if (j % 2 == 0) continue inner;
                    if (i * j >= 30) continue outer;

                    if (j > 8) break inner;
                    if (i - j > 7) break outer;

                    System.out.printf("i: %d, j: %d%n", i, j);//break랑 continue는 기본적으로 애내를 포함한 중첩문만중지
                    //2중중첩에 안쪽에 break스면 제일 안쪽 즉 break를 직접적으로 포함한 애만 긑남. 라벨링을 통해서
                    // 누가 누구를 끝내는지를 명시할수있는지 햇갈릴수있어서 잘은 안쓴다.
                }
            }
        }
    }
}
