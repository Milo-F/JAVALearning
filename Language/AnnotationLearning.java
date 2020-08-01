import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * AnnotationLearning
 * 
 * @since 1.5
 * @author milo
 * @version 1.0
 * 
 */
@SuppressWarnings("all")
public class AnnotationLearning {

    public static void main(String[] args) {
        AnnotationLearning a = new AnnotationLearning();
    }

    /**
     * 计算两数的和
     * 
     * @param a 加数
     * @param b 另一个加数
     * @return 和
     */
    public int addItem(int a, int b) {
        return a + b;
    }

    @Deprecated
    public void show() {
        System.out.println("Deprecated");
    }

    @MyAnnotation(show1 = 0, show2 = "a")
    public void show2() {
        System.out.println("new show");
    }
}

@Target(ElementType.METHOD)
@interface MyAnnotation {
    int show1();

    String show2() default "b";

    Override show3() default @Override;

    String[] show4() default { "a", "b" };
}

// class MyAnno implements MyAnnotation {
// public int show1() {
// return 0;
// }

// public String show2() {
// return "a";
// }

// }