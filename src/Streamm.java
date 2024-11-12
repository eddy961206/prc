import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamm {

    public static void main(String[] args) {
        // 1. 컬렉션으로부터 스트림 생성
        List<String> fruits = Arrays.asList("banana", "apple", "orange", "grape", "melon");

        // 2. 필터링 (filter)
        System.out.println("--- Filtering ---");
        fruits.stream()
                .filter(f -> f.length() > 5)
                .forEach(System.out::println);

        // 3. 매핑 (map)
        System.out.println("--- Mapping ---");
        List<String> newFriuts;
        newFriuts = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("fruits = " + fruits);
        System.out.println("newFriuts = " + newFriuts);

        // 4. 숫자 스트림 활용
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 합계 계산
        System.out.println("--- Sum ---");
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum = " + sum);

        // 5. 정렬 (sorted)
        System.out.println("--- Sorting ---");
        List<String> sortedFruits = fruits.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sortedFruits = " + sortedFruits);

        // 6. 중복제거 (distinct)
        System.out.println("--- Distinct ---");
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5);
        List<Integer> distinctNumbers = duplicateNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctNumbers = " + distinctNumbers);

        // 7. 제한 (limit)
        System.out.println("--- Limit ---");
        List<String> limitedFruits = fruits.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("limitedFruits = " + limitedFruits);

        // 8. 스킵 (skip)
        System.out.println("--- Skip ---");
        List<String> skippedList = fruits.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("skippedList = " + skippedList);

        // 9. 그룹화 (collect groupingBy)
        System.out.println("--- Collect Grouping By ---");
        Map<Integer, List<String>> groupedByLength = fruits.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length : " + groupedByLength);

        // 10. 집계 함수
        System.out.println("--- Aggregation ---");
        double avg = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("avg = " + avg);

        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("max = " + max);

        // 11. anyMatch, allMatch, noneMatch
        System.out.println("--- Matching ---");
        boolean hasLongFruit = fruits.stream()
                .anyMatch(f -> f.length() > 5);
        System.out.println("Has fruit longer than 5 chars : " + hasLongFruit);

        Optional<String> first = fruits.stream()
                .filter(f -> f.length() > 5)
                .findAny();
        System.out.println("longFruit = " + first.orElse("없음"));

        // 12. reduce 연산
        System.out.println("--- Reducing ---");
        int multiplication = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Multiplication of all numbers = " + multiplication);














    }

}
