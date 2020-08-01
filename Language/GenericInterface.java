/**
 * 泛型接口，实现该接口要么是泛型类，要么明确接口数据类型，实现类可以有自己的区别于泛型接口的泛型
 * GenericInterface
 */
public interface GenericInterface<K, V> {
    K getKey();
    V getValue();
}
class Generic1<K, V> implements GenericInterface<K, V> {
    K k;
    V v;
    @Override
    public K getKey() {
        return k;
    }
    @Override
    public V getValue() {
        return v;
    }
    public Generic1 (K k, V v) {
        this.k = k;
        this.v = v;
    }
    public static void main(String[] args) {
        Generic1<String, Integer> g1 = new Generic1<>("one", 1);
        Generic2<Double> g2 = new Generic2<>("tow", 2, 0.001);
        System.out.println(g1.getKey() +": " + g1.getValue());
        System.out.println(g2.getKey() + ": " +g2.getValue() + "  t: " + g2.getT());
    }
}
class Generic2<T> implements GenericInterface<String, Integer> {
    String s;
    int i;
    private T t;
    public Generic2 (String s, int i, T t){
        this.s = s;
        this.i = i;
        this.t = t;
    }

    @Override
    public String getKey() {
        return s;
    }

    @Override
    public Integer getValue() {
        return i;
    }
    
    public T getT () {
        return t;
    }
}