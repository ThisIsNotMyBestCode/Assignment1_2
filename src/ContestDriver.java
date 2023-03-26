import java.util.LinkedList;
import java.util.Random;

public class ContestDriver {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // List contestants
        LinkedList<Contestant> contestants = new LinkedList<Contestant>();


        int numberOfContestants = 10;
        for (int i = 0; i < numberOfContestants; i++) {
            Contestant newContestant = new Contestant("Contestant#" + i , i);
            contestants.add(newContestant);

        }

        playAGame(contestants);

        System.out.println("Finished");

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("#############################################");
        System.out.println("Elapsed time: " + elapsedTime + " ms");
        System.out.println("# of Contestants: " + numberOfContestants);

        System.out.println("############################################# \n");

        // Print current state of contestants
        System.out.println("Printing each contestant record: \n");
        for (var contestant : contestants) {
            System.out.println(contestant.getRecord());
            System.out.println(contestant.getAveragePosition());
        }
    }

    public static void playAGame(LinkedList<Contestant> contestants) {
        System.out.println("Game started!");
        int currentContestantNumber = 0;


        for (int i = 0; i < contestants.size(); i++) {
            Boolean answer = flipACoin();
            Contestant currentContestant = contestants.get(currentContestantNumber);

            // Record initial positions
            if (i == 0) {
                System.out.println("Initial positions:");
                udpateContestantPositions(contestants);
            }

            System.out.println("Current person: "+ currentContestant.getName() + ", Answer: " + answer);


            if (answer) {
                // If contestant is not already in the front then move
                if (currentContestantNumber != 0) {
                    contestants.remove(currentContestant);
                    contestants.add(0, currentContestant);
                    currentContestant.addRecord("Correct Answer and moving " + currentContestant.getName() + " to the front!");
                } else {
                    currentContestant.addRecord("Correct Answer but " + currentContestant.getName() + " already in front!");
                }
                // moving to the next player
                currentContestantNumber += 1;
            } else {
                // If contestant is not already at the end then move to the end
                if (currentContestantNumber != contestants.size()-1) {
                    contestants.remove(currentContestant);
                    contestants.add(currentContestant);
                    currentContestant.addRecord("Wrong answer! Moving " + currentContestant.getName() + " to the end!");
                } else {
                    currentContestant.addRecord("Wrong Answer but " + currentContestant.getName() + " already last!");
                }
            }

            // Record updated positions
            udpateContestantPositions(contestants);
        }
    }

    public static Boolean flipACoin() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public static void udpateContestantPositions(LinkedList<Contestant> contestants) {
        for (int i = 0; i < contestants.size(); i++) {
            Contestant cur = contestants.get(i);
            System.out.println(cur.getName());
            cur.recordCurrentPosition(i);
        }

    }
}
