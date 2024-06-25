package ifandelse;

public class ifandelse {
    public static void main(String[] args) {
        boolean open = true;
        int saleFrom = 10, saleTo = 20;
        int today = 15;

        //  💡 if : 괄호 안의 boolean 값이 true면 다음 명령 실행 파이썬과 비슷하내?
        if (open) System.out.println("영업중");
        if (!open) System.out.println("영업종료");

        //  💡 실행할 명령이 한 줄 이상일 경우 블록 사용
        if (today >= saleFrom && today <= saleTo) {
            System.out.println("세일중입니다.");
            System.out.println("전품목 20% 할인");
        }



        //  💡 else : if문 안의 boolean 값이 false일 경우 실행
        if (open) {
            System.out.println("영업중");
        } else {
            System.out.println("영업종료");
        }




        boolean willOrderCoffee = true;
        boolean likeMilk = false;
        boolean likeIce = true;
        boolean likeSweet = false;
        boolean angry = false;
        int myRank = 2;

        //  💡 중첩 사용
        if (willOrderCoffee) {

            //  ⭐️ 블록 내에서만 사용되는 변수 (이후 스코프에서 배움)
            String toOrder = "";

            //  필요에 따라 적절한 것 사용
            toOrder = likeMilk ? "라떼" : "아메리카노";
            if (likeIce) toOrder = "아이스 " + toOrder;
            if (!likeSweet) toOrder += " 안단티노";

            System.out.printf("저는 %s 할게요%n", toOrder);
        } else {
            if (!angry || myRank > 3) {
                System.out.println("저는 괜찮아요.");
            } else {
                System.out.println("너님들끼리 드세요.");
            }
        }





        int score = 85;

        //  💡 else if : 첫 if문이 false일 때 다른 조건을 연속 사용
        //  else만 사용하는 것은 맨 마지막에
        if (score > 90) {
            System.out.println('A');
        } else if (score > 80) {
            System.out.println('B');
        } else if (score > 70) {
            System.out.println('C');
        } else if (score > 60) {
            System.out.println('D');
        }
        else {
            System.out.println('F');
        }




    }
}
