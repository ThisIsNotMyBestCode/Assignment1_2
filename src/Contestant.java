/* Contestant.java:
 * This class extends Person while adding attributes and methods
 * related to recording performance in the specified contest.
 *
 * Author: Otabek Aripdjanov 597066
 * Last updated:
 */
public class Contestant extends Person {
    private String record;
    public Contestant(String name, int age) {
        super(name, age);
    }

    public void addRecord(String message) {
        this.record = message;
    }

    public String getRecord() {
       return this.record;
    }
}