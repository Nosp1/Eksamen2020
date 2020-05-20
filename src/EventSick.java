import java.util.List;

public class EventSick extends Event {
    private Person person;
    private int initialInfectDay;


    public EventSick(int day, Person person) {
        super(day);
        this.person = person;



    }
    public EventSick(int day, Person person, boolean isInitial) {
        super(day);
        this.person = person;
        this.initialInfectDay = day;

    }




    @Override
    public void happen() {
        PandemiSim theSim = PandemiSim.getInstance();
        int contacs = 0;
        while (contacs < RandomWrapper.getInstance().nextInt(theSim.MAX_CONTACTS_PER_DAY)) {
                Person v = theSim.getRandomPerson();
            if (v.getState() == State.CLEAN) {
                boolean infectHappen = RandomWrapper.getInstance().isNextDoubleWithinProbability(theSim.SICK_PROBABILITY);
                if (infectHappen) {
                    v.state = State.SICK;
                    theSim.getInfected().add(v);
                    theSim.addEvent(new EventSick(getDay() + 1, v));
                    theSim.addEvent(new EventSick(getDay() +1, person));
                    theSim.addEvent(new HealEvent(getDay() + RandomWrapper.getInstance().nextInt(theSim.MIN_SICK_DAYS, theSim.MAX_SICK_DAYS), v));
                    contacs++;
                }

            } else {

                contacs++;
            }
        }

    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
