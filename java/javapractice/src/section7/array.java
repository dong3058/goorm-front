package section7;

public class array {

    public static void main(String[] args) {

        //  💡 사용할 자료형 뒤에 []를 붙여 선언
        char[] yutnori = {'도', '개', '걸', '윷', '모'};//배열선언이 좀 독특하내??? 배열은 크기 수정ㅇ 불가능하다. 리스트와는 다르다이말.

        //  💡 length : 배열의 길이 반환
        int length = yutnori.length;

        //  💡 [] 안에 인덱스 정수를 넣어 접근
        //  ⭐ 0부터 시작
        char first = yutnori[0];
        char last = yutnori[yutnori.length - 1];







        //  💡 초기화하지 않고 일단 선언하기
        //  ⭐ 어떤 값으로 초기화되는지 확인
        boolean[] boolAry = new boolean[3];//길이3짜리 boolen이 들어갈 어레이 형성
        int[] intAry = new int[3];
        double[] dblAry = new double[3];
        char[] chrAry = new char[3]; // 아래 확인
        String[] strAry = new String[3];//애같은경우엔 string의 주소가담김.
        //스트링엔 defaul값으로 null 원시 자료형들은 null이아닌 특정값.
        //  아스키 코드의 0번 글자. 문자열의 끝을 표시하는데 사용
        char NUL = chrAry[0];



        //  다음과 같이 원하는 위치의 값 변경
        intAry[0] = 123;
        intAry[1] = 456;
        intAry[2] = 789;




        //  초기화 블록을 사용한 선언 동시 초기화
        //  두 가지 방법 사용 가능
        char[] dirAry1 = {'동', '서', '남', '북'};
        char[] dirAry2 = new char [] {'동', '서', '남', '북'};

        char[] dirAry3;

        //  선언만 먼저 한 상태에서는 두 번째 방법만 가능
        dirAry3 = {'동', '서', '남', '북'}; // ⚠️ 불가
        dirAry3 = new char[] {'동', '서', '남', '북'};//char [] dirAry3 로 선언시 대이법ㅂ.



        int [] intAry = {1, 2, 3, 4, 5};

        //  ⚠️ 런다임 에러: ArrayIndexOutOfBoundsException
        int outOfAry = intAry[intAry.length];//인덱스 -1값 해줘야됨 0 1 2 3 4  4로 넣어야되나이말.





        //  이중 배열
        boolean[][] dblBoolAry = new boolean[3][3];

        int[][] dblIntAry = new int[][] {
                //  ⭐️ 요소 배열의 크기가 다를 수 있음왜냐 배열에 배열을 받아넣으면 그 배열의 주소가 들어간다.위에서말한 문자열과 동치
                // 단 실제출력및 접근은 파이썬 방식 대로 해야됨.
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9},
        };

        //  삼중 배열
        char[][][] trpChrAry = {
                {{'자', '축'}, {'인', '묘'}},
                {{'진', '사'}, {'오', '미'}},
                {{'신', '유'}, {'술', '해'}},
        };


        int int1 = dblIntAry[0][1];
        int int2 = dblIntAry[2][3];
        int[] intAry = dblIntAry[1];//[4,5]를 반환하니까 int[]이렇게 받는다.

        char[][] dblChrAry = trpChrAry[0];//이중뱅ㄹㅇ므로{'자', '축'}, {'인', '묘'}이걸받음
        char[] chrAry = dblChrAry[0];//애는 ["자","축"]
        char chr1 = chrAry[1];
        char chr2 = trpChrAry[2][0][1];




        //  🧪 디버깅해서 결과를 볼 것
        //  ⭐ 원시 자료형은 값 자체를 복사 - 별개의 값이 됨

        boolean bool1 = true;
        boolean bool2 = false;
        bool2 = bool1; // 🔴둘다 true값읻.
        bool1 = false;//bool1은 false값이됨.

        int int1 = 1;
        int int2 = 2;
        int2 = int1;
        int2 = 3;

        char ch1 = 'A';
        char ch2 = 'B';
        ch2 = ch1;
        ch1 = '가';

        //즉 원시자료형은 값자체를 복사함. 서로 연결즉 같은 종이가 아님;.

        //  ⭐ 참조 자료형은 값 주머니의 주소를 복사. 즉 종이를 복사한다.
        //  두 변수가 같은 주머니를 가리키게 됨

        boolean[] boolAry1 = { true, true, true };
        boolean[] boolAry2 = { false, false, false };
        boolAry2 = boolAry1; // 🔴
        boolAry1[0] = false;//boolary2도 fasle로 바뀜 왜냐 종이가 같으니까.

        int[] intAry1 = { 1, 2, 3 };
        int[] intAry2 = { 4, 5 };
        intAry2 = intAry1;
        intAry2[1] = 100;

        char[] chAry1 = { 'A', 'B', 'C' };
        char[] chAry2 = { 'a', 'b', 'c', 'd', 'e' };
        chAry2 = chAry1;
        chAry1[2] = '다';



        //  ⭐️ 문자열은 객체(참조형)지만 원시형처럼 다뤄짐
        String str1 = "코인 함";
        String str2 = "관심 없음";
        str2 = str1; // 🔴

        str1 = "고점에 익절";// str2는 코인함으로 남아잇는다. 즉 참조형이나 원시형처럼 다뤄짐. 햇갈리지말것.



        //  상수 배열의 경우
        final int[] NUMBERS = {1, 2, 3, 4, 5};

        //  ⚠️ 다른 배열을 할당하는 것은 불가
        NUMBERS = new int[] {2, 3, 4, 5, 6};

        //  ⭐️ 배열의 요소를 바꾸는 것은 가능 즉 종이는 못바꾸나 글씨는 다른걸로 쓸수있따 이말.
        NUMBERS[0] = 11;



        //split이 문자열을 배열로 바꾼다면 조인은 그역순이다.
        String[] strings = {"한놈", "두시기", "석삼", "너구리"};

        //  💡 join 정적 메소드 - 문자열(정확히는 CharSequence)의 배열을 하나로 이어붙임
        //  첫 번째 인자를 각 사이에 삽입
        String join1 = String.join(", ", strings);
        String join2 = String.join("-", strings);
        String join3 = String.join(" 그리고 ", strings);
        String join4 = String.join("", strings);




        var intNum = 1;
        var doubleNum = 3.14;
        var charLet = 'A';
        var StringWord = "안녕하세요";

        //  ⚠️ 아래와 같이는 사용 불가
        //  컴파일러가 타입을 추론할 수 없는 상황
        var notInit; // 초기화가 안 됨
        var nullVar = null; // null로 초기화
        //js처럼 편하게 변수를 작성하는것이다. 명시하지않아도 알아서해ㅓ석.


        //  ⚠️ 자료형을 변경 불가
        intNum = 1.23;
        StringWord = 123; 이런건 불가.


        //  이후 배울 반복문에서 편리하게 사용
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }//지역변수처럼은 쓸수잇으나 클래스의 속성으로는 불가.



        //  배열의 경우 초기화시에 명시
        var chars = new char[] {'A', 'B', 'C', 'D', 'E'};
        //  var chars2 = {'A', 'B', 'C', 'D', 'E'}; // ⚠️ 불가

        for (var c : chars) {
            System.out.println(c);
        }

    }
}
