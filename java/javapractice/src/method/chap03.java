package method;


import java.util.Scanner//스캐너 클래스 가여조으는과정.

public class chap03 {
    public static void main(String[] args) {

        //  IDE가 최상단에 import java.util.Scanner 자동 작성
        Scanner sc = new Scanner(System.in);


        String str1 = sc.next();//중간에 진행을 멈추고 사용자의 입력을 기다림. 공백을 단위로 끊어서 받음.
        // 즉 입력을  "하나 둘 " 이러헤 넣으면 str1ㅇㄴ 하나 str2는 둘 str3은 공백을 받는다.
        String str2 = sc.next();
        String str3 = sc.nextLine();//애는 엔터 단위로 끊어서받음. 거의다 애를쓴다.

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);


        Scanner sc = new Scanner(System.in);

        boolean bool = sc.nextBoolean();//각각 불리안 인트 더블을 입력받는다 는말. 애내도 엔터 단위로 끊어받는듯?
        int intNum = sc.nextInt();
        double dblNum = sc.nextDouble();
        // 🧪 기타 next~ 메서드들 확인해 볼 것

        System.out.println("bool: " + bool);
        System.out.println("intNum: " + intNum);
        System.out.println("dblNum: " + dblNum);


        //ABC true 1 2.34 이거는 오류가생김 받는 순서가 다르니까.





        Scanner sc = new Scanner(System.in);

        System.out.println("불리언을 입력해주세요.");

        //  💡 다음 입력값이 특정 자료형으로 읽힐 수 있는지 확인
        while (sc.hasNextBoolean()) {//hasnextboolen은 다음값ㅇ어떤 자료형에 해당할떄를 의미함.
            //  💡 대소문자 무관 비교
            System.out.println("입력값: " + sc.nextBoolean());
        }

        //  ⭐ 스캐너의 사용이 끝나면 OS자원을 반환
        //  파일 등으로부터 읽어오는데 사용시 필수
        sc.close();//아래꺼할거면 이문장을 주석처리할것.


        System.out.println("정수를 입력해주세요.");

        while (sc.hasNextInt()) {//정수입력을 받는애.
            System.out.println("입력값: " + sc.nextInt());
        }

        sc.close();








        System.out.println("단어를 입력해주세요.");

        while (sc.hasNext()) {
            String nextWord = sc.next();
            if (nextWord.equalsIgnoreCase("quit")) break;
            System.out.println("입력값: " + nextWord);
        }

        System.out.println("문장을 입력해주세요.");

        while (sc.hasNextLine()) {
            String nextSentence = sc.nextLine();
            if (nextSentence.equalsIgnoreCase("quit")) break;
            System.out.println("입력값: " + nextSentence);
        }
        //둘다 quit나오기전까지 반복문이 진행됨.
        sc.close();



        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int repeatCount = sc.nextInt();

            //  ⚠️ nextInt를 아래에서 바로 사용하면 루프마다 받음
            //  repeatCount 변수에 담은 이유
            for (int i = 0; i < repeatCount; i++) {//만약에 repeatcount에다가 hasvextinout을넣으면
                // 조건문 실행시 매번 입력을받아서 제대로 작동안함.
                //  💡 print (ln이 붙지 않은) : 같은 줄에 이어 출력
                System.out.print("호우 ");
            }
            System.out.println("");
        }

        sc.close();



        //  문자열 바로 입력하여 사용하기

        String [] strInputs = new String [5];

        for (int i = 0; i < strInputs.length; i++) {
            strInputs[i] = sc.nextLine();//문자열을 입력받는 배열이므로 한개의칸에 "하나둘셋"이렇게넣어도된다.
        }

        sc.close();

        for (String str : strInputs) {
            System.out.println(str);
        }

    }
}
