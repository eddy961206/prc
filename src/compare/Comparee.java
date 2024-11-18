package compare;

import java.util.ArrayList;
import java.util.Collections;

public class Comparee {
    public static void main(String[] args) {

        //Person 리스트 생성
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 20));
        people.add(new Person("Charlie", 25));

        // 정렬 전 출력
        System.out.println("Before sorting");
        for (Person person : people) {
            System.out.println(person);
        }

        // 정렬 수행
        Collections.sort(people);

        // 정렬 후 출력
        System.out.println("\nAfter sorting : ");
        for (Person person : people) {
            System.out.println(person);
        }

    }

    public static class MultiCriteriaExample {
        public static void main(String[] args) {
            ArrayList<PersonMulti> people = new ArrayList<>();
            people.add(new PersonMulti("Alice", 25));
            people.add(new PersonMulti("Bob", 30));
            people.add(new PersonMulti("Charlie", 25));
            people.add(new PersonMulti("David", 20));

            // 정렬 전 출력
            System.out.println("Before sorting:");
            for (PersonMulti p : people) {
                System.out.println(p);
            }

            // 정렬 수행
            Collections.sort(people);

            // 정렬 후 출력
            System.out.println("\nAfter sorting:");
            for (PersonMulti p : people) {
                System.out.println(p);
            }


        }
    }

}
