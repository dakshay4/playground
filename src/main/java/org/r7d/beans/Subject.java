package org.r7d.beans;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Subject {

    private final String name;
    private final String type;
    private final String professor;


}
