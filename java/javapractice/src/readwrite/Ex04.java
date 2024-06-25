package readwrite;

public class Ex04 {


    //  ⭐️ System의 out은 기본적으로 PrintStream 임 확인
        System.out.println(System.out.getClass());

    String PRINT_PATH = "src/sec12/chap04/print.txt";

    PrintStream ps = null;
    FileOutputStream fos = null;

        try {
        fos = new FileOutputStream(PRINT_PATH);
        ps = new PrintStream(fos);

        //  💡 System의 out 변경
        //  - FileOutputStream 을 출력 대상으로 하는
        //  - 새 PrintStream으로
        System.setOut(ps);//out이라는 애를 ps로 세팅한다는말 즉 setter.
        //콘솔창에는 아무것도뜨지않지만 파일애는 적혀잇다. 프린트의 기능에따라서 줄바굼이 되거나 포맷팅되서 들어간다.
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

        System.out.println("안녕히 계세요 여러분.");
        System.out.printf("%s로 뵙겠습니다.%n", "텍스트파일");
}
