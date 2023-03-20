import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Random;

public class ContestDriver {
    public static void main(String[] args) {
        ArrayList<Contestant> contestants = new ArrayList<Contestant>();

        int numberOfContestants = 3;
        for (int i = 0; i < numberOfContestants; i++) {
            Contestant newContestant = new Contestant("Contestant#" + i , i);
            contestants.add(newContestant);
        }

        ArrayList<Contestant> game = playAGame(contestants);
        System.out.println("Finished");
        // Print current state of contestants
        for (String record: game.get(0).getRecords()) {
            System.out.println(record);
        }
    }

    public static ArrayList<Contestant> playAGame(ArrayList<Contestant> contestants) {
        System.out.println("Game started!");
        int currentContestantNumber = 0;

        for (int i = 0; i < contestants.size(); i++) {
            Boolean answer = flipACoin();
            Contestant currentContestant = contestants.get(currentContestantNumber);

            if (answer == true) {
                // If contestant is not already in the front then move
                if (currentContestantNumber != 0) {
                    contestants.remove(currentContestant);
                    contestants.add(0, currentContestant);
                    currentContestant.addRecord(getCurrentStand(contestants) + ", Correct Answer and moving " + currentContestant.getName() + " to the front!");
                } else {
                    currentContestant.addRecord(getCurrentStand(contestants) + ", Correct Answer but " + currentContestant.getName() + " already in front!");
                }
                // moving to the next player
                currentContestantNumber += 1;
            } else {
                // If contestant is not already at the end then move to the end
                if (currentContestantNumber != contestants.size()-1) {
                    contestants.remove(currentContestant);
                    contestants.add(currentContestant);
                    currentContestant.addRecord(getCurrentStand(contestants) + ", Wrong answer! Moving " + currentContestant.getName() + " to the end!");
                } else {
                    currentContestant.addRecord(getCurrentStand(contestants) + ", Wrong Answer but " + currentContestant.getName() + " already last!");
                }
            }
        }
        return contestants;
    }

    public static Boolean flipACoin() {
        Random rand = new Random();
        Boolean answer = rand.nextBoolean();
        return answer;
    }

    private static Constable getCurrentStand(ArrayList<Contestant> contestants) {
        StringBuilder stand = new StringBuilder("[");
        for (int i = 0; i < contestants.size(); i++) {
            if (i != contestants.size() - 1) {
                stand.append(contestants.get(i).getName() + ", ");
            } else {
                stand.append(contestants.get(i).getName() + "]");
            }
        }
        return stand.toString();
    }
}