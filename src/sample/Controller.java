package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import sample.datamodel.*;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;


public class Controller {
    @FXML
    private BorderPane mainPanel;
    @FXML
    private ChoiceBox<String> concreteClass;
    @FXML
    private ChoiceBox<String> diameter;
    @FXML
    private CheckBox obereLage;
    @FXML
    private Button showValues;
    @FXML
    private TextField anchorageTextField;
    @FXML
    private TextField overlapTextField;
    @FXML
    private ImageView imageView;
    @FXML
    private Image fcpLogo;


    public void initialize() {
        concreteClass.setItems(ResourceData.getInstance().getBetonList());
        concreteClass.getSelectionModel().selectFirst();

        diameter.setItems(ResourceData.getInstance().getDiameterList());
        diameter.getSelectionModel().selectFirst();

        fcpLogo = new Image("FCP.jpg");
        imageView.setImage(fcpLogo);


    }


    @FXML
    public void exitApp() {
        mainPanel.getScene().getWindow().hide();
    }

    @FXML
    public void showInfoDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType openFolder = new ButtonType("Tabelle");
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.getButtonTypes().add(openFolder);
        alert.setContentText(
                "Hergestellt von Sorin Lazar für FCP.VCE, August 2019\n" +
                        "Vorschläge und Anfragen an soso.laz@gmail.com\n"+ "\n"+
                        "Übergreifungs- u. Verankerungslängen nach EN 1992\n");
        Optional<ButtonType> result = alert.showAndWait();


        if (result.isPresent()&&result.get() == openFolder) {
            String inputPdf = "tabelle.pdf";
            Path tempOutput;

            try{
                tempOutput = Files.createTempFile("tabelleTemp", ".pdf");
                tempOutput.toFile().deleteOnExit();
                try (InputStream is = Controller.class.getClassLoader().getResourceAsStream(inputPdf)) {
                    if (is != null) {
                        Files.copy(is, tempOutput, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
                Desktop.getDesktop().open(tempOutput.toFile());
            }   catch (IOException e){
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText(null);
                error.setContentText("Could not create file");
                error.showAndWait();
            }



//            try{
//                Desktop.getDesktop().open(tabellePath.toFile());
//            }catch (Exception ioe){
//                Alert error = new Alert(Alert.AlertType.ERROR);
//                error.setTitle("Error");
//                error.setHeaderText(null);
//                error.setContentText("File not found");
//                error.showAndWait();
//            }
        }
    }

    @FXML
    public void handleShowValues(ActionEvent e) {
        String selectedBeton = concreteClass.getSelectionModel().getSelectedItem();
        String selectedDiameter = diameter.getSelectionModel().getSelectedItem();
        int row = ResourceData.getInstance().getDiameterList().indexOf(selectedDiameter);
        int column = ResourceData.getInstance().getBetonList().indexOf(selectedBeton);
        if(obereLage.isSelected()){
            overlapTextField.setText(ResourceData.getInstance().getOverlapBadValue(row,column));
            anchorageTextField.setText(ResourceData.getInstance().getAnchorageBadValue(row,column));
        }else {
            overlapTextField.setText(ResourceData.getInstance().getOverlapGoodValue(row,column));
            anchorageTextField.setText(ResourceData.getInstance().getAnchorageGoodValue(row,column));
        }
    }

}
