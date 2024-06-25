package thread.threadpoll.ex02;

public class TryCallAble {

    List<Integer> intList = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> {
        try {
            intList.add(new RollDiceCall().call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    });

        System.out.println(String.join(
                ",",
                intList.stream().map(String::valueOf).toArray(String[]::new)
        ));
}
