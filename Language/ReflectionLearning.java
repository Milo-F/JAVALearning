import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectionLearning
 */
public class ReflectionLearning {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException,
            IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        // 1.Class.forName("全类名")
        Class<?> cls1 = Class.forName("Person");
        System.out.println(cls1);
        // 2.类名.class
        Class<?> cls2 = Person.class;
        System.out.println(cls2);
        // 3.对象.getClass()
        Person person1 = new Person();
        Class<?> cls3 = person1.getClass();
        System.out.println(cls3);
        // 比较，三种获取class方法获取的class指向的都是同一个字节码.class文件，即同一个类。
        System.out.println(cls1 == cls2);// true
        System.out.println(cls1 == cls3);// true

        Field[] fields = cls1.getFields();// 获取所有public成员变量
        for (Field field : fields) {
            System.out.println(field);
        }
        fields[0].set(person1, "male");// 给具体的对象设置成员变量
        System.out.println(fields[0].get(person1));// 使用Field的get方法获取对象中成员变量的值

        Field[] fields2 = cls1.getDeclaredFields();// 获取所有的成员变量
        for (Field field : fields2) {
            System.out.println(field);
        }
        fields2[0].setAccessible(true);// 暴力反射
        fields2[0].set(person1, "july");
        System.out.println(fields2[0].get(person1));

        // 获取构造器
        Constructor<?> constructor = cls1.getConstructor(String.class, int.class);
        person1 = (Person) constructor.newInstance("jack", 32);

        // 获取成员方法
        Method method = cls1.getMethod("getName");
        Method method2 = cls1.getMethod("setName", String.class);
        String mothodName = method.getName();// 获取方法名
        method2.invoke(person1, "tutu");// 运行成员方法
        System.out.println(method.invoke(person1));
        System.out.println(mothodName);

        // 获取类名
        System.out.println(cls1.getSimpleName());
        System.out.println(cls1.getName());
    }

}

class Person {
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    private String name;
    private int age;
    public String sex;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": (name: " + this.name + "; age: " + this.age + ")";
    }
}