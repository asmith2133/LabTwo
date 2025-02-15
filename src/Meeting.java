import java.time.Duration;
import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.time.Duration;

public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;


    public Meeting(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
        if (endDateTime == null) {
            throw new IllegalArgumentException("End date time cannot be null");
        }
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

    // Returns the end time of the meeting
    public LocalDateTime getEndTime() {
        return endDateTime;
    }

    // Returns the duration of the meeting
    public Duration getDuration() {
            return Duration.between(getDateTime(), endDateTime); // Calculates the duration between start and end time
        }


    // Returns the location of the meeting
    public String getLocation() {
        return location;
    }

    // Sets the end time of the meeting
    public void setEndTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    // Sets the location of the meeting
    public void setLocation(String location) {
        this.location = location;
    }

}
