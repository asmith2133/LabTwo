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
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date", "All Events",
                "Meetings", "Deadlines", "Completed Events", "Incomplete Events"});
        filterDisplay = new JCheckBox("Show Completed Events");
        JButton addEventButton = new JButton("Add Event");
        JComboBox<String> eventTypeFilter = new JComboBox<>(new String[]{"All Events", "Meetings", "Deadlines"});
        controlPanel.add(eventTypeFilter);

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
        displayPanel.removeAll(); // Clear the panel

        String selectedFilter = (String) sortDropDown.getSelectedItem();

        // Sorting for Dropdown Box
        for (Event event : events) {
            boolean matchesFilter =
                    selectedFilter.equals("All Events") ||
                            (selectedFilter.equals("Meetings") && event instanceof Meeting) ||
                            (selectedFilter.equals("Deadlines") && event instanceof Deadline) ||
                            (selectedFilter.equals("Completed Events") && event.isComplete()) ||
                            (selectedFilter.equals("Incomplete Events") && !event.isComplete());

            if (matchesFilter) {
                // Add events that match the filter
                EventPanel eventPanel = new EventPanel(event);
                displayPanel.add(eventPanel);
            }
        }

    }

    private void openAddEventModal() {
        AddEventModal modal = new AddEventModal(this);
        modal.setVisible(true);
    }
}

