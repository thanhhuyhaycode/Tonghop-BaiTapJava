package model;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

public class XmlHandler {
    public void writeToFile(List<XmlElement> elements, String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("root");
            doc.appendChild(root);

            for (XmlElement e : elements) {
                Element tag = doc.createElement(e.getTagName());
                tag.setTextContent(e.getValue());
                root.appendChild(tag);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<XmlElement> readFromFile(String filePath) {
        List<XmlElement> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) return list;

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    list.add(new XmlElement(node.getNodeName(), node.getTextContent()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}