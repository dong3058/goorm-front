package section3;

public class ex01 {
    public static void main(String[] args) {
        byte _1b_byte = 1;
        short _2b_short = 2;
        int _4b_int = 3; // ⭐️ 일반적으로 널리 사용
        long _8b_long = 4;



        //  ⚠️ 자료형의 범주 외의 수를 담을 수 없음
        byte overByte1 = 127;
        byte overByte2 = 128;
        byte overByte3 = -128;
        byte overByte4 = -129;




        //  큰 자료형에 작은 자료형의 값을 넣을 수 있음
        //  💡 묵시적(암시적) 형변환
        //담는값은 같은대 통의 크기가 달라졌다는말.
        _2b_short = _1b_byte;
        _4b_int = _1b_byte; _4b_int = _2b_short;
        _8b_long = _1b_byte; _8b_long = _2b_short; _8b_long = _4b_int;

        //  ⚠️ 작은 자료형에 큰 자료형의 값을 '그냥' 넣을 수 없음
        //  들어있는 값의 크기와 무관
        // 즉 int 의1 이라도 byte로 넣는것은 불가하다.
        _1b_byte = _2b_short; _1b_byte = _4b_int; _1b_byte = _8b_long;
        _2b_short = _4b_int; _2b_short = _8b_long;
        _4b_int = _8b_long;


        //  ⭐ int의 범위를 벗어나는 수에는 리터럴에도 명시 필요
        //  끝에 l 또는 L을 붙여 볼 것
        long _8b_long1 = 123456789123456789;

        //  💡 가독성을 위해 아래와 같이 표현 가능 (자바7부터)
        int _4b_int2 = 123_456_789;
        long _8b_long2 = 123_456_789_123_456_789L;



        byte byteNum;
        int smallIntNum = 123;

        //  명시적(강제) 형변환
        //  - 개발자 : "내가 책임질테니까 그냥 넣으세요."
        byteNum = (byte) smallIntNum;


        int intNum = 12345;

        //  ⚠️ 강제로 범주 외의 값을 넣을 경우 값 손실
        byteNum = (byte) intNum; // 💡 12345 % 128

        int a = 1 + 2;
        int b = a - 1;
        int c = b * a;
        int d = a + b * c / 3;
        int e = (a + b) * c / 3;
        int f = e % 4;




        int a = 1;
        int b = 2;

        //  int끼리 연산은 int 반환
        int c = a + b;

        long d = a + b;
        short e = a + b; // ⚠️ 묵시적으로는 불가
        short f = (short) (a + b);

        //int  m=e+f; 작은애가 큰거로는 된다.

        byte b1 = 1;
        byte b2 = 2;
        short s1 = 1;
        short s2 = 2;

        //  ⚠️ 아래는 모두 불가
        byte b3 = b1 + b2;
        short s3 = b1 + b2;
        short s4 = b1 + s2;
        short s5 = s1 + s2;

        //  ⭐ byte와 short의 연산들은 int 반환
        //  그냥 int를 많이 쓰는 이유 중 하나
        int i1 = b1 + b2;
        int i2 = s1 + s2;
        int i3 = b1 + s1;




        long l1 = 1;
        long l2 = 2;

        // long끼리의 연산은 long 반환
        int l3 = l1 + l2;




        //  ⚠️ 정수 자료형의 계산은 소수점 아래를 '버림'
        byte int1 = 5/2;
        int int2 = 10;
        int int3 = 3;
        int int4 = int2 / int3;





        // 💡 홀수와 짝수 구분에 널리 사용
        int aa = 1 % 2;
        int bb = 2 % 2;
        int cc = 3 % 2;
        int dd = 4 % 2;
        int ee = 5 % 2;
        int ff = 6 % 2;
        int gg = 7 % 2;



        int a = 1;
        a = a + 2;

        a += 3; // 🔴

        // 값을 반환하기도 함
        int b = a += 4; // 🔴
        //a+=4 는4만큼 늘리고 그에 이어서 b에다가 값을 넣음.


        //  💡 추가
        //  - 일반 대입 연산자도 값을 반환함

        int i1 = 0;
        int i2 = 1;
        int i3 = (i1 = i2); // 괄호 제거해도 같음

        String s1 = "ABC";
        String s2 = "가나다";
        String s3 = (s1 = s2);
            //s3는 s2값이 최족정으로 나옴.


        int int1 = 3;

        int int2 = int1++; // 🔴
        int int3 = ++int1;
        int int4 = -(int2-- * --int3);

        //int2 의경우3이 되고 int1=4 그후에 int3은 5 int1=5 이고
        //int5는 int2-- *--int3 이이므로  3*4==12 int2 2 int 3 4가된다.
        //연산자가 앞에붙으면 변동과 초기화가 동ㅣ에 뒤에붙으면 변동이 나중에붙음.

        int x = 1;

        //  메서드 안으로도 '반환'되어 사용되는 것
        System.out.println(x++);// 1
        System.out.println(++x);// 3
        System.out.println(x);//2
        // 이기호는 int x=++1과같이 리터럴에 직접사용은 불가능하다.76
    }
}
