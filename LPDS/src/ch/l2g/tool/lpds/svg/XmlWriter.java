package ch.l2g.tool.lpds.svg;

import ch.l2g.tool.lpds.gui.messagebox.MessageBox;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlWriter {

    public XmlWriter (){

    }

    public void writeFile(Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            File file = new File("E:\\LPDS\\New_LPDS.svg");
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            MessageBox messageBox = new MessageBox("Datei ''"+ file.getAbsolutePath()+"'' erfolgreich erstellt!");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
