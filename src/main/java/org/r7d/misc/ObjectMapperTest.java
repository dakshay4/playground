package org.r7d.misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.util.List;

public class ObjectMapperTest {

    public static void main(String[] args) {
        Student s1 = new Student(1,1,"dakshay");
        Student s2 = new Student(2,2,"Kunika");
        Student s3 = new Student(3,4,"Nikhil");

        MResponseEntity<List<Student>> res = MResponseEntity.okResponse(List.of(s1,s2,s3));
        ObjectMapper om = new ObjectMapper();
        MResponseEntity<List<Student>> o = null;
        try {
            o = om.readValue(new Gson().toJson(res), new TypeReference<MResponseEntity<List<Student>>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for(Student s : o.getData()) {
            System.out.println(s.getName());
        }
    }
}
