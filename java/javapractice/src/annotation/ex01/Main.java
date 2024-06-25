package annotation.ex01;

public class Main {


    //  💡 Deprecated : 앞으로 사용하지 말 것
    //  - 더 좋은 / 기존 문제를 해결한 새 기능으로 대체
    //  - 기존의 메소드를 삭제할 수는 없으므로...
    @Deprecated
    public static void deprecatedMethod () {

        //  호출 메소드 작성시 IDE 힌트 보기
        //  ❗️Problems 탭에서 경고 메시지 확인
        System.out.println("라떼는 말이야...");
    }





    // 💡SuppressWarnings : 컴파일러의 경고 무시
    //@SuppressWarnings("unchecked") // ⭐️
    public static void warnedMethod () {

        //  ⚠️ 제네릭을 사용하지 않는 컬렉션
        //  - unchecked 경고 발생
        //  - 실행시 에러가 발생하지는 않음
        //  - 위의 어노테이션 활성화하고 다시 확인

        ArrayList list = new ArrayList();//제네릭이없다 이걸 컴파일러가 경고 즉 오류는 나지않는대
        //컴파일이 뭐라하는걸 무시하는게 suppresswarning 이다.
        list.add("감자");
        list.add("고구마");
        list.add("호박");
        System.out.println(list);
    }
}
