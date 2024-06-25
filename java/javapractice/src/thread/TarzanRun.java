package thread;

public class TarzanRun implements Runnable {
    int max;
    public TarzanRun(int max) { this.max = max; }

    @Override
    public void run() {
        String lyric = "%s : 타잔이 %d원짜리 팬티를 입고 %d원짜리 칼을 차고 노래를 한다.";

        for (int i = 0; i < max; i++) {

            try {
                Thread.sleep(2000);
                System.out.printf(
                        (lyric) + "%n", Thread.currentThread().getName(),
                        i * 10, (i + 1) * 10
                );
            } catch (InterruptedException e) {//이게 interrupt했을대 해당되는거을 들ㅇ줄지말지를 결정함.
                // 🛑
                //System.out.println("네.");
                //return;
            }
        }
    }
}