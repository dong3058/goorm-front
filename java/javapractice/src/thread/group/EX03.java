package thread.group;

public class EX03 {
    Runnable rythmRun = () -> {
        int index = 0;
        String rythm = "쿵쿵짝";

        while (true) {
            System.out.print(rythm.charAt(index++) + " ");
            index %= rythm.length();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    Thread SingThread = new Thread(() -> {
        String[] lines = new String[] {
                "푸른하늘 은하수", "하얀 쪽배엔",
                "계수나무 한나무", "토끼 세마리",
                "한마리는 구워먹고", "한마리는 튀겨먹고",
                "한마리는 도망간다", "서쪽나라로"
        };

        Thread rythmThread = new Thread(rythmRun);

        //  💡 리듬 쓰레드를 본 노래 쓰레드의 데몬으로 지정
        //  - 이 부분이 없으면 노래가 끝나도 리듬이 멈추지 않음
        //rythmThread.setDaemon(true); 사용자에게 직접보이지않고 뒤에서돌아가나 애의 를 포함한애가 끝나면
        //같이끝나는 운명을 맞이함.

        rythmThread.start();

        for (int i = 0; i < lines.length; i++) {
            System.out.println("\n" + lines[i]);
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    });

        SingThread.start();
}
