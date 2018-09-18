package ch.l2g.tool.lpds.gui.Controller;

import ch.l2g.tool.lpds.Main;
import ch.l2g.tool.lpds.gui.Controller.impl.TextFieldListenerImpl;
import ch.l2g.tool.lpds.gui.Controller.interfaces.FrontGuiProvider;
import ch.l2g.tool.lpds.gui.Controller.interfaces.ITextFieldListener;
import ch.l2g.tool.lpds.gui.Controller.interfaces.StrategyProvider;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrontController implements ITextFieldListener {

    private static Logger logger = LoggerFactory.getLogger(Main.class);
    private FrontGuiProvider guiProvider;
    private StrategyProvider strategyProvider;

    @FXML
    Button btnSubmit = new Button();

    @FXML
    TextField tfdChild,tfdAddress,tfdSumme,tfdName2,tfdName1 = new TextField();


    @FXML
    TitledPane titledPaneChild,titledPaneHouse = new TitledPane();

    @FXML
    CheckBox checkBoxChild,checkBoxHouse = new CheckBox();


    public void initFrontController(FrontGuiProvider frontGuiProvider) {
        this.guiProvider=frontGuiProvider;
        tfdName1.textProperty().addListener(new TextFieldListenerImpl(this));
        tfdName2.textProperty().addListener(new TextFieldListenerImpl(this));
    }

    @FXML
    public void onClickSubmit() {
        guiProvider.setText(tfdName1.getText(),tfdName2.getText(),tfdSumme.getText(),tfdChild.getText(), tfdAddress.getText(),checkBoxChild.isSelected(),checkBoxHouse.isSelected());
        tfdName1.clear();
        tfdName2.clear();
    }

    @FXML
    public void checkBoxChild(){

    }

    @FXML
    public void tabSwitchDetected (){


    }

    @Override
    public void onChangedTextField() {
        updateButtonState();
    }

    private void updateButtonState() {
        boolean isTextFieldNotEmpty = (tfdName1.getText().isEmpty()|tfdName2.getText().isEmpty());
        btnSubmit.setDisable(isTextFieldNotEmpty);
    }
}
