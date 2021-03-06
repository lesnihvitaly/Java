package JavaXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// English https://javacode.lesnih.info/java-xml-reading.html
// Russian https://java.lesnih.info/java-xml-chtenie.html

public class java_read_XML {

    public static void main(String[] args) {

        //text.xml - Take from repository.
        // You must place the text.xml file in the folder so
        // that the file is available at C:\NewFolder1\text.xml,
        // or change the address to the file.

        String path = "C:\\NewFolder1\\text.xml";
        try
        {
            File FileXML = new File(path);
            DocumentBuilderFactory dbXML = DocumentBuilderFactory.newInstance();
            DocumentBuilder BuilderXML = dbXML.newDocumentBuilder();
            Document doc_xml = BuilderXML.parse(FileXML);
            doc_xml.getDocumentElement().normalize();


            NodeList ListXML = doc_xml.getElementsByTagName("product");

            for (int temp = 0; temp < ListXML.getLength(); temp++)
            {
                Node NodeXML = ListXML.item(temp);

                if (NodeXML.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element ElementXML = (Element) NodeXML;
                    System.out.println("\n");
                    System.out.println("Product: " + ElementXML.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Color: " + ElementXML.getElementsByTagName("color").item(0).getTextContent());
                    System.out.println("Price: " + ElementXML.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("Quantity: " + ElementXML.getElementsByTagName("quantity").item(0).getTextContent() );

                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}