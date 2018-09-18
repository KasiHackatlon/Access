package ch.l2g.tool.lpds;

import ch.l2g.tool.lpds.businesslogic.BusinessLogic;
import ch.l2g.tool.lpds.gui.Controller.FrontController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;


public class Main extends Application {

    private static Logger logger = LoggerFactory.getLogger(Main.class);
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            logger.info("Application started");
            org.apache.log4j.BasicConfigurator.configure();
            this.primaryStage = primaryStage;
            initGui();
        } catch (IOException e) {
            logger.error("Can not load FXML 'FrontWindow", e);
        }
    }

    public void initGui() throws IOException {
        BusinessLogic buisBussinessLogic = new BusinessLogic();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ch/l2g/tool/lpds/gui/Front.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        FrontController frontController = loader.getController();
        frontController.initFrontController(buisBussinessLogic);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LPDS");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}