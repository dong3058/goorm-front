package lists;

import java.util.ArrayList;

public class Main {


    //  ⭐️ 제네릭을 사용하여 타입 지정
    //  - 붙이지 않을 시 <Object>와 동일
    ArrayList<Integer> ints1 = new ArrayList<>();//기본적으로 어레이리스트는 제네릭임.
    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Number> numbers = new ArrayList<>();
    ArrayList<Knight> knights = new ArrayList<>();

    //제네릭에 원시타입은 불가 즉 t값에 원시타입불가


    //  add 메소드로 요소 추가
        ints1.add(11);
        ints1.add(22);
        ints1.add(33);
        ints1.add(44);
        ints1.add(55);
        //ints1은 길이가 5이다.


    //  요소 중복 허용
        for (String str : "바니 바니 바니 바니 당근 당근".split(" ")) {
        strings.add(str);
    }


    //  for-each 문 사용 가능 어레이리스트는
        for (int i : ints1) {
        System.out.println(i);
    }




    int ints1Size = ints1.size(); // 요소 개수
    boolean ints1IsEmpty = ints1.isEmpty(); // size가 0인지 여부 반환
    int ints12nd = ints1.get(1); // 인덱스로 요소 접근
    boolean ints1Con3 = ints1.contains(33); // 포함 여부
    boolean ints1Con6 = ints1.contains(66);


    ints1.set(2, 444); // 위치의 요소 수정
    ints1.add(0, 11); // 위치에 요소 추가 (다음 요소들 밀어냄)
    // 즉 기존걸 뒤로 밀어내고 해당 자리에 새로운걸 넣는다는말.

    //  ⭐️ 간략한 생성 및 초기화 방법들
    ArrayList<Integer> ints2A = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5)
    ); // 💡 Arrays 클래스 : 배열 관련 각종 기능 제공

    ArrayList<Integer> ints2B = new ArrayList<>(
            List.of(1, 2, 3, 4, 5)
    ); // 💡 자바9에서부터 가능

    ArrayList<Integer> ints2C = new ArrayList<>();
    Collections.addAll(ints2C, 1, 2, 3, 4, 5);


    //  💡 다른 Collection 인스턴스를 사용하여 생성
    ArrayList<Integer> ints3 = new ArrayList<>(ints1);
    //inst1을 가지는 다른 리스트를 만듬.

    //  스스로를 복제하여 반환 (⚠️ 얕은 복사)
    ArrayList<Integer> ints4 = (ArrayList<Integer>) ints3.clone();
    //얕은복사,obejct를 주기떄문에 명시적 형변환 필수.


    ints3.remove(4); // int: 인덱스로 지우기
    ints3.remove((Integer) 55); // 클래스 자료형: 요소로 지우기
    // 숫자만 자료형과 인덱스를 구분하기위해서 붙여준다.

    ints1.removeAll(ints3); // 주어진 콜렉션에 있는 요소들 지우기

    //ints3과 같은 값을 전부 삭제.


    ints1.removeAll(ints3); // 주어진 콜렉션에 있는 요소들 지우기


    ints1.addAll(ints3); // 콜렉션 이어붙이기



    //  💡 toArray - Object 배열 반환
    Object[] intsAry2_Obj = ints1.toArray();

    //  ⭐️ 특정 타입의 배열로 반환하려면?
    //  Integer[] ints1Ary1 = (Integer[]) ints1.toArray(); // ⚠️ 이렇게는 불가
    //  💡 인자로 해당 타입 배열의 생성자를 넣어줌
    //  - 다음 섹션에 배울 메소드 참조 사용 (9-3강 수강 후 다시 볼 것)
    Integer[] ints1Ary2 = ints1.toArray(Integer[]::new);
    //이렇게해야 toarray로 준애의 자료형을 바꾸면서 전개가가능.

    ints1.clear(); // 리스트 비움


    //  제네릭 적용
    numbers.add(Integer.valueOf(123));
    numbers.add(3.14);
    numbers.add("Hello"); // ⚠️ 불가

    knights.add(new Swordman(Side.BLUE)); // ⚠️ 불가
    knights.add(new Knight(Side.BLUE));
    knights.add(new MagicKnight(Side.RED));

    //  와일드카드 적용
    //  기사 이상의 그룹으로만 편성될 수 있는 정예분대
    ArrayList<? extends Knight> eliteSquad;
    //? super Knight이면 반대로 매직 나이트가 못들어간다.

    eliteSquad = new ArrayList<Swordman>(); // ⚠️ 불가
    eliteSquad = new ArrayList<Knight>();
    eliteSquad = new ArrayList<MagicKnight>();

    //  ⭐️ 인스턴스 요소를 지울 때는 참조를 기준으로
    //  - 내용이 같다고 같은 인스턴스가 아님
    Knight knight1 = new Knight(Side.RED);
        knights.add(knight1);

    //  요소가 하나 지워졌는지 여부 반환
    boolean removed1 = knights.remove(new Knight(Side.RED));// 참조형 데이터임로
    //다른애라서 안지워짐.
    boolean removed2 = knights.remove(knight1);
    //이렇게 해야 참조값이 같으므로 지워진다.






    //  ⭐️ 둘의 차이와 연관지어 생각해 볼 것

    //  💡 ArrayList에만 있는 메소드들 중...
    ArrayList<Attacker> attackers = new ArrayList<>();
    //  자주 쓰이지는 않음
        attackers.ensureCapacity(5); // 자리수 미리 확보
        attackers.trimToSize(); // 남는 자리 없애기 (메모리 회수)






    //  💡 LinkedList에만 있는 메소드들 중...
    LinkedList<Integer> intNums = new LinkedList<>();
        for (int intNum : new int[] {2, 3, 4}) { intNums.add(intNum); };

        intNums.addFirst(1);
        intNums.addFirst(0);
        intNums.addLast(5); // add와 반환값만 다름. 코드에서 확인해 볼 것
        intNums.addLast(6);
    //  💡 앞에서/뒤에서 꺼내지 않고 반환
    //  - peek~ : 비어있을 경우 null 반환
    //  - get~ : 비어있을 경우 익셉션
    int peekedFirst = intNums.peekFirst();
    int gottenFirst = intNums.getFirst();
    int peekedLast = intNums.peekLast();
    int gottenLast = intNums.getLast();


    //  💡 앞에서/뒤에서 꺼내어 반환  즉 pop shift를 의미.
    //  - poll~ : 비어있을 경우 null 반환
    //  - remove~ : 비어있을 경우 익셉션
    int polledFirst = intNums.pollFirst();
    int removedSecond = intNums.removeFirst();
    int polledLast = intNums.pollLast();
    int removedLast = intNums.removeLast();

    //  ⭐️ 위의 기능들 활용하여 Stack/Queue 구현



    LinkedList<Character> charLList = new LinkedList<>();

    //  💡 push & pop : 스택 간편하게 구현
    //  - 클래스 코드에서 살펴볼 것

        charLList.push('A');
        charLList.push('B');
        charLList.push('C');
        charLList.push('D');
        charLList.push('E');

    char pop1 = charLList.pop();
    char pop2 = charLList.pop();
    char pop3 = charLList.pop();
    //파이썬의 그것과 동일 선입선출을 의미. 즉 addfirst와 remove first를 의미.




    //인터페이스로 자료형을 정해줌. 추상적 자료형으로 지정한다 이말임.
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
    ArrayList<Integer> list2 = new ArrayList<>(list1);

    String list1Type = list1.getClass().getName();
    String list2Type = list2.getClass().getName();

        list1.add(6); // ⚠️ 런타임 오류

    List<Integer> intList = new ArrayList<>();
    intList = new LinkedList<>();

    Set<String> strSet = new HashSet<>();
    strSet = new TreeSet<>();

    Map<Integer, String> intStrMap = new HashMap<>();
    intStrMap = new TreeMap<>();
}
