import java.time.LocalDateTime;

public abstract class Deadline extends Event implements Completable {
    protected boolean complete;

    protected Deadline(String name, LocalDateTime deadline) {
        this.name = name;
        this.dateTime = deadline;
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
