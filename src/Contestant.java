import java.util.ArrayList;

/* Contestant.java:
 * This class extends Person while adding attributes and methods
 * related to recording performance in the specified contest.
 *
 * Author: Otabek Aripdjanov 597066
 * Last updated:
 */
public class Contestant extends Person {
    public static  ArrayList<String> records = new ArrayList<String>();
    public Contestant(String name, int age) {
        super(name, age);
    }
    // A Contestant IS-A Person
    // that also needs to keep track of data related to the game
    // Start simple to get your program running, then add attributes and methods as you need them

    // Step 1 Add at least one constructor so the driver will compile and run

    public void addRecord(String message) {
        this.records.add(message);
    }

//    private ArrayList<Contestant>  unpackCurrentStand(ArrayList<Contestant> contestants) {
//        ArrayList<Contestant> currentStand = new ArrayList<Contestant>();
//        for (Contestant contestant: contestants) {
//            currentStand.add(contestant);
//        }
//        return currentStand;
//    }
    // Step 5 Add attributes and methods to assist with recording game statistics

    public ArrayList<String> getRecords() {
       return this.records;
    }
}