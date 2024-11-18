package compare;

public class PersonMulti implements Comparable<PersonMulti> {
    private String name;
    private int age;

    public PersonMulti(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(PersonMulti other) {
        // 나이 우선 비교
        int ageCompare = Integer.compare(this.age, other.age);
        if (ageCompare != 0) {
            return ageCompare;
        }

        // 나이가 같으면 이름으로 정렬
        return this.name.compareTo(other.name); // String 클래스에 정의된 compareTo 사용
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
