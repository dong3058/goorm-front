package Hashs;

public class Main {

    public static void main(String[] args) {



        Set<Integer> intHSet1 = new HashSet<>();
        intHSet1.add(1);
        intHSet1.add(1);
        intHSet1.add(2);
        intHSet1.add(3);//길ㅇ3짜리 즉 중복요소 허용 x

        List<Integer> ints1 = new ArrayList(
                Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 6, 7)
        );
        Set<Integer> intHSet2 = new HashSet<>(ints1);
        //리스트를집어넣으면 중복된애들 없애버리고 만들어버림.


        //  💡 for-each문 사용 가능
        for (Integer i :intHSet1) {
            System.out.println(i);
        }



        //  ⭐️ 아래와 같이 응용 가능
        //  - 중복을 제거한 ArrayList
        ints1.clear();
        ints1.addAll(intHSet2);


        //해시셋:동일한 입력값에대해서 무조건 동일한 출력을주는애.
        //정렬되긴하는대 애를 정렬목적으로 쓸생각은 하지말자.


        //  포함 여부
        boolean has2 = intHSet1.contains(2);//값이 포함여무
        boolean has4 = intHSet1.contains(4);

        //  요소 삭제, 있었는지 여부 반환
        boolean rm3 = intHSet1.remove(3);//값을 삭제
        // 즉 인덱스가아님. 잇엇으면true로 반환.
        boolean rm4 = intHSet1.remove(4);

        //  다른 콜렉션 기준으로 내용 삭제
        intHSet2.removeAll(intHSet1);

        //  💡 그 외 size, isEmpty, clear, clone 등의 메소드들 확인

        //  참조형 관련
        Set<Swordman> swordmenSet = new HashSet<>();
        Swordman swordman = new Swordman(Side.RED);

        swordmenSet.add(swordman);
        swordmenSet.add(swordman);//이 두개는 같은 애이름으로1개
        swordmenSet.add(new Swordman(Side.RED));// 생성할떄마다
        //다른애니까 2개 즉 총 3개가 들어감.즉 참조자료형은 주소를기준으로
        //중복을 체크.
        swordmenSet.add(new Swordman(Side.RED));
        //  swordmenSet.remove(swordman); // 실행해보기
        //인스턴스를 만들어서 넣은애는 주소를 저장하지;않앗으므로
        //clear로 일괄적으로 지워애됨.


        HashSet<Integer> intHashSet = new HashSet<>();
        LinkedHashSet<Integer> intLinkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> intTreeSet = new TreeSet<>();

        for (int i : new int[] { 3, 1, 8, 5, 4, 7, 2, 9, 6}) {
            intHashSet.add(i);
            intLinkedHashSet.add(i);
            intTreeSet.add(i);
        }
        for (Set s : new Set[] {intHashSet, intLinkedHashSet, intTreeSet}) {
            System.out.println(s);
        }
        //  ⭐️ LinkedHashSet : 입력된 순서대로 / TreeSet : 오름차순
        //  ⚠️ HashSet이 정렬된 것처럼 보이지만 보장된 것이 아님 어느정도까지만 정렬
        //  - Hash 방식에 의한 특정 조건에서의 정렬일 뿐


        Set<String> strHashSet = new HashSet<>();
        Set<String> strLinkedHashSet = new LinkedHashSet<>();
        Set<String> strTreeSet = new TreeSet<>();

        for (String s : new String[] {
                "Fox", "Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        }) {
            strHashSet.add(s);
            strLinkedHashSet.add(s);
            strTreeSet.add(s);
        }
        for (Set s : new Set[] {strHashSet, strLinkedHashSet, strTreeSet}) {
            System.out.println(s);
        }
        //  💡 TreeSet의 주요 메소드들
        int firstInt = intTreeSet.first();
        String lastStr = strTreeSet.last();
        //  같은 것이 없다면 트리구조상 바로 위의 것 (바로 더 큰 것) 반환
        String foxCeiling = strTreeSet.ceiling("Fox");
        String creamCeiling = strTreeSet.ceiling("Cream");

        //  같은 것이 없다면 트리구조상 바로 아래의 것 (바로 더 작은 것) 반환
        String foxFloor = strTreeSet.floor("Fox");
        String diceFloor = strTreeSet.floor("Cream");

        //  맨 앞에서/뒤에서 제거

        int pollFirst1 = intTreeSet.pollFirst();
        int pollFirst2 = intTreeSet.pollFirst();

        int pollLast1 = intTreeSet.pollLast();
        int pollLast2 = intTreeSet.pollLast();


        //  순서가 뒤집힌 NavigableSet 반환
        Set<String> strTreeSetDesc
                = (TreeSet<String>) strTreeSet.descendingSet();

        //  ⚠️ 요소로 추가 불가
        //  - 이후 배울 Comparable 또는 Comparator 필요
        TreeSet<Knight> knightSet1 = new TreeSet<>();
        knightSet1.add(new Knight(Side.BLUE));
        knightSet1.add(new Knight(Side.BLUE));
        knightSet1.add(new Knight(Side.BLUE));//서로간의 우열관계를 표시할수가없어서 오류

    }
}
