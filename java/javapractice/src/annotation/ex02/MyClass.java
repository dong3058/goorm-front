package annotation.ex02;

@CustomAnnt
@InheritF
@InheritT
public class MyClass {

    @CustomAnnt
    int field;

    //  아래에 이후의 코드들 작성





    @RetSource//애는 빌드후에 myclass.class에 안붙음. 즉 애는 ㅐ생명주기가
            //소스코드까지만 적용. 즉 컴파일후 .class 파일이 나오는 시점에서
            //애는 무용 즉 사라진다.
    int retSource;

    @RetClass//애는 클래스파일 즉 빌드후 .class까지만 존재하고
            //그후에는 존재하지안흠 즉 실행시에는 없어진다.
    int retClass;

    @RetRuntime//애는 실행까지 살아남음 그래서 아래결과에서 애만 출력된다.
    int retRuntime;

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> myClass = Class.forName("sec13.chap02.ex02.MyClass");
        for (Field f : myClass.getDeclaredFields()) {
            if (f.getAnnotations().length > 0) {
                System.out.printf(
                        "%s : %s%n",
                        f.getName(),
                        Arrays.stream(f.getAnnotations())
                                .map(Annotation::toString)
                                .collect(Collectors.joining(","))
                );
            }
        }
    }





    @TargConstr
    public MyClass() { }

    @TargField
    @TargMulti
    //@TargConstr ⚠️ 사용 불가
    int targField;

    @TargMulti
    public void targMethod () {}



    @TargMulti
    boolean targMulti = true;



        //상속체크.inheritT의경우 @inherit이 붙어잇으므로
    //myclass를 상속받은 애는 이 inheritT라는 것을 물려밭음.




     				System.out.println("\n- - - - -\n");

        Class<?> mySubclass = Class.forName("sec13.chap02.ex02.MySubclass");
        System.out.println(
                "MySubclass의 어노테이션 : " +
                Arrays.stream(mySubclass
                .getAnnotations())
                .map(Annotation::toString)
                        .collect(Collectors.joining(","))
                );







    @RepeatF(a = 1, b = 2)
    //@RepeatF(a = 3, b = 4) // ⚠️ 반복 불가

    @RepeatT(a = 1, b = 2)
    @RepeatT(a = 3, b = 4)
    @RepeatT(a = 5, b = 6)
    boolean repeat;
}
