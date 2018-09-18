package ch.l2g.tool.lpds.strategy.interfaces;


import org.w3c.dom.Document;

/**
 * Definiert die Methode für Wertänderungen bei Textfelder.
 * 
 * @author Simon Kaltenrieder 
 *
 */
public interface IXmlStrategy {
	
	/**
	 * Wird aufgerufen, wenn der Wert im Textfeld ändert.
	 */
	void addElements(Document document);

}
