package bg.softUni.cache.model;

public class StudentDto {

    private final String name;
    private final int age;
    private final int avrScore;

    public StudentDto(String name, int age, int avrScore) {
        this.name = name;
        this.age = age;
        this.avrScore = avrScore;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAvrScore() {
        return avrScore;
    }
}
