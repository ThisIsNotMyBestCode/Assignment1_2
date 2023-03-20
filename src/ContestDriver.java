import java.util.ArrayList;
import java.util.Random;

public class ContestDriver {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ArrayList<Contestant> contestants = new ArrayList<>();

        int numberOfContestants = 3;
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
        }
    }

    public static void playAGame(ArrayList<Contestant> contestants) {
        System.out.println("Game started!");
        int currentContestantNumber = 0;

        for (int i = 0; i < contestants.size(); i++) {
            Boolean answer = flipACoin();
            Contestant currentContestant = contestants.get(currentContestantNumber);

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
        }
    }

    public static Boolean flipACoin() {
        Random rand = new Random();
        return rand.nextBoolean();
    }
}