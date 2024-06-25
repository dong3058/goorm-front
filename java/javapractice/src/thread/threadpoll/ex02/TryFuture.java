package thread.threadpoll.ex02;

public class TryFuture {

    //  💡 쓰레드 풀과 Future를 사용해서 여러 Callable 동시에 실행
    ExecutorService es = Executors.newFixedThreadPool(4);

    List<Future<Integer>> futList = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> {
        futList.add(
                es.submit(new RollDiceCall())//callable를 투입 그냥 런에이블 대신 들어간다고보면되고
                //submit이므로 future꼴이 반환될것이다.
        );
    });

        es.shutdown(); // 💡 제거하면 프로그램이 끝나지 않음
    //10개의 스레드가 투입이되었고 이게있다고 해서 뒤이ㅡ 문장이 실행이 안되는것은 본디 아니나
    //그러나 우리가 넘긴값이 future에 해당되고 get 메서드를뒤에서 사용하고잇기에 현재
    //10개의 모든 경우가 비동기 작업이 끝날떄까지 뒤의 문장이 실행이되지않는다.
    //즉 메인스레드가 정지되어있는 상태이다.

    //만약 두 문장사이에 futurexp처럼 다른 와일문이 들어가있따면(get이없는)
    //그럼개는 실행이될것이다.

    //단순하게 말해서 get이하는 futrue의 작업이 끝나야 실행된다고 생각하면된다.
    //여기서의 퓨처는 10개이므로 이게다끝나야 실행될것.

    ArrayList<Integer> intList = new ArrayList<>();
        for (Future<Integer> future : futList) {
        try {
            intList.add(future.get());//동기문으로 future가 합류했으므로 10개에다한 모든게 끝나아ㅑ됨.
        } catch (InterruptedException | ExecutionException e) {}
    }

        System.out.println(String.join(
                ",",
                intList.stream().map(String::valueOf).toArray(String[]::new)
        ));
}
