package annotation.ex02;

@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatF {
    int a();
    int b();
}
