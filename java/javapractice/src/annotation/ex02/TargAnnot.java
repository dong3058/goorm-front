package annotation.ex02;

@Target(ElementType.ANNOTATION_TYPE)
//애도 어노테이션을 위한 어노테이션임. 그러니까 커스텀 어노테이션인
//targannot가 어디에 붙을수잇는 어노테이션인지를 설명하는게 target어노테이션
public @interface TargAnnot { }