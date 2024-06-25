package stream;

public class ex01 {

    List<Integer> int0To9 = new ArrayList<>(
            Arrays.asList(5, 2, 0, 8, 4, 1, 7, 9, 3, 6)
    );
    //  홀수만 골라낸 다음 정렬하여 "1, 3, 5..."와 같은 문자열로 만들어보기





    //  기존의 방식
    List<Integer> odds = new ArrayList<>();
        for (Integer i : int0To9) {
        if (i % 2 == 1) odds.add(i);
    }
    List<String> oddsStrs = new ArrayList<>();
        for (Integer i : odds) {
        oddsStrs.add(String.valueOf(i));
    }
    String oddsStr = String.join(", ", oddsStrs);
        odds.sort(Integer::compare);





    //  ⭐ 스트림을 사용한 방식 then 메서드 달아주는 느낌이랄까.
    //  각 라인이 무엇을 반환하는지 확인할 것
    String oddsStrStreamed = int0To9
            .stream()//스트림을 통한과정은 원본을 바꾸지않음.
            .filter(i -> i % 2 == 1)
            .sorted(Integer::compare)
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
}
