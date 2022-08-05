package Folder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Вася", 23));
        list.add(new Student("Петя", 26));
        list.add(new Student("Alice", 17));
        list.add(new Student("Bob" , 16));

        printList(list);

        System.out.println("\nПо возрасту");
        list.sort(Comparator.comparingInt(Student::getAge));
        printList(list);

        System.out.println("\nПо алфавиту");
        list.sort(Comparator.comparing(Student::getName));
        printList(list);

        System.out.println("\nПо длинне имени");

        Comparator<Student> NameComparator = (stud1, stud2) -> stud2.getName().length() - stud1.getName().length();

        list.sort(NameComparator);

        printList(list);

        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "Привет", "как", "дела?");
        printList(strings);
        list.forEach(student -> student.setAge(student.getAge() + 12));
        list.forEach(System.out::println);

        String min = strings.stream().min(Comparator.comparingInt(String::length)).get();
        System.out.println("Minimum length string in strings " + min);
    }



    public static <T> void printList(ArrayList<T> list) {
        for (T obj : list) {
            System.out.println(obj.toString());
        }
    }


}
