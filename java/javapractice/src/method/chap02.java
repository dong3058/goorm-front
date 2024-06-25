package method;

public class chap02 {
    public static void main(String[] args) {


        int res1 = add(1, 2); // 🔴 스텝인투로 들어가 볼 것 3을 반환.
        int res2 = add(3, 4, 5);
        double res3 = add(1.2, 3.4);
        String res4 = add("로보트 태권", 'V');
        String res5 = add('X', "Men");





        int intNum = 3;
        modifyIntArg(intNum);// 3 4 가 나옴.

        int[] intNums = {1, 2, 3};

        //  배열은 참조형이지만 그 안의 값들은 원시형
        modifyIntArg(intNums[0]);// 1 하고 2나옴. 왜냐 인자한개를 골라넣었기떄문 배열의.
        //즉 intnums는 여기서도 133 이다 왜냐 아래함수가 작동ㅎ했으니까.

        //  참조형인 배열 자체를 인자로 사용
        modifyAryElem(intNums);//배열의 주소가 복사되었다. 원본에 형향을주므로 intnums=1 3 3 이됨.

    }


    static int add(int a, int b) { return a + b; }

    //  매개변수의 개수가 다름
    static int add(int a, int b, int c) { return a + b + c; }

    //  매개변수의 자료형이 다름
    static double add(double a, double b) { return a + b; }

    //  매개변수의 자료형 순서가 다름
    static String add(String a, char b) { return a + b; }
    static String add(char a, String b) { return a + b; }
    //즉 매개변수의 갯수와 자료형이 다를때만 된다.
    //  ⚠️ 반환 자료형이 다른 것은 오버로딩 안 됨 - 다른 함수명 사용
    //메서드 오버로딩이라함.
    //  static double add(int a, int b) { return (double) (a + b); }






    //  ⭐️ 원시값은 '복사해서' 가져옴
    //  메소드 내부에서 값을 변경해도 원본에 영향 끼치지 않음
    static void modifyIntArg (int num) {
        System.out.printf("수정 전: %d%n", num++);
        System.out.printf("수정 후: %d%n", num);
    }

    //  ⭐️ 참조값은 주소값이므로 원본 그 자체를 가리킴
    static  void modifyAryElem (int[] ary) {
        System.out.printf("수정 전: %d%n", ary[1]++);
        System.out.printf("수정 후: %d%n", ary[1]);
    }



    //잘안쓴다 권장 x
    static void upTo5 (int start) {
        System.out.println(start);
        if (start < 5) {
            upTo5(++start);
        } else {
            System.out.println("-- 종료 --");
        }
    }



    static int factorial (int num) {
        return num == 0 ? 1 : num * factorial(--num);
    }
}
