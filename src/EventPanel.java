import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {

    public EventPanel(Event event) {
        // Stack events vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(500, 100));
        setBackground(Color.LIGHT_GRAY);

        // Set Border Color
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Display event names
        JLabel eventNameLabel = new JLabel("Event: " + event.getName());
        eventNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(eventNameLabel);

        // Display event date and time
        JLabel eventDateLabel = new JLabel("Date: " + event.getDateTime().toString());
        add(eventDateLabel);

        setVisible(true);

        // Display event location
        if (event instanceof Meeting) {
            JLabel eventLocationLabel = new JLabel("Location: " + ((Meeting) event).getLocation());
            add(eventLocationLabel);

            JLabel eventEndDateLabel = new JLabel("End: " + ((Meeting) event).getEndTime().toString());
            add(eventEndDateLabel);
        }

        // Add a Complete button
        // Disable the button once event is complete
        if (event instanceof Completable) {
            JButton completeButton = new JButton("Complete");
            completeButton.addActionListener(e -> {
                ((Completable) event).complete();
                completeButton.setEnabled(false);
            });
            add(completeButton);
        }

        // Set background color for the panel
        setBackground(Color.LIGHT_GRAY);
    }
}
