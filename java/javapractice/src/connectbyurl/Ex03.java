package connectbyurl;

public class Ex03 {


    URL yalco = new URL("https://showcases.yalco.kr");
    URL home = new URL(yalco, "/java/index.html");
    String HOME_PATH = "src/sec12/chap06/home.html";

    //  💡 HTTP 프로토콜로 여는 커넥션은 HttpURLConnection 반환
    HttpURLConnection conn = (HttpURLConnection) home.openConnection();

    //  💡 용도에 따라 아래의 메소드 등 사용
    //conn.setRequestMethod("POST");
    //conn.setDoOutput(true);
    //conn.setConnectTimeout(1000);
    //  기타 메소드들 확인해보기

    //  💡 요청의 응답 코드 반환
    int responseCode = conn.getResponseCode();
        System.out.println("Response Code :" + responseCode);

        try (
    InputStream is = conn.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    FileWriter fw = new FileWriter(HOME_PATH);
    PrintWriter pw = new PrintWriter(fw);//스트링 라이터만 아니라파일 라이터도 넣을수가있?다.
        ) {
        String line;
        while((line = br.readLine()) != null) {
            pw.println(line);
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
