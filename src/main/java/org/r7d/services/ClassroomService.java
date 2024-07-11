package org.r7d.services;

import com.fasterxml.jackson.core.type.TypeReference;
import org.r7d.beans.Classroom;
import org.r7d.beans.ProfessorPair;
import org.r7d.util.FileResourceReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassroomService {



    public Map<ProfessorPair, Set<String>> createPair() {
        List<Classroom> classrooms = FileResourceReader.readResource("Classroom.json", new TypeReference<List<Classroom>>() {
        });

        return classrooms.stream().flatMap(classroom->classroom.getSubjects().stream()
                .map(subject -> new HashMap.SimpleEntry<>(
                        new ProfessorPair(subject.getName(), subject.getProfessor()), classroom.getName())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));
    }

    public static void main(String[] args) {
        ClassroomService classroomService = new ClassroomService();
        Map<ProfessorPair, Set<String>> pair = classroomService.createPair();
        pair.forEach((key, value) -> System.out.println(key + " : " + value));

        ProfessorPair test = new ProfessorPair("Art", "Prof. Brown");
        pair.get(test).forEach(value -> System.out.println("Value " + value));

    }
}
