package alg.arrays;

import java.util.*;

public class SumOfCube {

    private static class Pair {
        final long x;
        final long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        findAll(10);
    }

    private static void findAll(int maxVal) {
        Map<Long, List<Pair>> map = new HashMap<>();
        for (long a = 0; a < maxVal; ++a) {
            for (long b = 0; b < maxVal; ++b) {
                long val = (long)Math.pow(a, 3) + (long)Math.pow(b, 3);
                List<Pair> pairs = map.get(val);
                if (pairs == null) {
                    pairs = new ArrayList<>();
                }
                    pairs.add(new Pair(a, b));
                    map.put(val, pairs);
            }
        }
        for(Long key: map.keySet()){
            List<Pair> pairs = map.get(key);
            StringBuilder sb = new StringBuilder("Sum is " + key + ". ");
            for (Pair pair1: pairs) {
                for (Pair pair2: pairs) {
                    sb.append(pair1).append(pair2).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}
