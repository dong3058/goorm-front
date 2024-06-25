package method;

public class chap {
    public static void main(String[] args) {
        //자바의 모든것이 클래스의 요소이므로 함수도 메서드 라고부름.



        double x = 3, y = 4;

        System.out.printf("%f + %f = %f%n", x, y, x + y);
        System.out.printf("%f - %f = %f%n", x, y, x - y);
        System.out.printf("%f * %f = %f%n", x, y, x * y);
        System.out.printf("%f / %f = %f%n", x, y, x / y);

        x = 10; y = 2;

        System.out.printf("%f + %f = %f%n", x, y, x + y);
        System.out.printf("%f - %f = %f%n", x, y, x - y);
        System.out.printf("%f * %f = %f%n", x, y, x * y);
        System.out.printf("%f / %f = %f%n", x, y, x / y);

        x = 7; y = 5;

        System.out.printf("%f + %f = %f%n", x, y, x + y);
        System.out.printf("%f - %f = %f%n", x, y, x - y);
        System.out.printf("%f * %f = %f%n", x, y, x * y);
        System.out.printf("%f / %f = %f%n", x, y, x / y);


        double xx = 3, yy = 4;
        addSubtMultDiv(xx, yy);

        xx = 10; yy = 2;
        addSubtMultDiv(xx, yy);

        xx = 7; yy = 5;
        addSubtMultDiv(xx, yy);


        //  ⭐️ 반환한다는 것: 바꿔 쓸 수 있다는 것
        //  메서드 실행문을 메서드의 반환값으로 치환
        int int1 = add(2, 3);
        System.out.println(int1);

        System.out.println(add(4, 5));

        int int2 = add(add(6, 7), add(8, 9));
        System.out.println(int2);




        System.out.println("\n- - - - -\n");

        if (
                checkIfContain(
                        "Hello World",
                        "hello"
                )
        ) {
            System.out.println("포함됨");
        } else {
            System.out.println("포함 안 됨");
        }



        System.out.println(
                checkIfContain(
                        "Hello World",
                        "hello"
                ) ? "포함됨" : "포함 안 됨"
        );







        int count1 = getCount();//1
        int count2 = getCount();//2
        int count3 = getCount();//3
        int count4 = getCount();//4
    }

    //  ⭐️ 메인 메소드 외부에 선언할 것
    static void addSubtMultDiv (double a, double b) {//void는 아무것도 반환하지않는다는말.
        System.out.printf("%f + %f = %f%n", a, b, a + b);
        System.out.printf("%f - %f = %f%n", a, b, a - b);
        System.out.printf("%f * %f = %f%n", a, b, a * b);
        System.out.printf("%f / %f = %f%n", a, b, a / b);
    }

    static int add (int num1, int num2) {
        return num1 + num2;
    }



    static boolean checkIfContain (String text, String token) {//마지막 메서드가 boolen을 반환하므로
        //boolean을 적어준다.
        return text.toLowerCase().contains(token.toLowerCase());
    }



    //  매개변수도, 반환값도 없는 메소드
    static void sayHello () {// no input no output
        System.out.println("안녕하세요!");
    }


    static int count = 0;

    //  매개변수 없이 값만 반환하는 메소드
    //  외부 변수 값을 변화시킴 (static이므로 static 변수만 가능) 단 그렇게 썩좋은 방법은아니다.
    static int getCount () {//반환값에 int 말고 short넣으면 오류 카운트가 인트니까 그러나 longd은 가능.
        System.out.println("카운트 증가");
        return ++count;
    }



    static double getAverage (int[] nums) {//정수배열을 받아서 실수를 반환.

        double sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum / nums.length;
    }




    //  자바의 메소드는 하나의 값만 반환 가능
    //  여러 값을 반환하려면 배열 또는 이후 배울 객체를 활용
    static int[] getMaxAndMin (int[] nums) {//졍수배열을 받아서 정수배열을 돌려준다는 말.
        //인자는 여러개를 받아도 반환값 자체는 한개만된다. 그러니까 배열을 반환한다이말.

        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = max > num ? max : num;
            min = min < num ? min : num;
        }

        return new int[] {max, min};
    }




    //  💡 ... 연산자 : 해당 위치 뒤로 오는 연산자들을 배열로 묶음
    //  int[] (배열 자체를 받음)과는 다름!
    static double getAverage(int... nums) {//인자를 몇개로 받을지 모를떄 즉 몇개가 오든 상관없을떄.
        //js의 나머지 구문과 같다. (1,2,3)-->[1,2,3]이렇게 돌려주다는말. 아니면 그냥 배열을 넣어도됨.
        double result = 0.0;
        for (int num : nums) {
            result += num;
        }
        return result / nums.length;
    }



    //  ⭐️ 다른(정해진) 인자들과 사용시 맨 마지막에 놓을 것 js 나머지 구문과 동일하다.
    static String descClass (int classNo, String teacher, String... kids) {
        return "%d반의 담임은 %s 선생님, 원생들은 %s 입니다."
                .formatted(classNo, teacher, String.join(", ", kids));
    }




    String class3Desc = descClass(3, "목아진", "짱구", "철수", "훈이");

    String[] kids = {"짱구", "철수", "훈이"};
    String class3DescByArr = descClass(3, "목아진", kids);

}
