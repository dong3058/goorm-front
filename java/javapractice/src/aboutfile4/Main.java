package aboutfile4;

public class Main {


    public static final String CUR_PATH = "src/sec12/chap02/";




    //  💡 프로젝트 폴더 경로
    Path path1 = Paths.get("");
    Path path1Abs = path1.toAbsolutePath();//컴퓨터기준 javapractice의 절대경로를 돌려줌. 문자열은 아니고
    //path객체의 필드값으로 들어가있다.

    Path path2 = Paths.get("my_file.txt");
    Path path2Abs = path2.toAbsolutePath();//get안에 적은 파일의 user로부터시작한 절대경로를 돌려준다

    //  💡 인자로 들어온 문자열을 각각 내부 폴더로
    Path path3 = Paths.get(CUR_PATH, "sub1", "sub2", "sub3");//src/sec12/chap02/sub1/sub2/sub3 임.

    //  💡 두 경로를 통합
    Path path4 = path3.resolve(path2);//src/sec12/chap02//sub1/sub2/sub3/my_file.txt 임.

    //  💡 부모 경로
    Path path5 = path4.getParent();//src/sec12/chap02//sub1/sub2/sub3 즉 path4가 가리키는 파일의 부모
    //즉 폴더를 의미.

    //  💡 한 경로에서 다른 경로로의 상대 경로
    Path path6 = path4.relativize(path2); //paht4~path2간의 상대경로 ../../../../../../my_file.txt이런골.

    //  💡 끝단 파일/폴더명
    Path path7 = path4.getFileName();//해당경로 끝의 파일이름 즉 myfile.txt

    //  💡 서브경로
    Path path8 = path4.subpath(3, 5);//src/sec12/chap02/sub1/sub2/sub3/my_file.txt sub1/sub2/을돌려줌.




    System.out.println(Files.exists(path2));//path2가 존재하는가 라는걸 물어봄.

    //  💡 Path 기준으로 파일 생성
        try {
        Files.createFile(path2);
    } catch (IOException e) {
        //  💡 파일이 이미 존재시 예외 던짐
        System.out.println("파일이 이미 있음");
    }

        System.out.println(Files.exists(path2));




    //  💡 Path 기준으로 폴더 생성
        try {
        Files.createDirectory(
                Paths.get(CUR_PATH, "myFolder")
        );
    } catch (IOException e) {
        //  💡 폴더가 이미 존재시 예외 던짐
        System.out.println("폴더가 이미 있음");
    }



    //  ⭐️
    //  💡 중첩된 폴더 한 번애 생성
        try {
        Files.createDirectories(
                path4.getParent()//전체에 필요한 모든 디렉토리를 생성한다,
        );
        //  폴더들을 미리 만들고 그곳에 파일 생성
        Files.createFile(path4);
    } catch (IOException e) {
        System.out.println("이미 있음");
    }






    //  ⭐️ Files를 사용하여 파일 쓰기
    //  - 용량이 크지 않은 데이터를 쓰는데 적합
    //  - 덧붙이는 작업이나 대용량 작업은 이후 강에서

    //  💡 write : 파일에 주어진 바이트 배열을 씀
    //  - 이미 내용이 있을 경우 덮어씀
        try {
        //  💡 getBytes : 문자열로부터, 주어진 인코딩 형식에 따라 바이트 배열로 반환
        Files.write(path4, "안녕하세요".getBytes(StandardCharsets.UTF_8));//path4의 파일에다가 utf-8형식으로
        //메시지를 적을거다. 만일 write를 다시쓰면 이미내용이존재하경우 덮어쓴다.
    } catch (IOException e) {
        throw new RuntimeException(e);
    }








    List<String> lines = Arrays.asList(
            "아기상어 뚜루루뚜루", "귀여운 뚜루루뚜루",
            "바다속 뚜루루뚜루",  "아기상어",
            "",
            "엄마상어 뚜루루뚜루", "어여쁜 뚜루루뚜루",
            "바다속 뚜루루뚜루",  "엄마상어"
    );

//  💡 문자열의 List를 받아 줄 별로 쓰기
        try {
        Files.write(path4, lines);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }






    //  💡 파일의 내용을 byte 배열로 전부 받아오기
    //  - ⚠️ 대용량 파일의 경우에는 부적합
    byte[] path4Bytes;
        try {
        path4Bytes = Files.readAllBytes(path4);//경로를 바이트 꼴로읽음.
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    String path4Contents = new String(path4Bytes);//바꾸면 내용ㅇ 다시나온다.
        System.out.println(path4Contents);






        System.out.println("\n- - - - -\n");

    //  💡 파일의 내용을 문자열의 리스트로 전부 받아오기
    //  - ⚠️ 역시 대용량 파일의 경우에는 부적합
    List<String> path4Read = null;
        try {
        path4Read = Files.readAllLines(path4);
        path4Read.stream()
                .map(s -> "🎤 " + s)
                .forEach(System.out::println);

    } catch (IOException e) {
        throw new RuntimeException(e);
    }









    				System.out.println("\n- - - - -\n");

    //  💡 파일의 내용을 한 줄씩 스트림으로 받아오기
    //  - 대용량 파일을 읽는데 보다 적합
    //  - 한 줄씩만 받아오므로 효율적
    //  - 중단시 스트림 닫을 필요 - try-with-resources 사용
    //  - 파일이 너무 클 시 제한 둘 필요
        try (Stream<String> lineStrm = Files.lines(path4)) {//전에배운 autucloasble을 사용한다.
        lineStrm
                //.limit(3) // ⭐️ 제한 두기
                .map(s -> "🎵 " + s)
                .forEach(System.out::println);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }






    Path copied = Paths.get(
            path4.getParent().toString(), "copied.txt"
    );

    //  💡 파일 복사하기
        try {
        Files.copy(path4, copied);
    } catch (IOException e) { }







    Path moved = Paths.get(
            path4.getParent().getParent().toString(),
            "moved.txt"
    );
    //  💡 파일 이동하기
        try {
        Files.move(copied, moved);
    } catch (IOException e) {
        System.out.println("파일이 이미 있음");
    }








    //  💡 파일 삭제하기
        try {
        Files.delete(moved);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}






