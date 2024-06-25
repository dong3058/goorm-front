package errorandexception.error2;

public class LargeException extends Exception {
    public LargeException() {
        super("부장급 문제");
    }
    //넘겨준 string은 getmessage혹은stack으로 뽑아내야한다.
}