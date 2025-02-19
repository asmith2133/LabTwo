import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPlanner {

    public static void main(String[] args) {
        // Create JFrame with Border Layout
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setLayout(new BorderLayout());

        // Add EventListPanel
        EventListPanel eventListPanel = new EventListPanel();
        frame.add(eventListPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        // Force UI to Refresh
        SwingUtilities.invokeLater(() -> {
            frame.revalidate();
            frame.repaint();
        });


        // Add default events
        addDefaultEvents(eventListPanel);

    }

    public static void addDefaultEvents(EventListPanel events) {
        // Default events
        Event deadlineEvent = new Deadline("Project deadline", LocalDateTime.parse("2025-04-26T00:00:00"));
        Event meetingEvent = new Meeting("Project Meeting", LocalDateTime.parse("2025-03-07T14:00:00"), LocalDateTime.parse("2025-03-07T15:02:00"), "MCS 339");

        // Add events to EventListPanel
        events.addEvent(meetingEvent);
        events.addEvent(deadlineEvent);

    }
}
