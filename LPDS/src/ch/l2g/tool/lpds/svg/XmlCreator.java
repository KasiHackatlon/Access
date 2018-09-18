package ch.l2g.tool.lpds.svg;

import ch.l2g.tool.lpds.strategy.interfaces.IXmlStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlCreator implements IXmlStrategy {
    String name1 = " ";
    String name2 = " ";
    String summe = " ";
    String child = " ";
    String address = " ";
    Boolean hasChild = false;
    Boolean hasHouse = false;


    public XmlCreator(String name1, String name2,String summe,String child, String address,Boolean hasChild,Boolean hasHouse) {
        try {
            this.name1=name1;
            this.name2=name2;
            this.summe=summe;
            this.child=child;
            this.address=address;
            this.hasChild=hasChild;
            this.hasHouse=hasHouse;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();
            addElements(document);        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    /* To-Do Methode variable Elemente extrahieren*/
    @Override
    public void addElements(Document document){
        XmlWriter xmlWriter = new XmlWriter();
        Document divorceDocument = document;
        Element rootElement = divorceDocument.createElement("svg");
        divorceDocument.appendChild(rootElement);
        rootElement.setAttribute("xmlns:xlink","http://www.w3.org/1999/xlink");
        rootElement.setAttribute("xmlns","http://www.w3.org/2000/svg");
        rootElement.appendChild(createPictureElement(divorceDocument,"308","308","Mann.svg","100","50"));
        rootElement.appendChild(createPictureElement(divorceDocument,"150","150","Blitz.svg","400","50"));
        rootElement.appendChild(createPictureElement(divorceDocument,"208","290","Frau.svg","600","50"));
        rootElement.appendChild(createPictureElement(divorceDocument,"150","150","Geld.svg","410","450"));
        rootElement.appendChild(createPictureElement(divorceDocument,"150","150","Waage.svg","410","700"));
        rootElement.appendChild(createTextElement(divorceDocument,name1,"220","400"));
        rootElement.appendChild(createTextElement(divorceDocument,name2,"600","400"));
        rootElement.appendChild(createTextElement(divorceDocument,summe+"CHF","450","615"));
        if (hasChild) {
            rootElement.appendChild(createPictureElement(divorceDocument, "150", "150", "Baby.svg", "280", "450"));
            rootElement.appendChild(createTextElement(divorceDocument,child,"330","615"));
        }
        if (hasHouse) {
            rootElement.appendChild(createPictureElement(divorceDocument, "150", "150", "Haus.svg", "550", "450"));
            rootElement.appendChild(createTextElement(divorceDocument,address,"570","615"));
        }
        xmlWriter.writeFile(document);
    }

    private Element createPictureElement(Document divorceDocument, String width, String hight, String picture, String x, String y){
        Element pictureElement = divorceDocument.createElement("image");
        pictureElement.setAttribute("width",width);
        pictureElement.setAttribute("height",hight);
        pictureElement.setAttribute("xlink:href",picture);
        pictureElement.setAttribute("x",x);
        pictureElement.setAttribute("y",y);
        return pictureElement;
    }


    private Element createTextElement(Document divorceDocument, String text, String x, String y){
        Element textElement = divorceDocument.createElement("text");
        textElement.setTextContent(text);
        textElement.setAttribute("xml:space","preserve");
        textElement.setAttribute("style","stroke:none");
        textElement.setAttribute("x",x);
        textElement.setAttribute("y",y);
        return textElement;
    }
}
