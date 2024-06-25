package annotation.ex02;

//  💡 중복 사용될 어노테이션을 묶어주는 역할
//  - ⭐️ @Target, @Retention 등이 있을 때 맞춰주어야 함
@Retention(RetentionPolicy.RUNTIME)
public @interface Repeats {
    RepeatT[] value();
}