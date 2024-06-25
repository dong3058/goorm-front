package annotation.ex02;

@Repeatable(Repeats.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatT {
    //  💡 다음 강에서 배움
    int a();
    int b();
}
