package errorandexception;

public class Ex02 {


    withFinally1(false);
				System.out.println("\n- - - - -\n");
    withFinally1(true);

    public static void withFinally1 (boolean makeException) {
        try {
            if (makeException) System.out.println("".charAt(0));
            System.out.println("🎉 예외 없이 정상실행됨");
        } catch (Exception e) {
            System.out.println("🛑 예외 발생");
        } finally {
            System.out.println("🏁 무조건 실행");
        }

        //  ❓ 그냥 try 문 밖에 적으면 안 될까?
        System.out.println("🏁 이렇게 말이지.");
    }




    public static char withFinally2 (int index) {
        String str = "Hello";
        try {
            char result = str.charAt(index);
            System.out.println("🎉 예외 없이 정상실행됨");
            return result;
        } catch (Exception e) {
            System.out.println("🛑 예외 발생");
            return '!';
        } finally {
            //  ⭐️ 위에서 return이 발생하더라도 이건 하고 넘어감
            System.out.println("🏁 무조건 실행");
        }

        //  💡 try, catch 블록에 모두 return이 있으므로 --->return 이 발생하면 finally2자체를 종료함
        //그렇기에 바같이ㅡ sout은 실행될수가없는대 finally는 그대로 실행이된다.
        //  이 부분은 작성될 수 없음
        //  System.out.println("🏁 이렇게 말이지.");
    }




    //  💡 다중 catch 문 이후에도 사용됨
    public static void withFinally3 (int i) {
        try {
            switch (i) {
                case 1: System.out.println((new int[1])[1]);
                case 2: System.out.println("abc".charAt(3));
                case 3: System.out.println((Knight) new Swordman(Side.RED));
                case 4: System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);

        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            System.out.printf("%d : 🤮 범위를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        } finally {
            System.out.println("🏁 무조건 실행");
        }
    }
}
