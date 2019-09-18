package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class deleteDialogController {

    private static deleteDialogController instance=new deleteDialogController();
    public static String optionOne = "Select item to delete:- ";
    private static String selectedItem=optionOne;

    public static deleteDialogController getInstance()
    {
        return instance;
    }

    public static String getSelectedItem()
    {
        return selectedItem;
    }

    public static String selected;
    @FXML
    private ComboBox contactListToDelete;

    @FXML
    public void initialize()
    {

        contactListToDelete.getItems().add(optionOne);
        for(Contact e : ContactData.getInstance().getContacts())
        {
            contactListToDelete.getItems().add(e.getFirstName()+" "+e.getLastName());
        }
        contactListToDelete.getSelectionModel().selectFirst();

        contactListToDelete.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                String temp = contactListToDelete.getSelectionModel().getSelectedItem().toString();
                String arr[] = temp.split(" ");
                selectedItem=arr[0];
            }
        });
    }





}
