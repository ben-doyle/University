package planner.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import planner.Event;
import planner.Venue;

import java.util.ArrayList;
import java.util.Collections;


/**
 * The view for the event allocator program.
 *
 * Invariant:
 *          this.model != null &&
 *          root != null &&
 *          rightVBox != null &&
 *          titleVbox != null &&
 *          nameVBox != null &&
 *          rightVBox != null &&
 *          display set to correct text representing state.
 */
public class EventAllocatorView {

    // <----------FONTS---------->
    private static final Font font = Font.font("SanSerif",
            FontWeight.BOLD, 12);
    private static final Font mainFont = Font.font("SanSerif",
            FontWeight.BOLD, 25);
    private static final Font titleFont = Font.font("SanSerif",
            FontWeight.BOLD, 16);
    private static final Font displayFont = Font.font("SanSerif", 12);
    // Correct line separator for executing machine (used in toString method)
    private final static String NEW_LINE = System.getProperty(
            "line.separator");
    // <----------MAIN---------->
    private Group root; // The main root node for the application.
    private EventAllocatorModel model; // the model of the event allocator
    // <-------SWING TEXT-------->
    private TextArea display; //For displaying text & errors
    private TextField eventTextField; //Entry textField for add event name
    private TextField eventSizeTextField; //Entry textField for add event size
    // <-------SWING BOXES------->
    private HBox mainHBox = new HBox(); //HBox containing display
    private VBox rightVBox = new VBox(10); //VBox containing form
    private VBox addEventVBox = new VBox(5); //VBox with add event form
    private VBox removeEventVBox = new VBox(5);//VBox with remove event form
    private VBox allocationVbox = new VBox(10); //VBox for Allocation Tab
    //<------BUTTONS/COMBO------>
    private ComboBox<Event> eventComboBox; //ComboBox for list of events
    private ComboBox<Venue> venueComboBox; //ComboBox for list of venues
    private Button removeButton; //Remove event button
    private Button addEventBtn;//Add event button
    //<---------STYLING--------->
    private String blackBorder = "-fx-border-color: black;\n"; //Border styling

    /**
     * Initialises the view for the event allocator program.
     *
     * @param model the model of the event allocator
     */
    EventAllocatorView(EventAllocatorModel model) {
        this.model = model;
        root = new Group();
        rightVBox.setPadding(new Insets(10, 0, 10, 0));
        VBox titleVbox = createTitleVBox();
        VBox nameVBox = createNameVBox();
        rightVBox.getChildren().addAll(titleVbox, nameVBox, createEventVBox(),
                removeEventVBox());
        mainHBox.getChildren().addAll(createAllocationVBox());
        mainHBox.getChildren().addAll(rightVBox);
        root.getChildren().add(mainHBox);
        display.setText(model.getCurrentMsg());
    }

    /**
     * Create the name VBox and style it.
     *
     * @return a VBOX with name and correct layout.
     */
    private VBox createNameVBox() {
        VBox nameVbox = new VBox();
        Label name = new Label("43994375 Benjamin Doyle");
        name.setFont(font);
        nameVbox.setPadding(new Insets(10, 0, 10, 0));
        nameVbox.getChildren().add(name);
        return nameVbox;
    }

    /**
     * Create the title VBox and style it.
     *
     * @return a VBOX with title and correct layout.
     */
    private VBox createTitleVBox() {
        VBox titleVbox = new VBox();
        Label title = new Label("CSSE7023 Allocator");
        title.setFont(mainFont);
        titleVbox.getChildren().add(title);
        return titleVbox;
    }

    /**
     * Returns the scene for the event allocator application.
     *
     * @return returns the scene for the application
     */
    public Scene getScene() {
        return new Scene(root, 820, 500, Color.LIGHTGRAY);
    }

    /**
     * Creates the display textfield for the application.
     *
     * @return a VBox correctly formatted, containing the display.
     */
    private VBox createAllocationVBox() {
        addDisplay();
        allocationVbox.getChildren().add(display);
        allocationVbox.setPrefSize(500, 480);
        allocationVbox.setPadding(new Insets(10, 20, 10, 20));
        return allocationVbox;
    }

    /**
     * Create the section to remove an event.
     *
     * @return a VBox correctly formatted, with enough functionality to
     * remove an event.
     */
    private VBox removeEventVBox() {
        removeEventVBox.setPadding(new Insets(10, 20, 10, 20));
        Label title = new Label("Remove event:");
        title.setFont(titleFont);
        Label eventName = new Label("Event Name: ");
        eventComboBox = new ComboBox<>();
        eventComboBox.setPrefSize(260, 15);
        removeEventVBox.setStyle(blackBorder);
        removeButton = new Button("Remove Event");
        if (model.getError()) {
            removeButton.setDisable(true);
            eventComboBox.setDisable(true);
        }
        for (Event e : model.getEvents()) {
            eventComboBox.getItems().add(e);
        }
        removeButton.setPrefSize(260, 15);
        removeEventVBox.getChildren().addAll(title, eventName, eventComboBox,
                removeButton);
        return removeEventVBox;
    }

    /**
     * Creates the Add Event VBox
     *
     * @return a VBox correctly formatted, with enough functionality to add
     * an event.
     */
    private VBox createEventVBox() {
        Label title = new Label("Add event:");
        title.setFont(titleFont);
        addEventVBox.setPrefSize(300, 200);
        addEventVBox.setPadding(new Insets(10, 20, 10, 20));
        Label eventName = new Label("Event Name: ");
        eventTextField = new TextField();
        Label eventSize = new Label("Event Size: ");
        eventSizeTextField = new TextField();
        Label allocateTo = new Label("Allocate to Venue: ");
        venueComboBox = new ComboBox<>(); //Create new Venue ComboBox
        addVenueItems();
        venueComboBox.setPrefSize(260, 15);
        addEventBtn = new Button("Add Event");
        if (model.getError()) {
            eventTextField.setDisable(true);
            eventSizeTextField.setDisable(true);
            addEventBtn.setDisable(true);
            venueComboBox.setDisable(true);
        }
        addEventBtn.setPrefSize(260, 15);
        addEventVBox.setStyle(blackBorder);
        addEventVBox.getChildren().addAll(title,
                eventName,
                eventTextField,
                eventSize,
                eventSizeTextField,
                allocateTo,
                venueComboBox,
                addEventBtn);
        return addEventVBox;
    }

    /**
     * Adds the venues in model.getVenues() to the venueComboBox
     */
    private void addVenueItems() {
        for (Venue v : model.getVenues()) {
            venueComboBox.getItems().add(v);
        }
    }

    /**
     * Add the correct handler to the add event button.
     *
     * @param handler the handler to be added
     */
    void addAddEventHandler(EventHandler<ActionEvent> handler) {
        addEventBtn.setOnAction(handler);
    }

    /**
     * Adds the display, with correct formatting.
     */
    private void addDisplay() {
        display = new TextArea();
        display.setEditable(false);
        display.setFocusTraversable(false);
        display.setWrapText(true);
        display.setPrefSize(allocationVbox.getWidth(), 480);
        display.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        display.setFont(displayFont);
    }

    /**
     * Gets the text of the event text field.
     *
     * @return the text in the event text field.
     */
    String getAddEventName() {
        return eventTextField.getText();
    }

    /**
     * Gets the event size from the textField.
     *
     * @return the event size from the textField
     */
    int getAddEventSize() {
        Integer result = -1;
        try {
            result = Integer.parseInt(eventSizeTextField.getText());
        } catch (NumberFormatException nfe) {
            clearAll();
            updateDisplay("ERROR: Event size not correct, "
                    + nfe.getMessage());
        } catch (NullPointerException npe) {
            updateDisplay("ERROR: Event size can not be empty, "
                    + npe.getMessage());
        }
        return result;
    }

    /**
     * Update the display to reflect current state.
     *
     * @param updateDisplayString The String to be added to the display.
     * @require updateDisplayString != null
     */
    void updateDisplay(String updateDisplayString) {
        display.setText(updateDisplayString + NEW_LINE);
        display.appendText(NEW_LINE + "Current Allocation: " + NEW_LINE);
        ArrayList<String> result = getOrderedAllocation();
        for (String s : result) {
            display.appendText(s);
        }
        display.appendText(NEW_LINE + "Current Traffic: " + NEW_LINE);
        display.appendText(model.trafficGenerated().toString());

        display.appendText(NEW_LINE + "The traffic generated by these " +
                NEW_LINE +
                "events is: ");
        if (model.isTrafficGeneratedSafe()) {
            display.appendText("SAFE.");
        } else {
            display.appendText("UNSAFE.");
        }
    }

    /**
     * get the allocation, and sort it lexicographically.
     *
     * @return an ordered list containing the current allocation.
     */
    private ArrayList<String> getOrderedAllocation() {
        ArrayList<String> result = new ArrayList<>();
        for (Event e : model.getAllocation().keySet()) {
            result.add(e.getName() + "(" + e.getSize() + ")" +
                    " is allocated to " + model
                    .getAllocation().get(e).getName() + NEW_LINE);
        }
        Collections.sort(result);
        return result;
    }

    /**
     * update the event comboBox with current information.
     */
    void updateEventComboBox() {
        int index = removeEventVBox.getChildren().indexOf(eventComboBox);
        removeEventVBox.getChildren().remove(eventComboBox);

        eventComboBox = new ComboBox<>();
        for (Event e : model.getEvents()) {
            eventComboBox.getItems().add(e);
        }
        eventComboBox.setPrefSize(260, 15);
        removeEventVBox.getChildren().add(index, eventComboBox);
    }

    /**
     * Gets the venue to be added to the allocation.
     *
     * @return the selected venue
     */
    Venue getAddEventVenue() {
        return venueComboBox.getValue();
    }

    /**
     * Gets the event to be removed.
     *
     * @return the selected event
     */
    Event getRemoveEvent() {
        return eventComboBox.getValue();
    }

    /**
     * Clears all selections and text on editable fields
     */
    void clearAll() {
        eventTextField.setText("");
        eventSizeTextField.setText("");
        venueComboBox.getSelectionModel().clearSelection();
        eventComboBox.getSelectionModel().clearSelection();
    }

    /**
     * Add handler to the remove event action.
     *
     * @param handler the action to be added to the button
     */
    void addRemoveEventHandler(EventHandler<ActionEvent> handler) {
        removeButton.setOnAction(handler);
    }
}
