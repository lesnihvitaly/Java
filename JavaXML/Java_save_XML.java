package JavaXML;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;

// English https://javacode.lesnih.info/java-xml-write.html
// Russian https://java.lesnih.info/java-xml-record.html

public class Java_save_XML {

    public static void main(String argv[]) {

        try {

            DocumentBuilderFactory docXML = DocumentBuilderFactory.newInstance();
            DocumentBuilder BuilderXML = docXML.newDocumentBuilder();

            Document XML = BuilderXML.newDocument();
            Element rootXML = XML.createElement("company");
            XML.appendChild(rootXML);

            Element product = XML.createElement("product");
            rootXML.appendChild(product);

            Attr attr = XML.createAttribute("id");
            attr.setValue("1");
            product.setAttributeNode(attr);


            Element title = XML.createElement("title");
            title.appendChild(XML.createTextNode("Mobile iphone"));
            product.appendChild(title);

            Element color = XML.createElement("color");
            color.appendChild(XML.createTextNode("black"));
            product.appendChild(color);

            Element price = XML.createElement("price");
            price.appendChild(XML.createTextNode("1000"));
            product.appendChild(price);

            Element quantity = XML.createElement("quantity");
            quantity.appendChild(XML.createTextNode("24"));
            product.appendChild(quantity);





            Element product2 = XML.createElement("product");
            rootXML.appendChild(product2);

            Attr attr2 = XML.createAttribute("id");
            attr2.setValue("2");
            product2.setAttributeNode(attr2);

            Element title2 = XML.createElement("title");
            title2.appendChild(XML.createTextNode("Mobile Samsung"));
            product2.appendChild(title2);

            Element color2 = XML.createElement("color");
            color2.appendChild(XML.createTextNode("white"));
            product2.appendChild(color2);

            Element price2 = XML.createElement("price");
            price2.appendChild(XML.createTextNode("995"));
            product2.appendChild(price2);

            Element quantity2 = XML.createElement("quantity");
            quantity2.appendChild(XML.createTextNode("52"));
            product2.appendChild(quantity2);

            TransformerFactory transformerFactoryXML = TransformerFactory.newInstance();
            Transformer transformerXML = transformerFactoryXML.newTransformer();
            DOMSource sourceXML = new DOMSource(XML);
            StreamResult resultXML = new StreamResult(new File("C:\\NewFolder1\\text.xml"));

            transformerXML.transform(sourceXML, resultXML);

            System.out.println("Ok - file saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}