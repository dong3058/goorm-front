package thread.synchronize.ex01;

public class Cache1 {

    static boolean stop = false;
    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;

                // ⭐️ 아래를 주석처리하고 다시 실행해보기
                System.out.println(i);
            }

            System.out.println("- - - 쓰레드 종료 - - -");
        }).start();

        try { Thread.sleep(1000);//메인스데르에서 1초뒤에 아래 코드들을 실행함/
        } catch (InterruptedException e) {}

        stop = true;

        //  💡 JVM의 캐시 방식에 따라 멈출 수도 안 멈출 수도 있음 즉 메모리에 직접 넣어두는게아니라
        //임시저장소인 캐시에다가 넣고 메모리에는 아직 반영을 하지않는다.
        //print를 주석처리해버리면 메모리에 넣는일이 없기에
        //stop이 true가 되어도 while문이 돌아간다.
        //즉 현재 true값이 되었으나 메모리에 집어넣은게아니라 캐시에 쥐고있기에 while이 아직 돌아간다.
        //즉 메모리에 true값이 반영이되지않은것.

        
        //  - stop으로의 접근이 동기화되지 않았을 시
        //  - 한 쓰레드가 그 값을 바꿔도 다른 쓰레드는 캐시에 저장된
        //  - 바뀌기 이전 값을 참조할 수 있음
        //    - println 메소드는 위 코드에서 캐시를 비우는 이유 제공
    }
}