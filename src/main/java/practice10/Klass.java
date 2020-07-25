package practice10;


import java.util.HashSet;
import java.util.Set;

public class Klass {
    private final Integer number;
    private Student leader;
    private final Set<Integer> studentSet;

    public Klass(Integer number) {
        this.number = number;
        this.studentSet = new HashSet<Integer>();
    }

    public Integer getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public Student assignLeader(Student student) {
        if (!this.studentSet.contains(student.getId())) {
            System.out.print("It is not one of us.\n");
            return null;
        }
        this.leader = student;
        return student;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void appendMember(Student student) {
        this.studentSet.add(student.getId());
    }

    public boolean isIn(Student student) {
        return student.getKlass().getNumber().equals(this.number);
    }
}
