package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.util.Optional;

public class Controller {
    @FXML
    private BorderPane HomePane;

    @FXML
    private GridPane addDialog;

    @FXML
    private TableView contactList;

    @FXML
    private TableColumn firstName;

    @FXML
    private TableColumn lastName;

    @FXML
    private TableColumn phoneNumber;

    @FXML
    private TableColumn notes;

    @FXML
    public void initialize()
    {
        ObservableList<Contact> list = ContactData.getInstance().getContacts();
        firstName.setCellValueFactory(new PropertyValueFactory<Contact,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Contact,String>("lastName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Contact,String>("phoneNumber"));
        notes.setCellValueFactory(new PropertyValueFactory<Contact,String>("notes"));
        contactList.setItems(list);
//TODO Add context Menu to each row in table View
//        ContextMenu menu = new ContextMenu();
//        MenuItem open = new MenuItem("Open");
//        menu.getItems().add(open);
//        contactList.setContextMenu(menu);
//        contactList.setRowFactory(new Callback<TableView, TableRow>() {
//            @Override
//            public TableRow call(TableView tableView) {
//
//                return null;
//            }
//        });
  }

    @FXML
    public void showAddDialog()
    {
        Dialog<ButtonType> addDialog = new Dialog<ButtonType>();
        addDialog.initOwner(HomePane.getScene().getWindow());
        addDialog.setTitle("Add Contact");
        FXMLLoader loader=new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("addDialog.fxml"));
            addDialog.getDialogPane().setContent(loader.load());
            addDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
            Optional<ButtonType> result = addDialog.showAndWait();
            if(result.isPresent() && result.get()==ButtonType.OK)
            {
                AddDialogController controller = loader.getController();
                controller.processResults();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    public void deleteHandler()
    {
        Dialog<ButtonType> deleteDialog = new Dialog<ButtonType>();
        deleteDialog.initOwner(HomePane.getScene().getWindow());
        deleteDialog.setTitle("Delete Contact");
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("deleteDialog.fxml"));
            deleteDialog.getDialogPane().setContent(loader.load());
            deleteDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
            Optional<ButtonType> result = deleteDialog.showAndWait();
            if(result.isPresent() && result.get()==ButtonType.OK)
            {
              if(!deleteDialogController.optionOne.equals(deleteDialogController.getSelectedItem()))
                {
                    for(Contact e : ContactData.getInstance().getContacts())
                    {
                        if(e.getFirstName().equals(deleteDialogController.getSelectedItem()))
                        {
                            ContactData.getInstance().getContacts().remove(e);
                            break;
                        }
                    }
                }
            }else
            {
                System.out.println("Cancel was pressed");
            }

        }catch (Exception e)
        {
            System.out.println("Delete Dialog was not found!");
        }
    }

    @FXML
    public void showEditHandler()
    {
        Dialog<ButtonType> editDialog = new Dialog<ButtonType>();
        editDialog.initOwner(HomePane.getScene().getWindow());
        editDialog.setTitle("Edit Contact");
        FXMLLoader load = new FXMLLoader();
        try
        {
            load.setLocation(getClass().getResource("editDialog.fxml"));
            editDialog.getDialogPane().setContent(load.load());
            editDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
            Optional<ButtonType> result = editDialog.showAndWait();
            if(result.isPresent() && result.get()==ButtonType.OK)
            {
                EditController.getInstance().processResults();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
