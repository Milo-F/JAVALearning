public class GenericityLearning <T> {
    private T x;
    public void setX(T x) {
        this.x = x;
    }
    public T getX() {
        return x;
    }
    public GenericityLearning(T x){
       this.x = x;
    }
    @Override
    public String toString() {
        return this.getClass().getName() + "x:" + x;
    }
    public static void main(String[] args) {
        //泛型类再创建对象的时候指定数据类型。避免了ClassTypeCastException
        GenericityLearning<String> object1 = new GenericityLearning<String>("abcde");
        GenericityLearning<GenericityLearning<String>> object2 = new GenericityLearning<>(object1);
        GenericityLearning<Integer> object3 = new GenericityLearning<Integer>(100);
        System.out.println("object1:" + object1 + "\tobject2:" +object2 + "\tobject3:" +object3);
        System.out.println(object1.getClass() == object2.getClass());
        Child1<Integer> child1 = new Child1<>(101);
        Child2 child2 = new Child2("abcde");
        System.out.println(child1.getX() + "\t" + child2.getX());
        System.out.println(child1.genericMethod("泛型方法"));
        Child1.genericMethod(1, 2, 3, 4, 5);
        Child1.genericMethod("one", "two", "three");
    }
    
}
class Child1<T> extends GenericityLearning<T> {
    // 子类也是泛型类
    public Child1(T x) {
        super(x);
    }
    // 泛型方法，调用的时候根据参数自动确认标识符所代表的类型
    public <E> E genericMethod(E e){
        return e;
    }
    // 可变参数+静态泛型方法
    @SafeVarargs
    public static <E> void genericMethod(E... e) {
        for (E e1 : e) {
            System.out.print(e1);
        }
        System.out.println();
    }
}
class Child2 extends GenericityLearning<String> {
    // 子类不是泛型类，父类要明确数据类型
    public Child2 (String x) {
        super(x);
    }
}
