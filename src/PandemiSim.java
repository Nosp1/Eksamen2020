import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * PandemiSim is the main class of the application. It contains the main loop,
 * which advances the time, and a secondary loop that goes through the events of
 * the current day
 */
public class PandemiSim implements Conf {
    // PandemiSim uses the singleton pattern
    // to make the single PandemiSim object available everywhere.
    private static final PandemiSim theInstance
            = new PandemiSim();
    private Person[] population;
    private List<Person> infected;
    private List<Event> init;
    private PriorityQueue<Event> eventQueue;
    // the day that are currently being simulated
    private int today;


    public PandemiSim() {
        this.eventQueue = new PriorityQueue<>();
        this.population = new Person[POPULATION];
        this.infected = new ArrayList<>();
        this.init = new ArrayList<>();
        initiatePopulation();
        makeRandomSick();
        init();


    }

    public static PandemiSim getInstance() {
        return theInstance;
    }

    // main just starts the sim
    public static void main(String[] args) {
        PandemiSim sim = PandemiSim.getInstance();
        sim.run();

    }

    public int getToday() {
        return today;
    }

    public void initiatePopulation() {
        for (int i = 0; i <= population.length - 1; i++) {
            population[i] = new Person(Integer.toString(i), State.CLEAN, 0);
        }
        System.out.println("initialisation succesfull");
    }

    public void init() {
        for (Person infect : infected
        ) {
            init.add(new EventSick(today, infect));
            init.add(new HealEvent(getToday() + RandomWrapper.getInstance().nextInt(MIN_SICK_DAYS, MAX_SICK_DAYS), infect));
        }

        eventQueue.addAll(init);
    }

    public void makeRandomSick() {

        for (int i = 0; i < INITALLY_SICK; i++) {
            Person v = getRandomPerson();
            if (v.getState() != State.SICK) {
                v.state = State.SICK;
                infected.add(v);
            } else {
                i--;
            }

        }
        System.out.println("sick successful");
    }

    public List<Person> getInfected() {
        return infected;
    }

    public void run() {
        for (int day = 0; day < MAX_DAY; day++) {
            System.out.println("the day is : " + day);
            runDay(day);
            printStats(day);
        }
    }

    /**
     * Get all events that happen on the specified day, and make them happen()
     *
     * @param day
     */
    private void runDay(int day) {
        today = day;
        int eventQueSize = eventQueue.size();
        for (int i = 0; i < eventQueSize; i++) {
            Event e = eventQueue.peek();
            if (e.getPerson().state == State.DEAD || e.getPerson().state == State.IMMUNE) {
            } else if (e.getDay() == today && e instanceof EventSick) {
                e.happen();
                eventQueue.poll();
            } else if (e.getDay() <= today && e instanceof HealEvent) {
                e.happen();
            }
            // get the next event, Oppgave 1b
        }


    }
    public void printStats(int today) {

            System.out.println("day: " + today);
            getSick();
            getDead();
            getClean();
            getImmune();


    }
    public int getSick() {

        int sum = 0;
        System.out.println("Infected ");
        for (Person v: population
             ) {
                if (v.state == State.SICK) {
                    sum++;
                }
        }
        System.out.print(sum);
        return sum;
    }
    public int getDead() {

        int sum = 0;
        System.out.println("DEAD ");
        for (Person v: population
        ) {
            if (v.state == State.DEAD) {
                sum++;
            }
        }
        System.out.print(sum);
        return sum;
    }
    public int getImmune() {

        int sum = 0;
        System.out.println("Immune");
        for (Person v: population
        ) {
            if (v.state == State.IMMUNE) {
                sum++;
            }
        }
        System.out.print(sum);
        return sum;
    }

    public int getClean() {

        int sum = 0;
        System.out.println("Clean");
        for (Person v: population
        ) {
            if (v.state == State.CLEAN) {
                sum++;
            }
        }
        System.out.print(sum);
        return sum;
    }




    public Person getRandomPerson() {
        RandomWrapper random = RandomWrapper.getInstance();
        int i = random.nextInt(POPULATION);
        return population[i];
    }
    public Person getRandPerson(Person[] p) {
        RandomWrapper randomWrapper = RandomWrapper.getInstance();
        int i = randomWrapper.nextInt(p.length);
        return p[i];
    }


    public void addEvent(Event e) {
        // Oppgave 1 b
        if (null == e)
            return;
        eventQueue.add(e);


    }


}

