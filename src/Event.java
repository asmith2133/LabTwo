import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    protected String name;
    protected LocalDateTime dateTime;

    public String getName() {
        // Get Name
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        // Get Date/Time
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {

        this.dateTime = dateTime;
    }

    public int compareTo(Event event) {
        return this.dateTime.compareTo(event.dateTime);

    }
    public abstract boolean isComplete();

}