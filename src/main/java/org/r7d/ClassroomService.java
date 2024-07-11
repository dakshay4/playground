package org.r7d;

import org.r7d.beans.Classroom;
import org.r7d.beans.Subject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassroomService {

    public static void main(String[] args) {
        subjectNames();
    }

    public static void subjectNames() {
        Classroom c1 = new Classroom("A", 10, List.of(
                new Subject("English", "Fiction", "Snape"),
                new Subject("Hindi", "Fiction", "DumbleDore")
        ));
        Classroom c2 = new Classroom("B", 40, List.of(new Subject("Mathematics", "Science", "Sirius")));
        List<Subject> subjects = Stream.of(c1,c2).flatMap(e->e.getSubjects().stream()).collect(Collectors.toList());
        System.out.println("Subjects " + subjects);
        System.out.println("Classroom is " + c1);

    }
}
