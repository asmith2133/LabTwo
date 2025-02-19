import java.time.Duration;
import java.time.LocalDateTime;


public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;


    public Meeting(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        this.name = name;
        this.dateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;
    }

    @Override
    public void complete() {

        this.complete = true;
    }

    // Returns true if the meeting is complete
    @Override
    public boolean isComplete() {

        return complete;
    }

    // Returns the end time of meeting
    public LocalDateTime getEndTime() {

        return endDateTime;
    }

    // Returns the duration of meeting
    public Duration getDuration() {
        // Calculates the duration between start and end time
            return Duration.between(getDateTime(), endDateTime);
        }


    // Returns the location of meeting
    public String getLocation() {

        return location;
    }

    // Setter for the end time of meeting
    public void setEndTime(LocalDateTime endDateTime) {

        this.endDateTime = endDateTime;
    }

    // Setter for the location of meeting
    public void setLocation(String location) {

        this.location = location;
    }

}
