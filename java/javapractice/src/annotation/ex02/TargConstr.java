package annotation.ex02;

@TargAnnot // ⭐️
@Target(ElementType.CONSTRUCTOR)//생성자에 붙을수잇음/
public @interface TargConstr {
}