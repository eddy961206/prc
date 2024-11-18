package compare;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    // Comparable 구현
    @Override
    public int compareTo(Person other) {
        // 나이 기준 비교
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

}
