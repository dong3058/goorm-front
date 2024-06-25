package connectbyurl;

public class Ex04 {

    //외부에서 받은것을 파일로 써내리는과정.

    URL yalco = new URL("https://showcases.yalco.kr");
    URL people = new URL(yalco, "/java/people.csv");
    String PEOPLE_PATH = "src/sec12/chap06/people.txt";

    HttpURLConnection conn = (HttpURLConnection) people.openConnection();

    int responseCode = conn.getResponseCode();
        System.out.println("Response Code :" + responseCode);

        try (
    InputStream is = conn.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    FileWriter fw = new FileWriter(PEOPLE_PATH);
    PrintWriter pw = new PrintWriter(fw)
        ) {
        String line;
        while((line = br.readLine()) != null) {
            try {
                String[] pieces = line.split(",");
                pw.println(
                        new Person(
                                pieces[0],
                                Integer.parseInt(pieces[1]),
                                Double.parseDouble(pieces[2]),
                                Boolean.parseBoolean(pieces[3])
                                //넣는 과정에서 형식에 안맞는 데이터가잇을수있기에
                                //try문안에 넣어주도록하자.
                        )
                );
            } catch (RuntimeException e) {
                System.out.println("😵 처리 실패: " + line);
            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
