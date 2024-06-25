package streamcalculation;

public class ex01 {


            IntStream
                    .range(1, 100)//(1~99까지 스트림을 만드는애)
                    .filter(i -> i % 2 == 0)//js에서의 그필터인대 js와다르게 안에들어가는
            //메서드는 전부다 다른데서 가져온것이다. predicate
            //  💡 아래의 중간과정을 하나하나 주석해제해 볼 것
            //.skip(10) //멘앞의 요소 10개를 생략한다는말.
            //.limit(10)//주어진 갯수만큼만 가져온다.
            //.map(i -> i * 10)//function과정.
            .forEach(System.out::println);
            //foreach는 최종식으로 consumer에 해당된다.








    System.out.println("\n- - - - -\n");
    String str1 = "Hello World! Welcome to the world of Java~";
        //문자열에 chars붙이면 스트림 형성. 문자의 스트림.
        str1.chars().forEach(System.out::println);




//최종에 해당되는 과정을지나면 더이상 stream이아님.
    //중간 즉 filter나 기타등등은 계속해서 stream이다.

    System.out.println("\n- - - - -\n");
    char str1MaxChar = (char) str1.chars()
            .max() // OptionalInt 반환 - 이후 배울 것
            //.min() // 변경해 볼 것
            .getAsInt();



    //  사용되는 모든 알파벳 문자들을 정렬하여 프린트
        str1.chars()
                //.sorted()
                //.distinct()
                //.filter(i -> (i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z'))
                //혹은 Character::isLetter를넣어주면된다.
                .forEach(i -> System.out.print((char) i));


    				System.out.println("\n- - - - -\n");




    //  대소문자 구분 없이 중복 제거한 뒤 정렬하고 쉼표로 구분
    String fromStr1 = str1.chars().boxed()
            // 💡 boxed를 사용하여 Stream<Integer>으로 변환   원시형 자료형은 다른 자료형 스트림으로
            //바뀔수없다. 이런걸 원하면 참조형자료 즉 래퍼클래스 스트림으로바꿔야됨. 즉boxed가없으면안된다.
            //  요소를 다른 타입으로 바꾸려면 Stream<T>을 사용해야 함
            .map(i -> String.valueOf((char) i.intValue()))
            //.map(String::toUpperCase)
            //.filter(s -> Character.isLetter(s.charAt(0)))
            //.sorted()
            //.distinct()
            .collect(Collectors.joining(", "));


    System.out.println("\n- - - - -\n");

    //  💡 peek으로 중간 과정 체크하기
    //  - 스트림이나 요소를 변경하지 않고 특정 작업 수행 - 디버깅에 유용
    String oddSquaresR = IntStream.range(0, 10).boxed()
            .peek(i -> System.out.println("초기값: " + i))//foreach의 중간과정
            //즉 들어오는 데이터를 ㄴ안에저으이된걸 실행하고 다시 그대로 돌려줌.
            .filter(i -> i % 2 == 1)
            .peek(i -> System.out.println("홀수만: " + i))
            .map(i -> i * i)
            .peek(i -> System.out.println("제곱: " + i))
            .sorted((i1, i2) -> i1 < i2 ? 1 : -1)
            .peek(i -> System.out.println("역순: " + i))
            .map(String::valueOf)
            .collect(Collectors.joining(", "));





    Integer[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    //  💡 allMatch/anyMatch : (모든 요소가/어느 한 요소라도)
    //  - 주어진 Predicate에 부합하는가 여부 반환
    boolean intsMatch = Arrays.stream(ints)
            .allMatch(i -> i > 0);
    //.allMatch(i -> i % 2 == 0);
    //.anyMatch(i -> i < 0);
    //.anyMatch(i -> i % 2 == 0);




    System.out.println("\n- - - - -\n");

    //  💡 takeWhile/dropWhile 주어진 Predicate을 충족시킬 때까지 취함/건너뜀 js의 그것이내?
    //이제보니까 java랑 js랑 겁나비슷하구나 ㅇㅇ;
    //  💡 count : 중간과정을 거친 요소들의 개수를 반환
    long afterWhileOp = Arrays.stream(ints)
            .takeWhile(i -> i < 4)
            //.dropWhile(i -> i < 4)
            .peek(System.out::println)
            .count();






    //  💡 sum : IntStream, LongStream, DoubleStream 요소의 총합 반환

    int intsSum = IntStream.range(0, 100 + 1)
            //.filter(i -> i % 2 == 1)
            //.filter(i -> i % 2 == 0)
            //.filter(i -> i % 3 == 0)
            .sum();





    System.out.println("\n- - - - -\n");

    double doubleSum = DoubleStream.iterate(3.14, i -> i * 2)
            .limit(10)
            .peek(System.out::println)
            .sum();




    System.out.println("\n- - - - -\n");

    //  💡 reduce : 주어진 BiFunction으로 값을 접어나감
    //  seed 값이 없을 때 : Optional 반환 (빈 스트림일 수 있으므로)
    int intReduce = IntStream.range(1, 10)
            //.filter(i -> i % 2 == 1)
            .reduce((prev, curr) -> {
                System.out.printf("prev: %d, cur: %d%n", prev, curr);
                return prev * curr;
            })
            .getAsInt(); // 필요함

    //  seed 값이 있을 때 : 실제 값 반환
    int intReduceWithSeed = IntStream.range(1, 10)
            .reduce(2, (prev, curr) -> prev * curr);//초기값넣어준버전.
    //초기값이 없으면 스틀미의 1,2값이 쓰이는대 있다면 초기값과 스트림의 첫번쨰값으로 연산한다.
    //초기값이 없다면 스트림이 아무값도 없을수있기에 default값이 존재하므로
    //그값의 처리를위해서 getasint가 붙으나 초기값이잇으면 초기값이 default를대체하므로 getasint가 필요x





    //  내부 정적 클래스
    public static class StringStat {
        int length = 0;
        int upperCases = 0;
        int lowerCases = 0;
        int nonLetters = 0;
    }





    StringStat stringStat = "Hello World! Welcome to the world of Java~"
            .chars()
            .boxed()
            .reduce(
                    new StringStat(),
                    (ss, i) -> {//ss는 new sTRINGSTAT()객체이다
                        ss.length++;
                        if (i >= 'A' && i <= 'Z') { ss.upperCases++; }
                        else if (i >= 'a' && i <= 'z') { ss.lowerCases++; }
                        else { ss.nonLetters++; }
                        return ss;//같은 인스턴스를 반환.
                    },
                    //  아래의 combiner 인자는 병령 연산에서만 작용 (여기서는 무의미)
                    //  요소와 다른 타입을 반환하는 오버로드의 필수인자이므로 임의로 넣음
                    (ss1, ss2) -> ss1//애는 지금 몰라도됨 ㅇㅇ;
            );
}
