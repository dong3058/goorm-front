package section5;

public class chap01 {
    public static void main(String[] args) {
        //  각 문자는 상응하는 정수를 가짐
        char ch1 = 'A';
        char ch2 = 'B';
        char ch3 = 'a';
        char ch4 = 'a' + 1;
        char ch5 = '가';
        char ch6 = '가' + 1;//가가 아니라 각 이나옴.왜냐? 가의 유니코드가 44032 여기에 +1 해서 44033 각임
        char ch7 = '가' + 2;
        char ch8 = '가' + 3;
        char ch9 = '나';
        //string x=a+1 은 "a1"을돌려줌. 작동방식이 char이랑 다르다.
        int ch1Int = (int) ch1;//65저장 아스키코드. 어떻게보면 표현방식이다른 정수라고봐도됨.
        int ch9Int = (int) ch9;



        // 문자 리터럴과 숫자, 유니코드로 표현 가능
        char ch10 = 'A';
        char ch11 = 65;//애도 "A"임.
        char ch12 = '\u0041';







        char ch_a1 = 'A';
        int int_a1 = (int) ch_a1;//int int_a1 =  ch_a1; 이렇게 해도 정수로 변환됨.

        //  정수값을 얻는 다른 방법들 - 정수값과 연산하기
        int int_a2 = ch_a1 + 0;//++ch_a1 이란것도 가능하다. 이러면 애는 66
        int int_a3 = ch_a1 - 0;

        //  💡 리터럴에 더할 때와 변수에 더할 때 반환 자료형이 다름
        char ch_a2 = 'A' + 1;//66 즉 B가 나옴
        //char ch_a3 = ch_a1 + 1; // ⚠️ 불가 변수에 정수 더하는건 캐릭터에는 못들어간다.
        int int_a4 = ch_a1 + 1;//66



        //  💡 int 1과 char '1'은 다름! - 문자로서의 '1'
        //  - 해당 문자의 정수값 확인
        char ch_b1 = '1';//정수로 바꾸면 아스키코드가 1과다름 49임 정수로
        char ch_b2 = '2';

        //  ⚠️ 숫자 문자에 사칙연산 - 문자 번호 기준 결과 반환
        char ch_b3 = '1' + '2';// 아스키코드 기준 99에 해당도는 c가나옴.
        int int_b4 = ch_b1 + ch_b2;//애도 아스키코드합으로 99





        //  💡 아래의 기능으로 문자가 의미하는 정수로 변환
        int int_d1 = Character.getNumericValue('1');//이건 문자그대로 1로 바꿔버림.
        int int_d2 = Character.getNumericValue('2');

        //꼼수로 int x="1"-"0" 하면1값이나옴왜냐 0이 숫자들기준 아스키코드 시작점이기떄문.


        //  ⚠️ 빈 문자는 사용 불가, 공백(space)는 가능 빈 문자는 스페이스조차 없는애를 의미.
        //  - 이후 배울 문자열(String)과의 차이
        char empty = '';
        String emptyStr = "";//이거 문자열로는 된다.

        char space = ' ';



        // 왜냐 char은 결국 아스키 코드로 정수로 변환이 가능하기떄문이다.
        //  같은 문자열인지 여부 반환
        boolean bool1 = 'A' == 'A';
        boolean bool2 = 'A' == '가';

        //  숫자와 비교할 시 해당 정수값 기준으로
        boolean bool3 = 'A' == 65;
        boolean bool4 = 'A' > 64.0;
        boolean bool5 = 'A' > 66f;

        //  사전순 상 먼저 오는 쪽이 작음
        boolean bool6 = 'A' < 'B';
        boolean bool7 = '가' > '나';
    }
}
