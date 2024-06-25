package annotation.ex02;

@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.LOCAL_VARIABLE
})//여러개에 붙는게 가능 메서드 필드,지역변수
public @interface TargMulti { }