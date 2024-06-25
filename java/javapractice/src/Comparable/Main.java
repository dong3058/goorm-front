package Comparable;

public class Main {
    public static void main(String[] args) {
        Arrays.sort(nums, new IntDescComp());//intdescomp에서 새로 오버라이딩란 기준으로
        //내림차순꼴.


        Arrays.sort(nums, new CloseToInt(5));//5기준으로 가까운 순으로 정렬.





        //  ⭐️ 익명 클래스, 이후 배울 람다로 더 간편하게
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        //  💡 ArrayList도 sort 메소드 사용 가능
        ArrayList<Integer> numsAry = new ArrayList<>(Arrays.asList(nums));
        numsAry.sort(new IntDescComp());//역순정렬



        numsAry.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 % 2) - (o2 % 2); // 짝수가 앞으로 오도록
            }
        });



        TreeSet<Unit> unitTSet = new TreeSet<>(new UnitSorter());
        for (Unit u : new Unit[] {
                new Knight(Side.BLUE),// 중복되는 애지만 서로 다른 해시코드. 비교할떄는
                //특정 기준이 필요하므로 애내는 비교시에 넣질않는다. 서열이 같으면 그냥 1개로 퉁친다는말.
                //즉 unitsorter에서 따로 0일떄를 처리하지않으면 길이가 6이 나옴.
                new Knight(Side.BLUE), // 중복
                new Swordman(Side.RED),
                new Swordman(Side.RED), // 중복
                new MagicKnight(Side.BLUE),
                new Swordman(Side.BLUE),
                new MagicKnight(Side.RED),
                new Knight(Side.RED)
        }) {
            unitTSet.add(u);
        } //  💡 구분되는 기준이 없는 인스턴스는 같은 것으로 인식되어 삽입 안 됨 (셋이므로)




        TreeSet[] treeSets = {
                new TreeSet<>(),//컴퍼레이터없이 즉 지들끼리 알아서한다이말.
                new TreeSet<>(new PersonComp(PersonComp.SortBy.NO, PersonComp.SortDir.DESC)),
                new TreeSet<>(new PersonComp(PersonComp.SortBy.AGE, PersonComp.SortDir.ASC)),
                new TreeSet<>(new PersonComp(PersonComp.SortBy.HEIGHT, PersonComp.SortDir.DESC))
        };

        for (Person p : new Person[] {
                new Person("홍길동", 20, 174.5),
                new Person("전우치", 28, 170.2),
                new Person("임꺽정", 24, 183.7),
                new Person("황대장", 32, 168.8),
                new Person("붉은매", 18, 174.1),
        }) {
            for (TreeSet ts: treeSets) {
                ts.add(p);
            }
        }

        for (TreeSet ts: treeSets) {
            for (Object p : ts) {
                System.out.println(p);
            }
            System.out.println("\n- - - - -\n");
        }




    }
}
