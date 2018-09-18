package ch.l2g.tool.lpds.gui.Controller.impl;
import ch.l2g.tool.lpds.gui.Controller.interfaces.ITextFieldListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Benachrichtigt die Objekte des  Typs {@link ITextFieldListener} bei einer Wertänderung im Textfeld.
 * Wird notifiziert, sobald sicher der Wert im Textfeld geändert hat.
 * 
 * @author Simon Kaltenrieder
 */
public class TextFieldListenerImpl implements ChangeListener<String> {
	private ITextFieldListener modelView;
	
	/**
	 * Instanzierung des Interfaces {ITextFieldListener}.
	 * @param controller Objekt des Typs ITextFieldListener.
	 */
	public TextFieldListenerImpl (ITextFieldListener controller){
		this.modelView=controller;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changed(ObservableValue<? extends String> observable,
			String oldValue, String newValue) {
		if (newValue != null) {
			modelView.onChangedTextField();
			} 
		}

}
