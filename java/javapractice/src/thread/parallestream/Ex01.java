package thread.parallestream;


public Ex01 {

    //스트림의 일부메서드는 병렬이 가능 map,filter,reduce
    Stream<Character> stream1 = Stream.of('A', 'B', 'C');

//  💡 isParallel : 스트림이 병렬인지 여부
    boolean bool1 = stream1.isParallel();

//  💡 parallel :  직렬 스트림을 병렬로 바꿈
    stream1.parallel();
    boolean bool2 = stream1.isParallel();

//  💡 sequential : 병렬 스트림을 직렬로 바꿈
    stream1.sequential();
    boolean bool3 = stream1.isParallel();




    //  ⭐️ 처음부터 병렬 스트림으로 생성하기
    //  - Arrays와 Collection의 parallelStream 사용
    Stream<Integer> stream2 = Arrays.asList(1, 2, 3, 4, 5)
            .parallelStream();

    List<Double> dblList = new ArrayList<>(
            Arrays.asList(1.23, 2.34, 3.45)
    );
    Stream<Double> stream3 = dblList.parallelStream();
}