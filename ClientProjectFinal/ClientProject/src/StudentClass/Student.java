package StudentClass;

public class Student {
    private String name;
    private int id;
    private int grade;
    private String gender;

    public Student(String name, int id, int grade, String gender) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentClass.Student{ " +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grade=" + grade +
                ", gender='" + gender + '\'' +
                " }";
    }
}
