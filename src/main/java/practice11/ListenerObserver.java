package practice11;

/**
 * @Author Dunka
 * @Description 观察者接口
 * @Date 22:02   2020/7/22
 * @ClassName ListenerObserver
 */
public interface ListenerObserver {
    void update(Student student);

    void updateLeader(Student student);
}
