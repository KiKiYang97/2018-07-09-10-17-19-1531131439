package practice10;


import java.util.Collection;

public class Teacher extends Person{
    private Collection<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Collection<Klass> klassCollection) {
        super(id, name, age);
        this.classes = klassCollection;
    }

    public Collection<Klass> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Klass> classes) {
        this.classes = classes;
    }

    public String introduce(){
        if(classes.size()>0){
            return super.introduce()+" I am a Teacher. I teach Class "+getEveryKlass(classes)+".";
        }
        else{
            return super.introduce()+" I am a Teacher. I teach No Class.";
        }
    }

    private String getEveryKlass(Collection<Klass> klassCollection) {
        String everyKlass = "";
        for(Klass klass:klassCollection){
            everyKlass += klass.getNumber() + ",";
        }
        return everyKlass.substring(0,everyKlass.length()-1);
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
}
