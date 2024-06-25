package reflection.ex02;

public class Main {


    public static String objToString (Object obj) {
        Class<?> objClass = obj.getClass();

        StringBuilder sb = new StringBuilder();

        sb
                .append("ClassName : ")
                .append(objClass.getSimpleName())//해당클래스의 이름.
                .append("\n");

        for (Field f : objClass.getDeclaredFields()) {

            //  💡 필드가 static인지 여부 확인
            //  - Modifier 클래스의 메서드들 확인해 볼 것 애는 어떤 필드앞에 붙은 수식어
            //즉 public static 이런것들을 가져옴.
            if (Modifier.isStatic(f.getModifiers())) continue;

            f.setAccessible(true);
            try {
                sb.append(
                        " - %s (%s) : %s%n".formatted(
                                f.getName(),
                                f.getType().getSimpleName(),
                                f.get(obj)
                        )
                );
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return sb.toString();
    }



    Person person = new Person("강백호", 25, 180.8, false);

    String personStr = objToString(person);
        System.out.println(personStr);



    public static String objToXML (Object obj) {
        Class<?> objClass = obj.getClass();

        StringBuilder sb = new StringBuilder();

        sb.append(
                "<%s>%n".formatted(objClass.getSimpleName())
        );

        for (Field f : objClass.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            f.setAccessible(true);
            try {
                sb.append(
                        "\t<%s>%s</%s>%n".formatted(
                                f.getName(),
                                f.get(obj),
                                f.getName()
                        )
                );
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        sb.append(
                "</%s>%n".formatted(objClass.getSimpleName())
        );

        return sb.toString();
    }




    String personXml= objToXML(person);
        System.out.println(personXml);
}
