package methodacc;

public class Main {
    public static void main(String[] args) {
        //  클래스의 클래스 메소드에 인자 적용하여 실행
        Function<Integer, String> intToStrLD = (i) -> String.valueOf(i);//사실상 string.valueof를 하는것과 동일
        //즉 람다식이어떤 매서드를 1개 호출시 그 메서드와 다ㅡㄹㄹ개없다.
        Function<Integer, String> intToStrMR = String::valueOf;
        String intToStr = intToStrMR.apply(123);


        //해당 메소드가 인터페이스와 인자, 리턴값 구성이 동일할 때

        //  인자로 받은 인스턴스의 메소드 실행
        UnaryOperator<String> toLCaseLD = s -> s.toLowerCase();
        UnaryOperator<String> toLCaseMR = String::toLowerCase;
        String toLCase = toLCaseMR.apply("HELLO");




        //  클래스의 생성자 실행
        Function<String, Button> strToButtonLD = s -> new Button(s);
        Function<String, Button> strToButtonMR = Button::new;
        Button button1 = strToButtonMR.apply("Dog");




        BiFunction<String, String, Button> twoStrToButtonLD = (s1, s2) -> new Button(s1, s2);
        BiFunction<String, String, Button> twoStrToButtonMR = Button::new;//생성자는
        //클래스메서드니까 이렇게 Button을 쓴거고
        Button button2 = twoStrToButtonMR.apply("고양이", "야옹");
        button2.onClick();





        System.out.println("\n- - - - -\n");

        //  현존하는 인스턴스의 메소드 실행
        Runnable catCryLD = () -> button2.onClick();
        Runnable catCryMR = button2::onClick;//애는 인스턴스 메서드이므로 이렇게쓴다.
        catCryMR.run();







        //  💡 임의의 인스턴스의 메소드 참조
        TreeSet<String> treeSetLD = new TreeSet<>((s1, s2) -> s1.compareTo(s2));
        TreeSet<String> treeSetMD = new TreeSet<>(String::compareTo);



    }
}
