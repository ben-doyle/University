package planner.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import planner.Event;

/**
 * The controller for the event allocator program.
 *
 * Invariant:
 *      model != null &&
 *      view != null;
 */
class EventAllocatorController {

    // Correct line separator for executing machine (used in toString method)
    private final static String NEW_LINE = System.getProperty(
            "line.separator");
    // the model of the event allocator
    private EventAllocatorModel model;
    // the view of the event allocator
    private EventAllocatorView view;

    /**
     * Initialises the controller for the event allocator program.
     *
     * @param model the model of the event allocator
     * @param view  the view of the event allocator
     */
    EventAllocatorController(EventAllocatorModel model,
                             EventAllocatorView view) {
        this.model = model;
        this.view = view;

        view.addAddEventHandler(new addEventHandler());
        view.addRemoveEventHandler(new removeEventHandler());
    }

    /**
     * Action for the button that adds an event based on data in its frame.
     */
    private class addEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Event event1;
            if (view.getAddEventVenue() == null) {
                view.updateDisplay("ERROR: Please select a " +
                        "venue to allocate the event to.");
            } else if (view.getAddEventName().equals("")) {
                view.updateDisplay("ERROR: Please enter an event name.");
            } else if (view.getAddEventSize() > view.getAddEventVenue()
                    .getCapacity()) {
                view.updateDisplay("ERROR: Event size larger than Venue " +
                        "capacity");
            } else if (model.isAllocated(view.getAddEventVenue())) {
                view.clearAll();
                view.updateDisplay("ERROR: This venue already has an event " +
                        "allocated to it");
            } else {
                event1 = new Event(view.getAddEventName(), view
                        .getAddEventSize());
                if (!model.getEvents().contains(event1)) {
                    model.addEvent(event1);
                    view.updateEventComboBox();
                    model.addAllocation(event1, view.getAddEventVenue());
                    view.clearAll();
                    view.updateDisplay("Event allocation added successfully ");
                } else {
                    view.clearAll();
                    view.updateDisplay("ERROR: This event is already added.");
                }
            }
        }
    }

    /**
     * Action for button for removing an event.
     */
    private class removeEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if (model.removeEvent(view.getRemoveEvent())) {
                view.clearAll();
                view.updateEventComboBox();
                view.updateDisplay("Event removed successfully");
            } else {
                view.updateDisplay("ERROR: No event selected to remove.");
            }
        }

    }
}
