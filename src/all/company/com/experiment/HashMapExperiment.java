package all.company.com.experiment;

import java.util.HashMap;
import java.util.Map;


class Student extends Object{
    int id;
    String name;

    Student(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override public int hashCode() {
        return 1;
    }

    @Override public boolean equals(final Object obj) {
        return false;
    }
}

public class HashMapExperiment {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();
        Student student = new Student(1,"A");
        map.put(student,student.id);
        //student = new Student(2, "B");
        map.put(student,2);
//        student = new Student(3, "C");
        map.put(student,3);
//        student = new Student(4, "D");
        map.put(student,4);
//        student = new Student(5, "E");
        map.put(student,5);
//        System.out.println("Values");
        for(Map.Entry<Student, Integer> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println(map.get(student));
    }
}
