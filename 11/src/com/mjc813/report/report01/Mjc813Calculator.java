package com.mjc813.report.report01;

public class Mjc813Calculator {

    // arrs 값들의 모든 합을 구해야 합니다.
    // 다만 arrs 배열이 null 일 수 있으므로 예외처리를 이곳이든 이곳을 호출하는 메소드에서든 꼭 해야 합니다.
    public Long sum(Integer... arrs) {
        long result = 0L;
        if (arrs == null) {
            return result;
        }
        for (Integer v : arrs) {
            if (v != null) {
                result += v;
            }
        }
        return result;
    }

    // arrs 배열중에서 start ~ end 인덱스 까지의 원소들의 모든 합을 구해야 합니다.
    // 다만 arrs 배열이 null 일 수 도 있고, 원소가 null 일 수도 있고
    // 배열 인덱스 start ~ end 가 문제가 생길 수 도 있습니다.
    // 그러므로 예외처리를 꼭 해야 합니다.
    public Long sum(Integer[] arrs, Integer start, Integer end) {
        if (arrs == null) {
            throw new IllegalArgumentException("arrs must not be null");
        }
        if (start == null || end == null) {
            throw new IllegalArgumentException("start and end must not be null");
        }
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("start and end must be >= 0");
        }
        if (start > end) {
            throw new IllegalArgumentException("start must be <= end");
        }
        if (start >= arrs.length || end >= arrs.length) {
            throw new IndexOutOfBoundsException(
                    String.format("Range [%d, %d] out of bounds for length %d", start, end, arrs.length)
            );
        }

        long result = 0L;
        for (int i = start; i <= end; i++) {
            Integer v = arrs[i];
            if (v != null) {
                result += v;
            }
        }
        return result;
    }
}