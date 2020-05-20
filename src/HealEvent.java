public class HealEvent extends Event {
    private Person person;

    public HealEvent(int day, Person person) {
        super(day);
        this.person = person;
    }

    @Override
    public void happen() {
        PandemiSim theSim = PandemiSim.getInstance();
        //if person is is still sick, check if person dies.

        int x = theSim.getToday() - this.day;
        if (x > theSim.MIN_SICK_DAYS && x <  theSim.MAX_SICK_DAYS) {
            boolean dead = RandomWrapper.getInstance().isNextDoubleWithinProbability(theSim.DEATH_PROBILITY);
            if (dead) {
                deadTask();
                System.out.println(person.day + " is dead");
            }

        } else if (this.person.state == State.SICK && x < this.getDay()) {
            immuneTask();
            System.out.println(person.day + " is immune");
        }
    }


    private void deadTask() {
        this.person.state = State.DEAD;

    }

    private void immuneTask() {
        this.person.state = State.IMMUNE;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
