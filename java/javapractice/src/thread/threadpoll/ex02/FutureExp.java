package thread.threadpoll.ex02;

public class FutureExp {
    ExecutorService es = Executors.newSingleThreadExecutor();//즉 싱글스레드임.

    //  💡 submit 메소드 : Callable을 받아 Future 반환
    //  - 'String을 받아올 임무를 가진 것'이란 의미
    //  - execute 메소드(Runnable을 받음)와 비교
    // 즉 executorservice의 인스턴스의 submit메서드가 해당되는 스레드의 결과물을 FUTURE꼴로 반환한다는말.
    Future<String> callAnswer = es.submit(() -> {
        Thread.sleep(2000);
        return "여보세요";
    });

    //  ⭐ get 메소드를 호출하기 전까지는 막히지 않고 동시에 진행
    //  - Future의 Callable은 다른 쓰레드에서 진행됨 즉 이 future는 다른 스레드에서 진행중이며
    //동시에 아래 while문은 메인스레드에서 진행중. 즉 비동기적 작업이 현재이루어지고있는것.
    //즉 future는 다른 스레드에서 진행된 비동기적 결과값을 받는 친구이다.
    //또한 아래의 get 메서드를 통해서 이 받은 future값을 메인스레드의 흐름으로 가져오는것이다.

    //  💡 isDone 메소드 : 퓨쳐의 태스크가 종료되었는지 여부 확인
        while (!callAnswer.isDone()) {
        System.out.println("📞 따르릉...");
        try { Thread.sleep(400);
        } catch (InterruptedException e) {}
    }

    String result = null;

    //  💡 get 메소드 : 해당 퓨쳐 쓰레드의 작업이 끝난 뒤 결과를 받아옴
    //  - ⭐ 이를 완료하기까지 그 뒤의 작업들이 막힘 (블로킹) 즉 퓨처스레드가 메인스레드의 흐름으로 참여해서
    //동기적으로바뀌므로 이게 긑나야 뒤으 통ㅅ화시작,작업종료가 실행이된다는것이다.
    //  - 대안을 위해 다음 강에 배울 CompletableFuture가 나옴
        try { result = callAnswer.get();
    } catch (InterruptedException | ExecutionException e) {}

        System.out.println("✅ 통화 시작 - " + result);
        System.out.println("- - - 작업 종료 - - -");

        es.shutdown();
}
