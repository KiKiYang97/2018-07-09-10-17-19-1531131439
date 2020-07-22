package practice11;

import java.util.ArrayList;
import java.util.Collection;

public class Klass {
    private Integer number;
    private Student leader;
    private Collection<ListenerObserver> observers;

    public Klass(Integer number) {
        this.number = number;
        this.observers = new ArrayList<ListenerObserver>();
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

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Collection<ListenerObserver> getObservers() {
        return observers;
    }

    public void setObservers(Collection<ListenerObserver> observers) {
        this.observers = observers;
    }

    public Student assignLeader(Student student){
        if(!this.number.equals(student.getKlass().getNumber())){
            System.out.print("It is not one of us.\n");
            return null;
        }
        this.leader = student;
        notifyLeader(student);
        return student;
    }

    public String getDisplayName() {
        return "Class "+number;
    }

    public void appendMember(Student student){
        notifyAppendMember(student);
    }

    public boolean isIn(Student student) {
        if(student.getKlass().getNumber().equals(this.number)){
            return true;
        }else{
            return false;
        }
    }

    public void register(ListenerObserver observer){
        this.observers.add(observer);
    }

    public void notifyAppendMember(Student student){
        for(ListenerObserver observer:observers) {
            observer.update(student);
        }
    }

    public void notifyLeader(Student student){
        for(ListenerObserver observer:observers){
            observer.updateLeader(student);
        }
    }

}
