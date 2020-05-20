/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 *
 * @author evenal
 */
public class RandomWrapper {

    private static RandomWrapper theInstance;

    public static RandomWrapper getInstance() {
        if (theInstance == null)
            theInstance = new RandomWrapper();
        return theInstance;
    }

    private final Random random;

    private RandomWrapper() {
        random = new Random();
    }

    /* return a random value between 0 and 1 */
    public double nextDouble() {
        return random.nextDouble();
    }

    /* return a random int */
    public int nextInt() {
        return random.nextInt();
    }


    public int nextInt(int max) {
        return random.nextInt(max);
    }

    /* return an int between min and max */
    public int nextInt(int min, int max) {
        return min + random.nextInt(max - min);
    }

    /**
     * Decide whether an event with the given probability will happen. For
     * eksample: If there is a 25 % probability of rain, call this method with
     * an argument of 0.25
     *
     * @param probability
     * @return true, if the next random double is within the specified
     * probability
     */
    public boolean isNextDoubleWithinProbability(double probability) {
        return random.nextDouble() < probability;
    }
}
