package practice11;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
//        object equals
        if (klass.getLeader() == this) {
            return super.introduce() + String.format(" I am a Student. I am Leader of Class %d.", klass.getNumber());
        } else {
            return super.introduce() + String.format(" I am a Student. I am at Class %d.", klass.getNumber());
        }
    }
}
