package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public  class AddDialogController {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField notes;

    @FXML
    public void processResults()
    {
        Contact newContact = new Contact(firstName.getText(),lastName.getText(),phoneNumber.getText(),notes.getText() );
        ContactData.getInstance().addContact(newContact);
    }




}
