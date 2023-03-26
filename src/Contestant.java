/* Contestant.java:
 * This class extends Person while adding attributes and methods
 * related to recording performance in the specified contest.
 *
 * Author: Otabek Aripdjanov 597066
 * Last updated:
 */

import java.util.LinkedList;

public class Contestant extends Person {
    private String record;
    private LinkedList<Integer> positions = new LinkedList<>();

    public Contestant(String name, int age) {
        super(name, age);
    }

    public void addRecord(String message) {
        this.record = message;
    }

    public String getRecord() {
        return this.record;
    }

    public void recordCurrentPosition(int currentPosition) {
        this.positions.add(currentPosition);
    }

    // Does this need to be returning "int"?
    public double getAveragePosition() {
        double avgPosition = 0;

        System.out.println(this.positions);

        // Check if the list has elements at all. Return 0 if false
        if(!this.positions.isEmpty()) {
            int sum = 0;

            // Loop through the positions list and calculate the sum
            for (Integer position : this.positions) {
                sum += position;
            }

            avgPosition = (double) sum/this.positions.size(); //.doubleValue()
        }
        return avgPosition;
    }



}