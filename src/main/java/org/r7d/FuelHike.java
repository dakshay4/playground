package org.r7d;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FuelHike {

    DATE("Date");

    private String label;

    FuelHike(String displayName) {
        this.label = displayName;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getAllLabels() {
        return Arrays.stream(FuelHike.values()).map(FuelHike::getLabel).collect(Collectors.toList());
    }
}
