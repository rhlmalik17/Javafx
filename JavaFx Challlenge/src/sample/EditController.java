package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EditController {

    private static EditController instance = new EditController();

    @FXML
    private ComboBox contactListToEdit;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField notes;

    String optionOne = "Select item to edit";
    @FXML
    public void initialize()
    {
        contactListToEdit.getItems().add(optionOne);
        for(Contact e : ContactData.getInstance().getContacts())
        {
            contactListToEdit.getItems().add(e.getFirstName()+" "+e.getLastName());
        }
        contactListToEdit.getSelectionModel().selectFirst();
        contactListToEdit.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                String temp[] = newValue.toString().split(" ");
                if(contactListToEdit.getSelectionModel().getSelectedItem()!=optionOne) {
                    for (Contact e : ContactData.getInstance().getContacts()) {
                        if (e.getFirstName().equals(temp[0])) {
                            fillDetails(e);
                            break;
                        }
                    }
                }
                else
                {
                    clearDetails();
                }
            }
        });

    }
    public void fillDetails(Contact obj)
    {
        firstName.setText(obj.getFirstName());
        lastName.setText(obj.getLastName());
        phoneNumber.setText(obj.getPhoneNumber());
        notes.setText(obj.getNotes());
    }
    public void clearDetails()
    {
        firstName.clear();
        lastName.clear();
        phoneNumber.clear();
        notes.clear();
    }
    public static EditController getInstance()
    {
        return instance;
    }

    public void processResults() {

    }
}
