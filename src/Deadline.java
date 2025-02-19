import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
    private boolean complete;

    protected Deadline(String name, LocalDateTime deadline) {
        //constructor
        this.name = name;
        this.dateTime = deadline;
        this.complete = false;
    }


    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public void complete() {
        this.complete = true;
    }
}
