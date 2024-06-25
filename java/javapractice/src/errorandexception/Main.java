package errorandexception;

public class Main {
    int[] ints = {1, 2, 3};
    System.out.println(ints[3]); // ⚠️ 런타임 예외 발생
    System.out.println("예외를 방지하지 않았을 때");
    try {
        // ⭐️ 예외가 일어날 여지가 있는 코드를 try 블록에 작성
        System.out.println(ints[3]);
        //try안에서일어난 예외는 프로그램을 종료시키지않음.
    } catch (Exception e) {
        String errMsg = e.getMessage();//에러 메세지를 보여준다. 에러의 설명이다.
        e.printStackTrace(); // 🔴예외 인스턴스의 메서드로 어떤 오류인지 설명해주는애이다.
        //디버깅에 유용하니까 알아두자.
    }
    System.out.println("예외를 try문으로 감쌌을 때 1");

    				try {
        System.out.println(((String) null).length());
    } catch (Exception e) {
        String errMsg = e.getMessage();
        e.printStackTrace(); // 🔴
    }
				System.out.println("예외를 try문으로 감쌌을 때 2");

}
