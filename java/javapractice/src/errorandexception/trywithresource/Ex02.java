package errorandexception.trywithresource;

public class Ex02 {


    for (int i = 0; i < 10; i++) {
        dirtyOperation();
    }

    public static void dirtyOperation () {
        try (SuicideSquad sc = new SuicideSquad()) {
            sc.doSecretTask();
        } catch (OpFailException e) {
            //  💡 예외상황은 아만다 윌러가 책임짐
            e.printStackTrace();
            System.out.println("🗑️ 증거 인멸\n- - - - -\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //어찌되든간에 전원폭사 왜냐 try안에 autoclosable을 넣었기때문.
    //즉 try가성공적이든 아니면 오류가나서 catch로넘어가든 clsoe는 무조건 작동한다.


}
