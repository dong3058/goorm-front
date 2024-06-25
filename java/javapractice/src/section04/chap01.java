package section04;

public class chap01 {
    public static void main(String[] args) {
        double a = 0.1, b = 0.2;

        //  ⚠️ 오차가 생김
        double c = a + b;//c=0.300000000
        boolean bool=0.1+0.2==0.3;//false


        //  float의 최대값과 최소값
        float fMin = -Float.MAX_VALUE;
        float fMax = Float.MAX_VALUE;

        //  double의 최대값과 최소값
        double dMin = -Double.MAX_VALUE;
        double dMax = Double.MAX_VALUE;

        //  최소 절대값
        float fAbsMin = Float.MIN_VALUE;
        double dAbsMin = Double.MIN_VALUE;

        // ⭐ double이 범위도 넓고, 정밀도도 높음 확인
        boolean bool1 = Float.MAX_VALUE < Double.MAX_VALUE;//true
        boolean bool2 = Float.MIN_VALUE > Double.MIN_VALUE;//true
        //즉 표현범위가 double가 훨신크다는말.

        //  최대 정밀도 테스트
        double dblNum = 0.123456789123456789;
        float fltNum = 0.123456789123456789f; //0.123456789 ㄲ지만표현 더블은 더길게



        //  float은 뒤에 f 또는 F를 붙여 표현
        float flt1 = 3.14f;//3.14만써도 오류인대 f가없으면 기본적으류ㅗ 더블로보므로 큰애는 작은애게 못감.
        double dbl1 = 3.14;

        //  ⚠️ float에는 double을 담을 수 없음
        float flt2 = dbl1;//(float)로 명시적으로 바꾸면 ㄱㄴ
        //  반대는 가능
        double dbl2 = flt1;



        long lng1 = 123;

        //  정수를 대입할 시 묵시적 변환
        //  💡 float(4바이트)에도 long(8바이트)의 값 담을 수 있음
        float flt3 = lng1;//long이더큰대 된다 왜인지는 ㅁㄹ
        double dbl3 = lng1;

        long lng2 = Long.MAX_VALUE;

        //  ⭐ 큰 수(정확히 표현가능한 한도를 넘어서는)일 경우
        //  가능한 최대 정확도로
        float flt4 = lng2;
        double dbl4 = lng2;





        //  💡 복합 대입 연산자와 단항 연산자
        float fl5 = 123.45F;
        fl5 += 6.78;
        fl5++; // 🔴
        fl5++;
        fl5--;





        float flt01 = 4.124f;
        float flt02 = 4.125f;
        double dbl01 = 3.5;

        // float끼리의 연산은 float 반환
        float flt03 = flt01 + flt02;

        //  float과 double의 연산은 double 반환
        float flt04 = flt01 + dbl01; // ⚠️ 불가 즉 double로 받아야됨.

        //  부동소수점 방식상 오차 자주 있음
        double dbl02 = 0.2 + 0.3f;
        double dbl03 = 0.2f * 0.7f;
        double dbl04 = 0.4 - 0.3;
        double dbl05 = 0.9f / 0.3;
        double dbl06 = 0.9 % 0.6;

        //  소수부가 2의 거듭제곱인 숫자간 연산은 오차 없음
        double dbl07 = 0.25 * 0.5f;
        double dbl08 = 0.5 + 0.25 + 0.125 + 0.0625;
        double dbl09 = 0.0625f / 0.125;






        int int1 = 5;
        float flt1 = 2f;
        double dbl1 = 3;
        double dbl2 = 7;

        //  💡 정수 자료형과 실수 자료형의 계산은 실수 반환
        int flt2 = int1 / flt1; // ⚠️ 불가
        double dbl3 = int1 / dbl1;
        double dbl4 = dbl2 / int1;

        //  💡 리터럴로 작성시 double임을 명시하려면 .0을 붙여줄 것
        double dbl5 = 5 / 2;//정수자료형은 그냥 실수에 넣을수있다.단 명시적처ㅣ를 원함ㄴ ,0을 붙일것
        double dbl6 = 5.0 / 2;
        double dbl7 = (double) 5 / 2;


        float fltNum = 4.567f;
        double dblNum = 5.678;

        //  💡 정수 자료형에 강제로 넣으면 소수부를 '버림'
        int int2 = (int) fltNum;//4
        int int3 = (int) dblNum;//5임




        int int1 = 5;
        float flt1 = 5f;
        double dbl1 = 5.0;
        double dbl2 = 7.89;

        //  💡 정수/실수간, 다른 숫자 자료형간 사용 가능
        boolean bool0 = 123 == 123F;

        boolean bool1 = int1 == flt1;
        boolean bool2 = flt1 == dbl1;
        boolean bool3 = int1 == dbl2;

        boolean bool4 = int1 > dbl2;
        boolean bool5 = flt1 >= dbl2;
        boolean bool6 = dbl1 < dbl2;
    }
}
