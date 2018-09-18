package ch.l2g.tool.lpds.gui.messagebox;

import javafx.scene.control.Alert;

/**
 * Erzeugt eine Messagebox mit der Fehlermekdung der Kommunikationsstörung mit dem Übergebenen Parameter.
 * @author chauti 
 *
 */
public class MessageBox {
	
	public MessageBox (String message){
		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle("Information");
		dialog.setHeaderText(message);
		dialog.showAndWait();
	}
}
