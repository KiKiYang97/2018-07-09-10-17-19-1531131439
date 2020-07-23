package practice08;

public class Klass {
    private Integer number;
    private Student leader;

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Student assignLeader(Student student) {
        this.leader = student;
        return student;
    }

    public String getDisplayName() {
        return "Class " + number;
    }
}
