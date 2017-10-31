package first_maven;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
    public String name;
    public int a;
    public Person() {
        a = 10;
        name = "default";
    }
    private Person(String name, int a) {
        this.name = name;
        this.a = a;
    }
    public void fun() {
        System.out.println("fun");
    }
    public void fun(String name, int s) {
        System.out.println(name + s);
    }
    @Override
    public String toString() {
        return name + a;
    }
}
public class Reflection {
    public static void main(String[] args) throws Exception {
//        refGetClass();
     // 获取并调用无参构造函数
//        refGetPublicConstructor();
//
//        // 获取并调用私有的含参构造函数
//        refGetPrivateConstructor();
//
//        // 获取并调用无参方法 fun
//        refGetMethodWithNoArg();
//
//        // 获取并调用有参数方法 fun
//        refGetMethodWithArg();
//
//        // 获取类的字段
        refGetField();
    }
    private static void refGetField() throws Exception {

        Class clazz = Class.forName("first_maven.Person");
        Constructor c = clazz.getDeclaredConstructor(new Class[] { String.class, int.class});
        // 由于构造函数是 private 的，所以需要获取控制权限
        c.setAccessible(true);
        Person p = (Person) c.newInstance(new Object[] { "I'm a reflect name!", 250});

        Field f = clazz.getField("name");//Field只代表字段不代指某一个值
        Object value = f.get(p);//返回指定对象此字段上的值
        Class type = f.getType();
        System.out.println(type);

        if (type.equals(String.class)) {
            System.out.println((String) value);
        }
        System.out.println();
    }
    private static void refGetMethodWithArg() throws Exception {

        Class clazz = Class.forName("first_maven.Person");
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);

        Method method = clazz.getMethod("fun", new Class[] { String.class , int.class});
        method.invoke(p, new Object[] { "I'm a reflect method!", 250});
        System.out.println();
    }

    private static void refGetMethodWithNoArg() throws Exception {

        Class clazz = Class.forName("first_maven.Person");
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);

        Method method = clazz.getMethod("fun", null);
        method.invoke(p, null);
        System.out.println();
    }

    private static void refGetPrivateConstructor() throws Exception {

        Class clazz = Class.forName("first_maven.Person");
        Constructor c = clazz.getDeclaredConstructor(new Class[] { String.class, int.class});

        // 由于构造函数是 private 的，所以需要屏蔽Java语言的访问检查
        c.setAccessible(true);

        Person p = (Person) c.newInstance(new Object[] { "I'm a reflect name!", 100});
        System.out.println(p);
    }

    private static void refGetPublicConstructor() throws Exception {

        Class clazz = Class.forName("first_maven.Person");
        Constructor c = clazz.getConstructor(null);

        Person p = (Person) c.newInstance(null);
        System.out.println(p);
    }

    private static void refGetClass() throws ClassNotFoundException {
        // 加载类的3种方法
        Class clazz = Class.forName("first_maven.Person");
        Class clazz1 = new Person().getClass();
        Class clazz2 = Person.class;
        System.out.println(clazz);
        System.out.println(clazz1);
        System.out.println(clazz2);
    }
}