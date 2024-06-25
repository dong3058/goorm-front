package Iterator;

public class Main {

    public static void main(String[] args) {
        Set<Integer> intHSet = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        );

        //  💡 이터레이터 반환 및 초기화
        //  - 기타 Collection 인터페이스를 구현한 클래스들에도 존재
        Iterator<Integer> intItor = intHSet.iterator();
        //js의 그것과 유사해보임.




        // 💡 next : 자리를 옮기며 다음 요소 반환
        Integer int1 = intItor.next();
        Integer int2 = intItor.next();
        Integer int3 = intItor.next();//원하는 횟수만큼 진행하고 initor에 어디까지했는지가 저장됨.
        //즉 제네레이터 같다?

        //  💡 hasNext : 순회가 끝났는지 여부 반환
        boolean hasNext = intItor.hasNext();// 아직 더보여줄게잇냐 잇으면true


        //  ⭐️ 순회 초기화
        intItor = intHSet.iterator();//다시초기화 즉 다시시작.


        //  💡 remove : 현 위치의 요소 삭제
        while (intItor.hasNext()) {
            if (intItor.next() % 3 == 0) {
                intItor.remove();//컬렉션 내부요소 삭제시 이터레이터 쓰는것이 권장됨.
            }
        }


        //  ⚠️ foreach 문으로 시도하면 오류
        for (Integer num : intHSet) {
            if (num % 3 == 0) intHSet.remove(num);
        }//왜냐 삭제할떄마다 intHset에서 변동이생기기떄문.




        List<Unit> enemies = new ArrayList<>(
                Arrays.asList(
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Knight(Side.RED),
                        new MagicKnight(Side.RED))
        );

        Iterator<Unit> enemyItor = enemies.iterator();


        int thunderBolts = 3;
        int fireBalls = 4;

        while (enemyItor.hasNext() && thunderBolts-- > 0) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 벼락 공격%n", enemy);
            enemy.hp -= 50;
        }
        while (enemyItor.hasNext() && fireBalls-- > 0) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 파이어볼 공격%n", enemy);
            enemy.hp -= 30;
        }
        while (enemyItor.hasNext()) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 화살 공격%n", enemy);
            enemy.hp -= 10;
        }




        System.out.println("\n- - - - -\n");

        Map<Integer, Double> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i + 1, Math.random() * 10);
        }

        //  ⭐️ 맵의 경우는 아래와 같이 이터레이션
        //  - 키, 값 또는 엔트리의 컬렉션을 반환받아 이터레이트
        //단 애내는 위읫것들과는 다르게 hasmap을 이러레이터한개아니라
        //hashmap에서 추가적으로 key,value들을 이터레이팅 한것임.
        Iterator<Integer> hmKeyItor = hashMap.keySet().iterator();
        Iterator<Double> hmValueItor = hashMap.values().iterator();
        Iterator<Map.Entry<Integer, Double>> hmEntryItor = hashMap.entrySet().iterator();




        while (hmKeyItor.hasNext()) {
            System.out.println(hmKeyItor.next());
        }
        System.out.println("\n- - - - -\n");

        while (hmValueItor.hasNext()) {
            System.out.println(hmValueItor.next());
        }
        System.out.println("\n- - - - -\n");

        while (hmEntryItor.hasNext()) {
            System.out.println(hmEntryItor.next());
        }




        //  ⭐ 이들은 따로 반환된 컬렉션의 이터레이터
        //  - 여기서 remove하는 것은 원본 맵에 영향 끼치지 않음
        while (hmKeyItor.hasNext()) {
            int i = hmKeyItor.next();
            if (i % 3 == 0) hmKeyItor.remove();
        }
        while (hmValueItor.hasNext()) {
            double d = hmValueItor.next();
            if (d < 5) hmValueItor.remove();
        }
        while (hmEntryItor.hasNext()) {
            Map.Entry<Integer, Double> e = hmEntryItor.next();
            if (e.getKey() % 2 == 0) {
                hmEntryItor.remove();
            }
        }
        // 즉 이러렇게해선 map을 수정하지못함.

    for(int i=0;i<10;i++){

        hashMap.remove(i+1),
        intHset.remove(i)
        //for each의 경우 중간에 해당되는 collections의 크기를 바꾸는것이 불가하다.

    }

    }
}
