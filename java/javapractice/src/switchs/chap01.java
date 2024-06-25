package switchs;

public class chap01 {
    public static void main(String[] args) {


        byte fingersOut = 2;

        //  💡 switch : 괄호 안에 기준이 될 변수를 받음
        //  가능한 자료형: byte, short, int, char, String, enum(이후 배움) 불리언쓸꺼면 if쓰면된다 ㅇㅇ.

        switch (fingersOut) {

            //  💡 case : 기준에 일치하는 case로 바로 이동 switch의 인수와 맞춰줘야됨.
            //  💡 break : switch문 실행을 종료 만약 애내가없다면 전부다 실행버리고맘.
            //  💡 default: 해당하는 case가 없을 때 - 마지막에 작성

            case 2:
                System.out.println("가위");
                break;
            case 0:
                System.out.println("바위");
                break;
            case 5:
                System.out.println("보");
                break;
            default:
                System.out.println("무효");
        }



        String direction = "north";
        String dirKor;

        //  break 제거하고 실행해 볼 것 break 가없다면 디폴트가 작동함. 오ㅔ냐break가 없으므로 default가 마지막에 작동해버리기떄문.

        switch (direction) {
            case "north":
                dirKor = "북";
                break;
            case "south":
                dirKor = "남";
                break;
            case "east":
                dirKor = "동";
                break;
            case "west":
                dirKor = "서";
                break;
            default:
                dirKor = null;
        }

        System.out.println(
                dirKor != null ? dirKor : "무효"
        );




        //  💡 break 관련 동작방식을 이용
        char yutnori = '도';
// 모윷걸개도 에서 다지나가고 도에서 맞으면 break임. 만일 :"윷"이면 모를 지나고 그이하를 전부다 작동시킴.
        switch (yutnori) {
            case '모': System.out.println("앞으로");
            case '윷': System.out.println("앞으로");
            case '걸': System.out.println("앞으로");
            case '개': System.out.println("앞으로");
            case '도': System.out.println("앞으로"); break;
            default:
                System.out.println("무효");
        }







        byte month = 1;
        byte season;

        switch (month) {
            case 1: case 2: case 3://사실상 1,2,3에대해서 전부다 같은걸 한다는의미이다.
                season = 1;
                break;
            case 4: case 5: case 6:
                season = 2;
                break;
            case 7: case 8: case 9:
                season = 3;
                break;
            case 10: case 11: case 12:
                season = 4;
                break;
            default:
                season = 0;
        }

        System.out.println(
                season > 0
                        ? "지금은 %d분기입니다.".formatted(season)
                        : "무효한 월입니다."
        );




        byte startMonth = 1;
        String holidays = "";

        switch (startMonth) {
            case 1:
                holidays += "설날, ";
            case 2:
            case 3:
                holidays += "3·1절, ";
                break;
            case 4:
            case 5:
                holidays += "어린이날, ";
            case 6:
                holidays += "현충일, ";
                break;
            case 7:
            case 8:
                holidays += "광복절, ";
            case 9:
                holidays += "추석, ";
                break;
            case 10:
                holidays += "한글날, ";
            case 11:
            case 12:
                holidays += "크리스마스, ";
                break;
            default:
                holidays = null; // 휴일이 없는 분기와 구분
        }

        String result = holidays == null
                ? "(잘못된 월입니다)"
                : "분기 내 휴일: " + holidays
                .substring(0, holidays.lastIndexOf(", "));


    }
}
