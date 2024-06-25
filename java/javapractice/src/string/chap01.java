package string;

public class chap01 {
    public static void main(String[] args) {
        //  리터럴 방식, 스트링은 참조 자료형임. 그러나 특별히 원시형처럼 다루는게 가능함.
        String str1 = "Hello World!";
        String str2 = "안녕하세요 😆 반갑습니다~ 🖐️🖐️🖐️";

        // 빈 문자열 가능
        String str3 = "";

        //  인스턴스 생성 방식
        String str4 = new String("나중에 자세히 배웁니다.");







        String hl1 = "Hello";
        String hl2 = "Hello";
        String wld = "World";

        //  리터럴끼리는 == 을 사용하여 비교 가능 ,,,,같은 문자열이 적힌 리터럴 변수들은 같은 것을 가리킴 즉 같은 종이를 말한다.
        boolean bool1 = hl1 == hl2;//true
        boolean bool2 = hl1 == wld;//false

        String hl3 = new String("Hello");
        String hl4 = new String("Hello");
        String hl5 = hl4;//대입시 hl5에 hl4의 주소를 넘긴다.

        //  💡 인스턴스와 비교하려면 .equals 메소드를 사용해야 함
        //   특별한 경우가 아니면 문자열은 .equals로 비교할 것
        boolean bool3 = hl3 == hl4;//false why? 참조자료형이기에 서로 주소값이 다르다.

        boolean bool4 = hl1.equals(hl2);//문자열이 같은애인지 비교하느는것.
        boolean bool5 = hl1.equals(hl3);
        boolean bool6 = hl3.equals(hl4);
        boolean bool7 = wld.equals(hl2);

        //  같은 곳을 참조하는 인스턴스들
        boolean bool8 = hl4 == hl5;//이것은 true 왜냐면 주소가같으니까. 즉 ==은 같은종이에적혀있냐 이고 equals는 종이에쓰인 내용이같냐 이말.


        //  ⭐️ 각각의 메모리상 주소 식별자 비교
        int hl1hash = System.identityHashCode(hl1);
        int hl2hash = System.identityHashCode(hl2);
        int hl3hash = System.identityHashCode(hl3);
        int hl4hash = System.identityHashCode(hl4);
        int hl5hash = System.identityHashCode(hl5);




        String str_a1 = "안녕";

        boolean bool_a1 = str_a1.equals("안녕");

        //  💡 리터럴로 선언했어도 객체 인스턴스로 만들어짐
        //  때문에 객체의 기능인 메소드 사용 가능
        boolean bool_a2 = "안녕".equals("안녕");
        boolean bool_a3 = "안녕".equals(str_a1);





        String str_b1 = "Hello, ";
        String str_b2 = "World!";

        // + 연산자: 이어붙여진 결과를 반환
        String str_b3 = str_b1 + str_b2;





        //  += 연산자:
        //  1. ⭐️ 해당 변수에 문자열을 이어붙임 (부수효과)
        String str_c1 = "나는 아무 생각이 없다. ";
        str_c1 += "왜냐하면 ";//둘이 붙은 결과가 반환됨.



        //  2. 그 결과를 반환
        String str_c2 = str_c1 += "아무 생각이 없기 때문이다.";//앞에서 정수,실수혀에서 보여준것과 동일.

        boolean bool_c = (str_c1).equals(str_c2);



        int intNum = 123;
        float fltNum = 3.14f;
        boolean bool = true;
        char character = '가';

        String str_d1 = "자, 이어붙여볼까요? ";

        //  💡 문자열에 다른 자료형을 더하면 문자열로 이어붙여짐
        String str_d2 = str_d1 + intNum + fltNum + bool + character;//전부다 문자열로바뀜.





        //  💡 타 자료형으로부터 문자열로 변환
        String str1 = String.valueOf(true); //true를 "true"인 문자열의 형태로 돌려준다.
        String str2 = String.valueOf(false);
        String str3 = String.valueOf(123);
        String str4 = String.valueOf(3.14f);
        String str5 = String.valueOf('가');



        String str6 = true + "";//암죽적으로 문자열 변환 위에것과 기능적으론 같다,
        String str7 = 123.45 + "";




        String str123 = "123";

        //  문자열을 정수 자료형으로 변환하기
        byte bytNum = Byte.parseByte(str123);//래퍼클래스를 이용한다.
        short srtNum = Short.parseShort(str123);
        int intNum = Integer.parseInt(str123);
        long lngNum = Long.parseLong(str123);
        //Double.parseDouble도존재함.


        //  대소문자 무관 'true'일 때 true 반환
        boolean bool1 = Boolean.parseBoolean("TRUE");
        boolean bool2 = Boolean.parseBoolean("true");
        boolean bool3 = Boolean.parseBoolean("T");//false



        String strA = "A";

        //  다음 강에 배울 메소드
        char chr = strA.charAt(0);//해당되는 인덱스의 글자를 문자로 반환해라.


        //  ⚠️ 런타임 에러 발생. 하나씩 주석해제해서 테스트
        //  '실행'으로 테스트하거나, 디버그 후 콘솔 탭에서 확인해볼 것

        //byte bytNum2 = Byte.parseByte("12345"); 컴파일상은 문제가없으나 실행시에는 문제가 발생함. 12345가 바이트보다 커서 안된다.
        //int intNum2 = Integer.parseInt("123.45"); 실수이기에 불가.
        //double dblNum2 = Integer.parseInt("하나");
        //문자열에 뭐가들었는지에따라 오류가 발생할수있음.



        String str1 = "문자열에 "큰따옴표가" 안 들어가요";
        String str2 = "엔터도 안 들어가요. 못 믿겠으면 넣어봐.";


        //  실행하여 확인
        String str = "문자열에 \"큰따옴표\"도,\n엔터도 넣을 수 있다고?";//"를 문자열로 인식함.
        System.out.println(str);



        String table = "언어\t\t종류\t\t\t\t자료형\nJava\tcompiled\t\t정적\nPython\tinterpreted\t\t동적"//탭은 \t로
        System.out.println(table);


        char singleQuote = '\'';// ' 한개로 인식.
        System.out.println(singleQuote);

        String path = "C:\\Document\\MyCodings";// 백슬래시 한개를 표현하는거임. 두개 해주고싶으면 \\\ 해주면 "\\" 로인식.
        System.out.println(path);


    }
}
