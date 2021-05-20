package gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Passwords;
import model.Requirement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The controller class of the password application.
 *
 * @author mikolajdeja
 * @version 2021.05.17
 */
public class Controller {
    @FXML
    private TextField checkTextField;
    @FXML
    private TextField generateTextField;
    @FXML
    private Label infoLabel;

    private Set<Requirement> requirements;
    private Map<String, Requirement> checkBoxes;

    /**
     * Initialise all the elements.
     */
    @FXML
    private void initialize() {
        requirements = new HashSet<>();
        initializeMap();
        checkTextField.setOnKeyTyped(e -> check());
    }

    /**
     * Generate the password and display it.
     */
    @FXML
    private void generate() {
        String pass = Passwords.generate(16, requirements);
        generateTextField.setText(pass);
    }

    /**
     * Check whether password is correct.
     */
    private void check() {
        String pass = checkTextField.getText();
        if (pass != null && pass.length() != 0) {
            if (Passwords.check(pass, requirements))
                infoLabel.setText("Password fits the requirements!");
            else
                infoLabel.setText("Password doesn't fit the requirements!");
        }
        else
            infoLabel.setText("");
    }

    /**
     * Update requirements if a checkbox is clicked.
     *
     * @param event The event of clicking a checkbox.
     */
    @FXML
    private void checkedBox(Event event) {
        String name = ((CheckBox) event.getSource()).getText();
        if (requirements.contains(checkBoxes.get(name))) {
            requirements.remove(checkBoxes.get(name));
        }
        else {
            requirements.add(checkBoxes.get(name));
        }
        check();
    }

    /**
     * Initialise the map of names of checkboxes to requirements.
     */
    private void initializeMap() {
        checkBoxes = new HashMap<>();
        checkBoxes.put("Small letter", Requirement.SMALL_LETTER);
        checkBoxes.put("Capital letter", Requirement.CAPITAL_LETTER);
        checkBoxes.put("Number", Requirement.NUMBER);
        checkBoxes.put("Special character", Requirement.SPECIAL_CHARACTER);
    }
}
