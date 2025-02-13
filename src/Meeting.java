import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Meeting extends Event implements Completable {
    protected String location;
    protected LocalDateTime endDateTime;

    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        this.name = name;
        this.dateTime = start;
        this.dateTime = end;
        this.location = location;
    }

    public void setLocation() {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setEndTime(LocalDateTime end) {
        this.endDateTime = end;
    }

    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    @Override
    public void complete() {
        boolean complete = true;
    }

    @Override
    public boolean isComplete() {
        return endDateTime.isBefore(LocalDateTime.now());
    }

    public Duration getDuration(){
        return Duration.between(dateTime, endDateTime);

    }
}
