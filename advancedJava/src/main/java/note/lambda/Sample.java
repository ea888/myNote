package note.lambda;

import note.lambda.FunctionalIF;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String args[]){
        FunctionalIF fi = (s) -> {System.out.println(s);};
        fi.print("I'm the functional interface");


        ExecutorService exec = Executors.newCachedThreadPool();

        //lambda callable
        String a = "abc";
        Callable<String> c = () -> {Thread.sleep(1000);return a.substring(1);};

        Callable<String> cc = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return a.substring(1);
            }
        };

        try {
            System.out.println(exec.submit(c).get());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Runnable r = () -> {System.out.println("I'm a thread!");};
        Runnable rr = new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a thread!");
            }
        };

        r.run();
        rr.run();



        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        //Pay attention to parallelStream, don't use it unless there are heavy calculating involved
        List<String> results = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        results.stream().forEach(System.out::println);

        long count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("Strings of length 3: " + count);

        strings.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        System.out.println(strings.stream().reduce((e,f) -> e + f).get());
    }
}
