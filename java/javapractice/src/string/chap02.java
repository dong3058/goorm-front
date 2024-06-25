package string;

public class chap02 {
    public static void main(String[] args) {
        // 문자열을 불면 즉 js에서 원본바꾸는 메서드가 거의없다싶이 대부분의 메서드는 종이를 새로만들어서 거기게 새 내용을 쓰는것.



        int int1 = "".length();
        int int2 = "헬로".length();
        int int3 = "Hello".length();
        int int4 = "김수한무 거북이와 두루미".length();
        //길아반환 메서드.




        String str1 = "";//진짜로 비어잇는것.
        String str2 = " \t\n";

        int int1 = str1.length(); //0
        int int2 = str2.length();//2

        //  💡isEmpty : 문자열의 길이가 0인지 여부
        boolean bool1 = str1.isEmpty(); //true

        boolean bool2 = str2.isEmpty(); //false

        //  💡isBlank : 공백(white space)을 제외한 문자열의 길이가 0인지 여부 즉 \t \n을 의미.
        boolean bool3 = str1.isBlank();//공백을 제외함 ㅇㅇ;
        boolean bool4 = str2.isBlank();



        String str3 = "\t 에 네 르 기 파!! \n";

        //  💡 trim : 앞뒤의 공백(white space) 제거
        String str4 = str3.trim();//"에 네 르 기 파!!" 글자들 사이에는 공백인 존재함.
        // str3=str3.trim()--> str4와 같은 종이를 바라본다.

        String str1 = "아야 슬슬 오함마 준비해야 쓰것다";

        //  💡 charAt : ~번째 문자 반환
        char ch1 = str1.charAt(0);
        char ch2 = str1.charAt(4);

        //  ⭐️ 마지막 문자 얻기
        char ch3 = str1.charAt(str1.length() - 1);




        String str2 = "얄리 얄리 얄라셩 얄라리 얄라";

        //  💡 indexOf/lastIndexOf : 일치하는 첫/마지막 문자열의 위치
        //  앞에서부터 카운트해서 int로 반환

        //  두 번째 인자 : ~번째 이후/이전부터 셈
        int int1 = str2.indexOf('얄');//아스키코드가 들어간다.
        int int2 = str2.indexOf('얄', 4);//4는 탐색을 시작할 인덱스를 말함.

        int  int3 = str2.indexOf("얄라");
        int  int4 = str2.lastIndexOf("얄라");
        int  int5 = str2.lastIndexOf("얄라", 12);

        //  💡 포함되지 않은 문자는 -1 반환
        int int6 = str2.indexOf('욜');//사실상 JS에 그것과 같다. JS도 LET X="X" LET Y="X"가 같다 왜냐 주소가같으니까.


        //  💡 equals : 대소문자 구분하여 비교
        String str_a1 = "Hello World";
        String str_a2 = new String("Hello World");
        String str_a3 = "HELLO WORLD";

        boolean bool_a0 = str_a1 == str_a2;  // ⚠️ 문자열은 이렇게 비교하지 말 것!

        boolean bool_a1 = str_a1.equals(str_a2);
        boolean bool_a2 = str_a1.equals(str_a3);

        //  💡 equalsIgnoreCase : 대소문자 구분하지 않고 비교
        boolean bool_a3 = str_a1.equalsIgnoreCase(str_a3);
        boolean bool_a4 = str_a2.equalsIgnoreCase(str_a3);




        String str_b1 = "옛날에 호랑이가 한 마리 살았어요.";

        //  💡 contains : 포함 여부
        boolean bool_b1 = str_b1.contains("호랑이");
        boolean bool_b2 = str_b1.contains("나무꾼");

        //  💡 startsWith : (주어진 위치에서) 해당 문자열로 시작 여부
        boolean bool_b3 = str_b1.startsWith("옛날에");//TRUE
        boolean bool_b4 = str_b1.startsWith("호랑이");
        boolean bool_b5 = str_b1.startsWith("호랑이", 4);//애는 true 탐색 위치를 4부터하므로

        //  💡 endsWith : 해당 문자열로 끝남 여부
        boolean bool_b6 = str_b1.endsWith("살았어요.");
        boolean bool_b7 = str_b1.endsWith("호랑이");




        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        String str_c1 = "yalco@yalco.kr";
        String str_c2 = "yalco.yalco.kr";
        String str_c3 = "yalco@yalco@kr";

        boolean bool_c1 = str_c1.matches(emailRegex);
        boolean bool_c2 = str_c2.matches(emailRegex);
        boolean bool_c3 = str_c3.matches(emailRegex);



        String str_a1 = "ABC";
        String str_a2 = "ABCDE";
        String str_a3 = "ABCDEFG";

        //  💡 compareTo : 사전순 비교에 따라 양수 또는 음수 반환

        //  같은 문자열이면 0 반환
        int int_a1 = str_a1.compareTo(str_a1);

        //  시작하는 부분이 같을 때는 글자 길이의 차이 반환 정확인 같은부분까지 넘어가다가 달라지는 시점을 기준으로.
        int int_a2 = str_a1.compareTo(str_a2);
        int int_a3 = str_a1.compareTo(str_a3);
        int int_a4 = str_a2.compareTo(str_a3);
        int int_a5 = str_a3.compareTo(str_a1);

        String str_a4 = "HIJKLMN";

        //  시작하는 부분이 다를 때는 첫 글자의 정수값 차이 반환
        int int_a6 = str_a1.compareTo(str_a4);//abcdefgh h와 a가 7만큼 떨어져있고 비교가 a기준이므로 -7
        int int_a7 = str_a4.compareTo(str_a3);//애는 반대로 8.



        String str_b1 = "abc";
        String str_b2 = "DEF";

        int int_b1 = str_b1.compareTo(str_b2);//애는 대문자 기준인지라 아스키코드에 따라서? 29가반환됨. 실제로 29만큼 차이가남.
        //a는 97이고 D는 68이다.

        //  💡 compareToIgnoreCase : 대소문자 구분 없이 비교
        int int_b2 = str_b1.compareToIgnoreCase(str_b2);//소문자여서 -3이고




        String str_a1 = "Hello, World!";

        // 💡 toUpperCase / toLowerCase : 모두 대문자/소문자로 변환
        String str_a2 = str_a1.toUpperCase();
        String str_a3 = str_a1.toLowerCase();




        String str_b1 = "Hi! How are you? I'm fine. Thank you!";
        String str_b2 = "how";

        boolean bool_b1 = str_b1.contains(str_b2);

        //  ⭐️ 영문 텍스트에서 대소문자 무관 특정 텍스트 포함 여부 확인시
        boolean bool_b2 = str_b1
                .toUpperCase()
                .contains(str_b2.toUpperCase());

        boolean bool_b3 = str_b1
                .toLowerCase()
                .contains(str_b2.toLowerCase());




        //  💡 concat : 문자열을 뒤로 이어붙임
        String str_a1 = "슉-";
        String str_a2 = "슈슉-";
        String str_a3 = "슈슈슉-";

        String str_a4 = str_a1 + str_a2 + str_a3;

        String str_a5 = str_a1.concat(str_a2);

        //  ⭐️ 메서드 체이닝
        String str_a6 = str_a1
                .concat(str_a2)
                .concat(str_a3)
                .concat(str_a4)
                .concat(str_a5);




        //  ⭐️ + 연산자와의 차이

        String str_b1 = "ABC";

        //  1. concat에는 문자열만 이어붙일 수 있음
        String str_b2 = str_b1 + true + 1 + 2.34 + '가';
        String str_b3 = str_b1
                //  .concat(true)
                //  .concat(1)
                //  .concat(2.34)
                //  .concat('가')
                ;
        //애내는 다오류임.

        //  2. concat은 필요시에만 새 인스턴스 생성 (큰 의미 없음)
        String str_b4 = str_b1 + "";
        String str_b5 = str_b1.concat("");

        int str_b1Hash = System.identityHashCode(str_b1);
        int str_b4Hash = System.identityHashCode(str_b4);
        int str_b5Hash = System.identityHashCode(str_b5);



        //  3. null이 포함될 경우

        String str_c1 = null;

        //  + 연산자는 null과 이어붙이기 가능
        String str_c3 = str_c1 + null + "ABC";

        //  ⚠️ concat은 NullPointerException 발생 자료형이 문자이고 null이 아닌것이여아한ㄴ다.
        //String str_c4 = str_c1.concat("ABC");
        //String str_c5 = "ABC".concat(str_c1);




        //  4. ⭐️ 다중 연산시 생성되는 문자열 인스턴스의 수가 다름

        String str_d1 = "a" + "b" + "c" + "d";

        // + 연산은 내부적으로 아래와 같이 최적화됨 (이후 배움)
        String str_d2 = new StringBuilder("a")
                .append("b")
                .append("c")
                .append("d")
                .toString(); // "abcd"가 생성됨
        // "a", "b", "c", "d", "abcd"가 생성되어 메모리 차지

        //  concat은 매 번 문자열을 반환하므로
        String str_d3 = "a"
                .concat("b") // "ab"가 생성됨
                .concat("c") // "abc"가 생성됨
                .concat("d"); // "abcd"가 생성됨
        // "a", "b", "c", "d", "ab", "abc", "abcd"가 생성되어 메모리 차지


        String str_a1 = "덜컹";

        // 💡 repeat : 문자열을 주어진 정수만큼 반복
        String str_a2 = str_a1.repeat(2);
        String str_a3 = str_a1
                .concat(" ")
                .repeat(3)//애는 "덜컹 " 이걸 3번 반복한다는말.
                .trim();



        String str_b1 = "대한민국 다 job 구하라 그래";

        //  💡 substring : ~번째 문자부터 (~번째 문자까지) 잘라서 반환
        String str_b2 = str_b1.substring(7);
        String str_b3 = str_b1.substring(7, 10);//js랑 다르게 시작점 +1~끝쩜 까지를 구함.
        String str_b4 = str_b1.substring(11, 14);

        String piece1 = "다 ";
        String piece2 = "구하라";
        String str_b5 = str_b1.substring(
                str_b1.indexOf(piece1),
                str_b1.indexOf(piece2) + piece2.length()





                //  💡 replace : 주어진 앞의 문자(열)을 뒤의 문자(열)로 치환
                String str_c1 = "점심에 보쌈집에 가서 수육을 먹었다.";
        String str_c2 = str_c1.replace("보쌈", "중국");

        //  여럿 포함시 모두 치환
        String str_c3 = "밥 좀 먹자, 응? 야, 밥 좀 먹자고 밥 밥 밥";
        String str_c4 = str_c3.replace('밥', '빵');

        // ⭐️ 원본은 바뀌지 않는 점 확인
        );





        //  메서드 체이닝
        String str_d1 = "하여튼 호의가 반복되면 권리인 줄 알아";
        String str_d2 = str_d1
                .replace("하여튼", "아무튼")
                .replace("호의", "호이".repeat(2))
                .replace("권리", "아기공룡 둘리");




        String str_e1 = "02=123.4567_8900";

        //  💡 replaceAll / replaceFirst : ⭐️ 정규표현식 사용 가능
        //  전부 치환 / 첫 번째 일치부분만 치환
        String str_e2 = str_e1
                .replaceAll("[=._]", "-")
                .replaceFirst("[-@#]", ")");





        String str1 = "가나다라마";
        String str2 = "010-1234-5678";
        String str3 = "하나 둘 셋 넷 다섯";

        //  💡 toCharArray : 문자열을 분할하여 문자의 배열로 반환
        char[] chAry1 = str1.toCharArray();//[가,나,다,라,마]
        char[] chAry2 = str3
                .replace(" ", "")
                .toCharArray();//[하,나,둘,셋,넷,다,섯] 이렇게나옴. repalement를 없애면 " "도 포함됨.

        //  💡 split : 주어진 기준으로 (~개까지) 분할하여 문자열 배열로 반환
        String[] strAry1 = str1.split("");
        String[] strAry2 = str2.split("-");
        String[] strAry3 = str3.split(" ");
        String[] strAry4 = str3.split(" ", 3); //[하나,둘,셋 넷 다섯]




        String str1 = "%s의 둘레는 반지름 X %d X %f입니다.";

        String circle = "원";
        int two = 2;
        double PI = 3.14;

        //  💡 formatted : 주어진 형식에 따라 문자열 생성
        //  ⭐️ 13+버전에 추가됨. 편의상 강의에서 많이 사용할 것
        String str2 = str1.formatted(circle, two, PI);//포맷팅 하는 방법.당연히 새문자열을 반환함. 또한 들어갈자리는 c언어처럼 표시함.

        //  💡 이전 버전에서의 방식. 실무에서 사용하려면 기억
        String str3 = String.format(str1, circle, two, PI);// 순서대로 원본,넣을 데이터들.



        //  ⭐️ 시스템의 printf 메소드 : String.format과 같은 형식으로 출력
        //  줄바꿈을 하지 않으므로 직접 넣어줘야 함
        System.out.printf("%s의 둘레는 반지름 X %d X %f입니다.%n", circle, two, PI);//%n은 줄바굼임





        System.out.printf("%d, %5d, %05d%n- - - - -%n%n", 123, 123, 123);
        //%5d의 경우 123 이므로 앞에 공백 2개 %05d의 경우 00123 이렇게채움.






        //  💡 정수 다양하게 포매팅하기
        String[] intFormats = {
                "%d",        // 1. 기본
                "%13d",      // 2. n 자리수 확보, 오른쪽 정렬
                "%013d",     // 3. 빈 자리수 0으로 채움
                "%+13d",     // 4. 양수는 앞에 + 붙임 +12 +2345 이렇게말이다. +도 한칸씩 차지함.
                "%,13d",     // 5. 쉼표 사용 3자리마다 쉼표붙임.
                "%-13d",     // 6. 자리수 확보, 왼쪽 정렬
                "%+,013d"    // 7.
        };

        String[] intResults = new String[intFormats.length];

        // 이후의 배울 for 반복문
        // - 위의 형식들로 하나하나 출력해보는 코드
        for (var i = 0; i < intFormats.length; i++) {
            String format = (i + 1) + ". ";
            for (var j = 0; j < 4; j++) {
                format += intFormats[i] + " ";
            }
            format = format.trim() + "%n%n";  // "%d %d %d %d%n%n" ...
            //  System.out.println(format); // 🔍 주석해제하여 함께 확인

            //  🔍 이 숫자들을 스페이스로 구분해서 출력해 볼 것
            System.out.printf(format, 12, 2345, 67890, -1234567);

            //  ⭐️ formatted 메소드에서도 사용 가능
            intResults[i] = format.formatted(12, 2345, 67890, -1234567);



            //  💡 실수 다양하게 포매팅하기
            String[] fltFormats = {
                    "%f",       // 1. 기본 (소수점 6자리, 0으로 메움)
                    "%.2f",     // 2. 소수점 n자리까지
                    "%13.2f",   // 3. 정수자리 확보, 소수자리 제한 여기선 13자리의 정수와 2개의 소수점을 의미.
                    "%,f",      // 4
                    "%+013.2f",  // 5
                    "%-13.2f",  // 6
            };

            String[] fltResults = new String[fltFormats.length];

            for (var i = 0; i < fltFormats.length; i++) {
                String format = (i + 1) + ". ";
                for (var j = 0; j < 4; j++) {
                    format += fltFormats[i] + " ";
                }
                format = format.trim() + "%n%n";

                System.out.printf(format, 1.2, 123.456, 1234.123456789, -123.4567);

                fltResults[i] = format.formatted(1.2, 123.456, 1234.123456789, -123.4567);
            }





            //  💡 문자열 다양하게 포매팅하기
            String[] strFormats = {
                    "%s",    // 1. 기본
                    "%9s",   // 2. 자리 확보
                    "%.2s",  // 3. ~글자만
                    "%9.2s", // 4. 9자리를 스되 2개만 남긴다이말.
                    "%-9s",  // 5. 왼쪽 정렬
            };

            String[] strResults = new String[strFormats.length];

            for (var i = 0; i < strFormats.length; i++) {
                String format = (i + 1) + ". ";
                for (var j = 0; j < 2; j++) {
                    format += strFormats[i] + " ";
                }
                format = format.trim() + "%n%n";

                System.out.printf(format, "Hello", "하이염");

                strResults[i] = format.formatted("Hello", "하이염");
            }




            String emptyStr = "";
            String nullStr = null;

            //  ⭐️ 빈 문자열과 null은 다름
            boolean bool1 = emptyStr == nullStr;

            //  ⚠️ null은 문자열 인스턴스 메소드 사용 불가
            //  아래의 코드들은 모두 런타임 에러를 발생시킴
            //  int int1 = nullStr.length(); 오류 즉 널자체는 비어있다는 문자열 그이상으로 업다는뜻.
            //  즉 널은 종이가 백지인 ""와 다르게 널은 종이가업다.
            //boolean bool2 = nullStr.equals(emptyStr);
            //String str1 = nullStr.concat("ABC");






            //  💡 문자열을 외부로부터 받아올 경우 등...
            String defaultStr =
                    (nullStr != null && !nullStr.isEmpty())
                            ? nullStr : "(기본값)";




            //  💡 초기화되지 않은 변수와 비교
            String notInitStr;//초기화 자체가 안됨. 컴파일 단계에서 오류
            String nullStr2 = null;

            //  ⚠️ 컴파일 오류 발생
            System.out.println(notInitStr);

            //  코드에 따라 정상실행 또는 런타임 오류
            System.out.println(nullStr2);




            //  ⭐️ 이 외에도 참조 자료형의 인스턴스는 null 가능 스트링도 포함.
            Object obj = null;
            System sys = null;

            //  ⭐️ 원시값들도 참조 자료형의 인스턴스로는 null 가능
            Integer nullInt1 = null;
            Double nullDbl1 = null;
            Boolean nullBool1 = null;
            Character nullChr1 = null;

            //  ⚠️  원시값은 불가
            //int nullInt2 = null;
            //double nullDbl2 = null;
            //boolean nullBool2 = null;
            //char nullChr2 = null;
        }
    }
}
