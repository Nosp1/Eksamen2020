

/**
 *
 * @author evenal
 */
public class Person implements Conf {

    String name;
    State state;
    int day;

    public Person(String name, State state, int day) {
        this.name = name;
        this.state = state;
        this.day = day;
    }
    public boolean isSick(int day) {
        return day <= this.day;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }
}
