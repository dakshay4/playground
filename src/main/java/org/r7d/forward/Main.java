package org.r7d.forward;

import java.util.*;

class Main {
    static int numTestCases;
    static int numPassingTestCases;

    public static void main (String[] args) {
        verify(
                2,
                List.of(),
                List.of());
        verify(
                2,
                List.of(kv("A", 1)),
                List.of(kv("A", 1)));
        verify(
                2,
                List.of(kv("A", 1), kv("B", 2), kv("C", 3)),
                List.of(kv("C", 3), kv("B", 2)));
        verify(
                2,
                List.of(kv("A", 1), kv("A", 2)),
                List.of(kv("A", 2)));
        verify(
                2,
                List.of(kv("A", 1), kv("A", 2), kv("B", 3), kv("C", 1)),
                List.of(kv("B", 3), kv("A", 2)));
        verify(
                2,
                List.of(kv("A", 3), kv("A", 2), kv("B", 4), kv("C", 2), kv("C", 6), kv("D", 5)),
                List.of(kv("C", 6), kv("D", 5)));
        verify(
                2,
                List.of(kv("A", 1), kv("B", 1)),
                List.of(kv("A", 1), kv("B", 1)));
        System.out.println("\n" + numPassingTestCases + " passed, " +
                (numTestCases - numPassingTestCases) + " failed");
    }

    private static void verify(int maxCapacity, List<KV> input, List<KV> expected) {
        DedupingTopNCollection<String, KV> coll = new DedupingTopNCollection<>(
                maxCapacity,
                Comparator.comparingInt(o -> o.value),
                kv -> kv.key
        );

    }

    private static void assertEquals(List<KV> actual, List<KV> expected) {
        int n = ++numTestCases;
        if (expected.equals(actual)) {
            numPassingTestCases++;
        } else {
            System.out.println("\n#" + n + " Expected:\n" + expected.toString() + "\n#" + n + " Actual:\n" + actual.toString());
        }
    }

    private static KV kv(String key, int value) {
        return new KV(key, value);
    }

    private static class KV {
        private final String key;
        private final int value;

        private KV(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return '(' + key + ", " + value + ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KV kv = (KV) o;
            return value == kv.value && Objects.equals(key, kv.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}