package note.reflection;


import java.lang.annotation.Annotation;

public class Client3 {

    public static void main(String[] args) {
        System.out.println(args[0]);

        ReflectionExample re = new ReflectionExample();
        re.print();

        System.out.println("------------------------");
        try {
            Class aClass = Class.forName(args[0]);
            Annotation[] annotations = aClass.getAnnotations();
            for(Annotation annotation : annotations){
                System.out.println(annotation.toString());
            }

            ReflectionInterface re2 = (ReflectionInterface)aClass.newInstance();
            re2.print();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
