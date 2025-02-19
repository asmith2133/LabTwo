import javax.swing.*;
import java.awt.*;
import java.util.*;

public class EventListPanel extends JPanel {
    private final ArrayList<Event> events;
    private final JPanel displayPanel;
    private final JComboBox<String> sortDropDown;
    private final JCheckBox filterDisplay;


    public EventListPanel() {
        events = new ArrayList<>();
        setLayout(new BorderLayout());

        // Control Panel
        JPanel controlPanel = new JPanel();
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date"});
        filterDisplay = new JCheckBox("Show Completed Events");
        JButton addEventButton = new JButton("Add Event");

        controlPanel.add(sortDropDown);
        controlPanel.add(filterDisplay);
        controlPanel.add(addEventButton);

        add(controlPanel, BorderLayout.NORTH);

        // Display Panel with Grid Layout
        displayPanel = new JPanel(new GridLayout(0, 1));
        displayPanel.setPreferredSize(new Dimension(600, 500));
        add(displayPanel, BorderLayout.CENTER);

        // Set Background Colors for Control / Display Panel
        controlPanel.setBackground(Color.BLUE);
        displayPanel.setBackground(Color.WHITE);


        // Action listeners
        sortDropDown.addActionListener(e -> sortEvents());
        filterDisplay.addActionListener(e -> filterEvents());
        addEventButton.addActionListener(e -> openAddEventModal());
    }

    public void addEvent(Event event) {
        events.add(event);

        EventPanel eventPanel = new EventPanel(event);
        displayPanel.add(eventPanel);

        // Update the Panel
        revalidate();
        repaint();
    }

    // Sort events based on combo box selection
    private void sortEvents() {
        if (sortDropDown.getSelectedIndex() == 0) {
            events.sort(Comparator.comparing(Event::getName)); // Sort by name
        } else {
            events.sort(Comparator.comparing(Event::getDateTime)); // Sort by date
        }
        resetDisplay();
    }

    private void filterEvents() {
        if (!filterDisplay.isSelected()) {
            // Remove completed events
            events.removeIf(Event::isComplete);
        }
        resetDisplay();
    }

    //Reset the Panel
    private void resetDisplay() {
        displayPanel.removeAll();
        for (Event event : events) {
            EventPanel eventPanel = new EventPanel(event);
            displayPanel.add(eventPanel);
        }

        revalidate();
        repaint();

    }

    private void openAddEventModal() {
        AddEventModal modal = new AddEventModal(this);
        modal.setVisible(true);
    }
}

