import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    private final JTextField nameField;
    private final JTextField dateField;
    private final JTextField timeField;
    private final JTextField locationField;
    private final JTextField durationField;
    private final EventListPanel eventListPanel;

    public AddEventModal(EventListPanel eventListPanel) {
        // Panel to add events
        this.eventListPanel = eventListPanel;
        setTitle("Add Event");
        setSize(300, 300);
        setLayout(new GridLayout(6, 2));

        nameField = new JTextField();
        dateField = new JTextField();
        timeField = new JTextField();
        locationField = new JTextField();
        durationField = new JTextField();

        // Submit Button for Adding Events
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this::onSubmit);

        // Requirements for Adding Events
        add(new JLabel("Event Name"));
        add(nameField);
        add(new JLabel("Date (YYYY-MM-DD)"));
        add(dateField);
        add(new JLabel("Time (HH:MM)"));
        add(timeField);
        add(new JLabel("Location"));
        add(locationField);
        add(new JLabel("Duration (in minutes)"));
        add(durationField);
        add(submitButton);

        setModal(true);
        setLocationRelativeTo(null);
    }

    private void onSubmit(ActionEvent e) {
        String name = nameField.getText();
        String date = dateField.getText();
        String time = timeField.getText();
        String location = locationField.getText();
        int duration = Integer.parseInt(durationField.getText());

        // Create a new Meeting event and add it to the list
        Event event = new Meeting(name, LocalDateTime.parse(date + "T" + time),
                LocalDateTime.parse(date + "T" + time).plusMinutes(duration), location);
        eventListPanel.addEvent(event);

        dispose();  // Close the modal dialog
    }
}
