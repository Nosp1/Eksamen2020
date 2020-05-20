public class ImmunEvent extends Event {
    Person person;
    public ImmunEvent(int day, Person person) {
        super(day);
        this.person = person;
    }

    @Override
    public void happen() {

    }

    public Person getPerson() {
        return person;
    }
}
