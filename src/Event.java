import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event> {
    protected String name;
    protected LocalDateTime dateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDateTime setDateTime(LocalDateTime dateTime) {
        return this.dateTime = dateTime;
    }

    public int compareTo(Event event) {
        return this.dateTime.compareTo(event.dateTime);

    }

}