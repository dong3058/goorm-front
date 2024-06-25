package section6;

public class chap01 {
    public static void main(String[] args) {
        boolean bool3 = !true;
        boolean bool4 = !false;

        boolean bool5 = !!bool3;//반대의 반대이렇게 바뀜.
        boolean bool6 = !!!bool3;

        boolean bool7 = !(1 > 2);
        boolean bool8 = !((5 / 2) == 2.5);
        boolean bool9 = !((3f + 4.0 == 7) != ('A' < 'B'));//비교연산자의 결고도 불리언이므로 당연히 가능함.


        boolean bool1 = true && true;
        boolean bool2 = true && false;
        boolean bool3 = false && true;
        boolean bool4 = false && false;

        boolean bool5 = true || true;
        boolean bool6 = true || false;
        boolean bool7 = false || true;
        boolean bool8 = false || false;//일반적인 연산자와 동일함.



        int num = 4;

        boolean isPositiveAndOdd = num >= 0 && num % 2 == 1;
        boolean isPositiveOrOdd = num >= 0 || num % 2 == 1;

        boolean isPositiveAndEven = num >= 0 && num % 2 == 0;
        boolean isPositiveOrEven = num >= 0 || num % 2 == 0;


        num = 6;

        //  💡 &&가 ||보다 우선순위 높음
        boolean boolA = (num % 3 == 0) && (num % 2 == 0) || (num > 0) && (num > 10);//ture
        boolean boolB = (num % 3 == 0) && ((num % 2 == 0) || (num > 0)) && (num > 10);//true



        //단축평가 and는 앞에것의 fasle면 앞만하고 or은 true에서 마찬가지

        int a = 1, b = 2, c = 0, d = 0, e = 0, f = 0;

        boolean bool1 = a < b && c++ < (d += 3);//true 앤드에다가 앞에가 true이기에 뒤도 연산
        boolean bool2 = a < b || e++ < (f += 3);//e=0 f=0 true 애는 앞이 trueㄹ서 뒤는 단축평가로인해서 스킵됨.

        boolean bool3 = a > b && c++ < (d += 3); // 🔴 a1 b2 c1 d3 에는 반대로 앞에가 false라서 ㅈ꼐산x

        boolean bool4 = a > b || e++ < (f += 3);//애는 두에거 계산실랭 e=1 f=3




        // a?b:c a가 treu이면 b를 false 이면 c를 준다는말.
        int num1 = 3, num2 = 4;

        char num1OE = num1 % 2 == 1 ? '홀' : '짝';//홀
        char num2OE = num2 % 2 == 1 ? '홀' : '짝';//짝



        int num = 3;

        //  아래 값들을 바꿔가며 실행해 볼 것
        boolean mult2 = true;
        //mult2 = false;

        boolean plus5 = true;
        //plus5 = false;

        System.out.println(
                (!mult2 && !plus5) ? num
                        : (mult2 && plus5) ? num * 2 + 5
                        : mult2 ? num * 2
                        : num + 5
        );

    //연속해ㅓ 쓴건대 첫번쨰 삼항 연산으로 뒤의                        : (mult2 && plus5) ? num * 2 + 5
        //                        : mult2 ? num * 2
        //                        : num + 5
        //가 반환되고 그후에 (mult2&&plus5)가 true 이기에 11 이 반환됨. 즉 연속적으로쓰는것도 가능하다.





        int x = 1, y = 2;

        //  💡 단축평가 적용됨
        int changed1 = x < y ? (x += 2) : (y += 2);// x+=2는 실행하나 y는 그대로
        int changed2 = x < y ? (x += 2) : (y += 2); // 🔴 x=3 y=4
        int changed3 = x < y ? (x += 2) : (y += 2);// x=5 y=4
        int changed4 = x < y ? (x += 2) : (y += 2);
        int changed5 = x < y ? (x += 2) : (y += 2);
        //단축 평가의특성임.
    }
}
