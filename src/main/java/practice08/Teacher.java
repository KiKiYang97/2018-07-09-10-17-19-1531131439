package practice08;


public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public String introduce() {
        if (klass != null) {
            return super.introduce() + " I am a Teacher. I teach Class " + klass.getNumber() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        }
    }

    public String introduceWith(Student student) {
        if (student.getKlass().equals(this.getKlass())) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }
}
