import java.util.ArrayList;

public class Record {
    public String message;
    public ArrayList<Contestant> currentStatus;

    public Record(String message, ArrayList<Contestant> currentStatus){
        this.message = message;
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return message + currentStatus;
    }
}
