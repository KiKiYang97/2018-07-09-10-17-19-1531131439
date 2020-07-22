package practice11;

import java.util.LinkedList;

public class Teacher extends Person implements ListenerObserver{
    private LinkedList<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klassLinkedList) {
        super(id, name, age);
        this.classes = klassLinkedList;
        klassLinkedList.forEach(klass -> {
            klass.register(this);
        });
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    public void setClasses(LinkedList<Klass> classes) {
        this.classes = classes;
    }

    public String introduce(){
        if(classes!=null){
            return super.introduce()+" I am a Teacher. I teach Class "+getEveryKlass(classes)+".";
        }
        else{
            return super.introduce()+" I am a Teacher. I teach No Class.";
        }
    }

    private String getEveryKlass(LinkedList<Klass> klassLinkedList) {
        String everyKlass = "";
        for(Klass klass:klassLinkedList){
            everyKlass += klass.getNumber() + ", ";
        }
        return everyKlass.substring(0,everyKlass.length()-2);
    }

    public boolean isTeaching(Student student){
        final boolean[] flag = {false};
        classes.forEach(klass -> {
            if(klass.isIn(student)){
                flag[0] = true;
            }
        });
        return flag[0];
    }

    public String introduceWith(Student student){
        String introduce = "";
        for(Klass clazz:classes){
            if(student.getKlass().equals(clazz)){
                introduce = super.introduce()+" I am a Teacher. I teach "+student.getName()+".";
            }else{
                introduce = super.introduce()+" I am a Teacher. I don't teach "+student.getName()+".";
            }
        }
        return introduce;
    }

    @Override
    public void update(Student student) {
        String output = String.format("I am %s. I know %s has joined Class %s.\n",
                this.getName(),student.getName(),student.getKlass().getNumber());
        System.out.print(output);
    }

    @Override
    public void updateLeader(Student student) {
        String output = String.format("I am %s. I know %s become Leader of Class %s.\n",
                this.getName(),student.getName(),student.getKlass().getNumber());
        System.out.print(output);
    }

}
