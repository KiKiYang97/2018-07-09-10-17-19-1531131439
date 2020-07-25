package practice11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Klass {
    private Integer number;
    private Student leader;
    private Set<Integer> studentIdsSet;
    private Collection<ListenerObserver> observers;

    public Klass(Integer number) {
        this.number = number;
        this.studentIdsSet = new HashSet<>();
        this.observers = new ArrayList<>();
    }

    public Integer getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student student) {
        if (!this.studentIdsSet.contains(student.getId())) {
            System.out.print("It is not one of us.\n");
        }
        this.leader = student;
        notifyLeader(student);
    }

    public String getDisplayName() {
        return String.format("Class %d",number);
    }

    public void appendMember(Student student) {
        student.getKlass().studentIdsSet.remove(student.getId());
        student.setKlass(this);
        this.studentIdsSet.add(student.getId());
        notifyAppendMember(student);
    }

    public boolean isIn(Student student) {
        if (this.studentIdsSet.contains(student.getId())) {
            return true;
        } else {
            return false;
        }
    }

    public void register(ListenerObserver observer) {
        this.observers.add(observer);
    }

    public void notifyAppendMember(Student student) {
        for (ListenerObserver observer : observers) {
            observer.update(student);
        }
    }

    public void notifyLeader(Student student) {
        for (ListenerObserver observer : observers) {
            observer.updateLeader(student);
        }
    }

}
