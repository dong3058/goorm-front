package reflection.ex01;

public class Main throws ClassNotFoundException {

    //reflection은 간단히 말해서 메타데이터를 다루는 방법?
    //  💡 클래스를 가져오는 두 방법
    //  - 와일드카드<?> 사용 가능
    Class<Button> btnClass1 = Button.class;
    //  예외 던짐 : ClassNotFoundException
    Class<?> btnClass2 = Class.forName("sec13.chap01.ex01.Button");

    boolean areSame = btnClass1 == btnClass2;
    //true가나온다 class<?>의 ?는 와일드카드이다.




    //  💡 모든 생성자 배열로 가져오기
    Constructor[] btn1Constrs = btnClass1.getConstructors();

    //  💡 생성자 가져오기
    //  - 주어진 인자 타입에 일치하는 것으로
    //  - 일치하는 것 없을 시 예외 던짐 : NoSuchMethodException 여기서는 메인에다 던져줄거다 이렇게하면안안되긴하는대
    //그냥이렇게한다.
    Constructor<?> btn1Constr = btnClass1
            .getConstructor(String.class, int.class);//생성자의 스펙과 일치하는 애들만 가져온다.



    //  💡 생성자 사용하기
    //  - 예외 던짐 : IllegalAccessException
    Button button1A = (Button) btn1Constr.newInstance("Enter", 3);//newinstance의 결과로
    //나온애는 t라는 타입 즉 아무거나 뱉으므로 명시적 변환이필요.
    //  각각에 맞는 인자들 넣어야 정상동작
    Button button1B = (Button)  btn1Constrs[0].newInstance();
    Button button1C = (Button)  btn1Constrs[1].newInstance("Tab", 2);





    //  💡 필드들 가져오기
    //  - 각 항목 펼쳐서 확인해 볼 것
    Field[] btnFields = btnClass1.getDeclaredFields();

        for (Field f : btnFields) {
        System.out.printf(
                "변수명: %s\n타입: %s\n선언된 클래스: %s\n\n",
                f.getName(),
                f.getType(),
                f.getDeclaringClass()
        );
    }



    //  💡 특정 필드 이름으로 가져오기
    //  - 예외 던짐 : NoSuchFieldException
    //  - public 필드만 가능
    Field btn1Disabled = btnClass1.getField("disabled");
    //Field btnSpaces = btnClass1.getField("spaces"); //




    				System.out.println("\n- - - - -\n");

    //  💡 메소드들 가져오기
    //  - 각 항목 펼쳐서 확인해 볼 것
    Method[] btnMethods = btnClass1.getDeclaredMethods();

        for (Method m : btnMethods) {
        System.out.printf(
                "메소드명: %s\n인자 타입(들): %s\n반환 타입: %s\n\n",
                m.getName(),
                Arrays.stream(m.getParameterTypes())//파라미터들의 타입을 가자욘다는뜻.
                        .map(Class::getSimpleName)
                        .collect(Collectors.joining(", ")),
                m.getReturnType()
        );
    }



    				System.out.println("\n- - - - -\n");

    //  ️⭐ Button 식별자를 코드에서 못 쓰는 상황 가정
    //  - 어떤 클래스가 들어올 지 모르는 상황 등...
    Object button2 = btnClass2
            .getConstructor(String.class, int.class)
            .newInstance("Space", 5);

    Field btn2Disabled = btnClass2.getField("disabled");
    //  💡 특정 인스턴스의 필드 값 얻기
    boolean btn2DisabledVal = (boolean) btn2Disabled.get(button2);
    //즉 버튼2의 disabled값을 가져온다는말.




    //  💡 필드 값 변경
        btn2Disabled.set(button2, true);//버틍2의 disable를 true로.





    //  💡 필드 배열로 접근시
        for (Field f : btnClass2.getDeclaredFields()) {

        f.setAccessible(true); // ⚠️ 이렇게 해주지 않으면 private일 시 예외 발생 즉 private까지 접근가능하게
            //만드는애이다.
        System.out.println(f.getName() + " : " + f.get(button2));
    }



     				System.out.println("\n- - - - -\n");

    //  💡 메소드 호출
    Method btn2onclick = btnClass2
            .getMethod("onClick", boolean.class, int.class, int.class);
    //메서드 이름과 인자들의 이름을 적어준것.
        btn2onclick.invoke(button2, false, 123, 455);
        //버튼2의 onclick메서드를 가져온다.


    				System.out.println("\n- - - - -\n");

    //  💡 상위 클래스와 인터페이스들 가져오기
    Class<?> btn1Super = btnClass1.getSuperclass();//btnlcass의 부모클래스
    Class[] btn1Interfaces = btnClass1.getInterfaces();//인터페이스는 여러개가되니까.
}
