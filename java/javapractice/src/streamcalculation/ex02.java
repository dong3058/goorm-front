package streamcalculation;

public class ex02 {


    String[] names = {
            "강백호", "서태웅", "채치수", "송태섭", "정대만",
            "윤대협", "변덕규", "황태산", "안영수", "허태환",
            "이정환", "전호장", "신준섭", "고민구 ", "홍익현",
            "정우성", "신현철", "이명헌", "최동오", "정성구"
    };


    Stream<String> nameStream = Arrays.stream(names);

    Random random = new Random();
        random.setSeed(4); // 균일한 결과를 위해 지정된 시드값
    List<Person> people = nameStream
            .map(name -> new Person(
                    name,
                    random.nextInt(18, 35),
                    random.nextDouble(160, 190),
                    random.nextBoolean()
            ))
            .sorted()
            //.sorted((p1, p2) -> p1.getHeight() > p2.getHeight() ? 1 : -1)
            //.sorted((p1, p2) -> Boolean.compare(p1.isMarried(), p2.isMarried()))
            .toList();//리스트를 반환함. 단 우리가 배운 리스트가아닌 안의 내용을 바꿀수없는 조긐다른애임.



    //  💡 collect, Collectors의 기능들
    //  - 이미 다룬 joining도 이들 중 하나

    //  메소드에 따라 자료형이 달라지므로 var을 사용했습니다.
    var peopleLastNameSet = people.stream()
            .map(p -> p.getName().charAt(0))

            //  💡 아래 중 원하는 컬렉션으로 택일
            //그러니까 people은 리스ㅡ엿다가 스트림으로 바꾸고 colectios를통해서 araylist로 바꾼것.
            .collect(Collectors.toList());
    //.collect(Collectors.toSet());
    //.collect(Collectors.toCollection(ArrayList::new));
    //.collect(Collectors.toCollection(LinkedList::new));
    //.collect(Collectors.toCollection(TreeSet::new));



    Map<String, Integer> nameAgeMap = people.stream()
            //  💡 의미 없는 작업(해시맵이 될 스트림의 정렬)은 IDE가 제거 권유
            //해시맵은 순서를 보장하지않으니까 뜨는거다.
            .sorted((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1)//없애도되는내용.
            .collect(Collectors.toMap(Person::getName, Person::getAge));



    Map<Boolean, List<Person>> peopleHMapByMarried = people.stream()
            .collect(Collectors.groupingBy(Person::isMarried));//ismarried가 같은 값인애들끼리 묶인다.
    //즉 true인애들은 true값을 key로 vale가 여러개이게되는거다.
    //즉 스트림을 특정값을 기준으로 해시맵으로 저장하는것이다.
    List<Person> marrieds = peopleHMapByMarried.get(true);



    Map<Integer, List<Person>> peopleHMapByHeight = people.stream()
            .collect(Collectors.groupingBy(
                    p -> ((int) p.getHeight() / 10) * 10)
            );
    List<Person> over180s = peopleHMapByHeight.get(180);





    Map<Character, List<Integer>> intHMapByOddEven
            = IntStream.range(0, 10).boxed()
            .collect(Collectors.groupingBy(
                    i -> i % 2 == 1 ? '홀' : '짝'
            ));
    List<Integer> odds = intHMapByOddEven.get('홀');





    //  💡 수의 통계를 인스턴스 형태로 갖는 클래스
    //애내는  스트림을 통해서 나오는값들에대한 통계를 가진다.
    IntSummaryStatistics ageStats = people.stream()
            .map(Person::getAge)
            .collect(Collectors.summarizingInt(Integer::intValue));




    DoubleSummaryStatistics heightStats = people.stream()
            .map(Person::getHeight)
            .collect(Collectors.summarizingDouble(Double::doubleValue));
}
