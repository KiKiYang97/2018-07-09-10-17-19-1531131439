package practice02;

public class Student extends Person{
    private int klass;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, int kclass) {
        super(name, age);
        this.klass = kclass;
    }

    public int getKlass() {
        return klass;
    }

    public void setKlass(int kclass) {
        this.klass = kclass;
    }

    public String introduce(){
        return "I am a Student. I am at Class "+klass+".";
    }
}
