package org.r7d.misc;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class DelimiterTest {
    public static final String DELIMITER = "###";

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("stage-billing" + DELIMITER + "fg");
        s.append(DELIMITER).append("Dakshay");
        System.out.println(s.toString());
        System.out.println(Arrays.stream(s.toString().split(DELIMITER)).collect(Collectors.joining()));
    }
}
