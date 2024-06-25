package connectbyurl;

public class Ex02 {

    URL yalco = new URL("https://showcases.yalco.kr");
    URL home = new URL(yalco, "/java/index.html");

    //  ⭐️ 예외를 던짐
    //  Closable이 아님 : try-with-resource로는 사용되지 못함
    URLConnection conn = home.openConnection();

        try(
    InputStream is = conn.getInputStream();

    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);

    StringWriter sw = new StringWriter();
    PrintWriter pr = new PrintWriter(sw)
        ) {
        String line;
        int lineCount = 1;
        while ((line = br.readLine()) != null) {
            pr.printf("%3d :  %s%n", lineCount++, line);
        }

        // ⭐️ StringWriter는 출력시 toString 생략 가능
        System.out.println(sw);
    }




    //  💡 URL의 인스턴스 메소드들
    String content = url1.toExternalForm();
    String file = url1.getFile();
    String path = url1.getPath();
    String host = url1.getHost();
    long port = url1.getPort();
    long defPort = url1.getDefaultPort();
}
