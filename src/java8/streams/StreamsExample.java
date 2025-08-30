package java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
     ArrayList<Student> students = new ArrayList<>();
     students.add(new Student("201","Parth","Male"));
     students.add(new Student("301","Bruce","Male"));
     students.add(new Student("103","Selina","Female"));
     students.add(new Student("104","Arjun","Male"));
     students.add(new Student("105","Ivy","Female"));
        List<Student> male = students.stream()
                .filter(e -> !e.getGender().equals("Male"))
                .toList();
        students.stream()
                .map(Student::getId)
                .sorted()
                .forEach(System.out::println);
        ArrayList<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        integers.stream().filter(e->e%2==0).forEach(System.out::println);
        Map<Integer, Integer> collect = integers.stream()
                .collect(Collectors.toMap(e -> e, e -> e * e));
        System.out.println(collect);
        Optional<Integer> reduce = integers
                .stream()
                .reduce(Integer::sum);
        if(reduce.isPresent())
        { System.out.println(reduce.get());
        }
        integers.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        })
    .limit(5).forEach(System.out::println);
        integers.stream().skip(5).forEach(System.out::println);
    }
}
