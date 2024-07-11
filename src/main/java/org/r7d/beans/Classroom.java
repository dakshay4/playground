package org.r7d.beans;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Classroom {

    private final String name;
    private final Integer capacity;
    private final List<Subject> subjects;


}
