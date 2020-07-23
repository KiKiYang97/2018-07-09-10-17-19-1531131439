package practice10;


public class Klass {
    private Integer number;
    private Student leader;

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public Student assignLeader(Student student) {
        if (!this.number.equals(student.getKlass().getNumber())) {
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

    }

    public boolean isIn(Student student) {
        if (student.getKlass().getNumber().equals(this.number)) {
            return true;
        } else {
            return false;
        }
    }
}
