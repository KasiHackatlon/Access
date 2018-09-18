package ch.l2g.tool.lpds.gui.Controller.interfaces;

/**
 * Das Interface <code>FrontGuiProvider</code> dient als Abstraktion des FrontController.
 * Wird rür die Umsetzung des MVVM-Patter benötigt.
 * Stellt Mehtoden für die Bedienung des GUIs zur Verfügung.
 * 
 * @author Simon Kaltenrieder
 *
 */
public interface FrontGuiProvider {
	
	/**
	 * Aufruf für den Checkout der Dokumentation.
	 * @param name1 Pfad zur alten Dokumentation
	 */
	void setText(String name1, String name2, String summe, String child, String address, boolean hasChild, boolean hasHouse);


}
