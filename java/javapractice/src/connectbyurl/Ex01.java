package connectbyurl;

import java.net.MalformedURLException;

public class Ex01{

    public static void main(String[] args)  throws MalformedURLException {

        //  ⭐️ 예외를 던짐. 여기에서는 main에 넘기기
        //MalformedURLException 이레러를 url생성시마다 처리해줘야되는대 여기선 그냥 메인에 넘기겟다.
        URL url1 = new URL("https://showcases.yalco.kr/java/index.html");

        URL url2 = new URL("https://showcases.yalco.kr");
        URL url3 = new URL(url2, "/java/index.html");//url2에다가 뒤의것 붙인것 즉url1과 동일.

        String url1Str = url1.toExternalForm();
        String url3Str = url3.toExternalForm();
        boolean sameUrl = url1.equals(url3);//당연히 객체로썬다르지만 그안의값은 같으니까 true가나온다.


    }


}