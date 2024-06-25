package thread.threadpoll;

public class Main {
    //  💡 쓰레드풀을 관리하는 라이브러리 클래스
    ExecutorService es = Executors.newFixedThreadPool(
            //  💡 동시에 일할 수 있는 지원자의 수
            //  - 숫자를 바꿔 볼 것
            5//즉 스레드가 5개이다 라는말.
            //이 스레드들으 ㄹ재사용하는대 사요이 긑난 스레드에 다른 런어블을 담아서 사용한다.
    );

    Cave cave = new Cave();

        while (cave.getWater() > 20) {

        //  💡 execute : Runnable(지원자)을 대기열에 추가
        es.execute(new VolunteerRun(cave));

        try { Thread.sleep(500);//메인스레드가 0.5간격으로 지원자를 투입.
        } catch (InterruptedException e) { return; }
    }

    //  💡 shutdown : 풀 닫기 (투입 중단, 더 투입시 예외)
    //  - ⭐ 이를 생략하면 프로그램이 끝나지 않음
    //  - 일단 들어간 지원자는 자리가 날 때까지 기다리다 일 함
        es.shutdown();//이걸 호출해야 프로그램이종료. 애는 셧다운 시킨하는대 이미 투입된 스레드들은 작업을 수행하게한다.
    //// 즉 추가투입을 막되 이미 줄서잇는 애들까지는 수행시킨다.
    //es.execute(new VolunteerRun(cave)); // ⚠️ 닫혔으므로 예외 발생

    //  💡 shutdownNow : 풀 닫고 투입된 지원자 해산, 진행중인 업무 강제종료 줄만끊는게 아니라 투입된애들도 취소.
    //단 이미 투입되서 일하는 애들은일을한다. 즉 완전히 끝내고싶으면 아래오류를 받아서 중지하도록해야됨.
    //  - ⚠️ 진행중인 업무 강제종료는 보장하지 않음
    //    - 각 쓰레드에 InterruptedException을 유발할 뿐
    //    - 각 Runnable에서 해당 예외 발생시 종료되도록 처리해주어야 함
    //  - 투입되어 대기중인 지원자들은 리스트 형태로 반환
    //List<Runnable> waitings = es.shutdownNow();
    //System.out.println(waitings);
}
