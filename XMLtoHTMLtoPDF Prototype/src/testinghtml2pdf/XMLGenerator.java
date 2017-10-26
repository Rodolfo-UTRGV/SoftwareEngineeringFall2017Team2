/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinghtml2pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author MQ0162246
 */
public class XMLGenerator {
    private String xmlFileName;
    private DocumentBuilderFactory icFactory = null;
    private DocumentBuilder icBuilder = null;

    public XMLGenerator(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public String jobXMLGenerator(ArrayList<Nutrition> jobList) {
        //Array list not used yet...jobs hard coded
        //xml
        Document doc = null;
        try {

            FileOutputStream fos = new FileOutputStream(getXmlFileName());
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            icFactory = DocumentBuilderFactory.newInstance();
            icBuilder = icFactory.newDocumentBuilder();

            doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElement("NutritionFacts"); // doc.createElementNS();
            doc.appendChild(mainRootElement);

            // Append child elements to root element
            Nutrition nutrient1 = new Nutrition("Cheerios", "Grains", "28", "100", "2", "0", "0.14", "0.18", "20", "3");
            mainRootElement.appendChild(getNutrient(doc, nutrient1, 1));

            Nutrition nutrient2 =new Nutrition("Fiber One Cereal Original", "Grains", "30", "60", "1", "0", "0.11", "0.11", "25", "2");
            mainRootElement.appendChild(getNutrient(doc, nutrient2, 2));

            Nutrition nutrient3 = new Nutrition("Fiber One 100% Whole Wheat Bread", "Grains", "48", "15", "1.5", "0", "0.170", "0", "23", "5");
            mainRootElement.appendChild(getNutrient(doc, nutrient3, 3));

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(doc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("\nXML DOM Created Successfully..");
//            System.out.println("The xml is:");
//            System.out.println(xmlDocToString(doc, "yes"));
//
//            System.out.println("The xml is:");
//            System.out.println(xmlDocToString(doc, "no"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlFileName;
    }

    public static void mergeMultipleXMLDocs(List<String> list, String jointXmlRootNode, String outName) {
        File in;

        //String xmlFileName;
        try {
            DocumentBuilderFactory dbFactory;
            DocumentBuilder dBuilder;

            Document mergedDoc;

            FileOutputStream fos = new FileOutputStream(outName);
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();

            mergedDoc = dBuilder.newDocument();
            Element mainRootElement = mergedDoc.createElement(jointXmlRootNode); // doc.createElementNS();
            mergedDoc.appendChild(mainRootElement);

            //Get Top Level Node
            for (String inFile : list) {
                in = new File(inFile);
                Document current_doc1 = dBuilder.parse(in);
                Node n = mergedDoc.importNode(current_doc1.getFirstChild(), true);
                mainRootElement.appendChild(n);
            }

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(mergedDoc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("The Merged xml is:");
            System.out.println(xmlDocToString(mergedDoc, "yes"));

        } catch (Exception e) {
        }
    }

    public static String xmlDocToString(Document doc, String omitXmlDeclaration)
            throws Exception {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, omitXmlDeclaration);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            String xmlString = result.getWriter().toString();
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();

            throw e;
        }
    }

    public Node getNutrient(Document doc, Nutrition nutrientObject, int id) {
        Element nutrientComponent = doc.createElement("NutrientComponent");
        // Top level attributes
        nutrientComponent.setAttribute("id", Integer.toString(id));

        // Nutrient subelements
	nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "name", nutrientObject.getName()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "group", nutrientObject.getGroup()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "serving", nutrientObject.getServing()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "calories", nutrientObject.getCalories()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "total fats", nutrientObject.getTotalFats()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "cholesterol", nutrientObject.getCholesterol()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "sodium", nutrientObject.getSodium()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "potassium", nutrientObject.getPotassium()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "carbohydrates", nutrientObject.getCarbohydrates()));
        nutrientComponent.appendChild(getJobElements(doc, nutrientComponent, "proteins", nutrientObject.getProteins()));
        return nutrientComponent;
    }

    // utility method to create text node
    public Node getJobElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    /**
     * @return the xmlFileName
     */
    public String getXmlFileName() {
        return xmlFileName;
    }

    /**
     * @param xmlFileName the xmlFileName to set
     */
    public void setXmlFileName(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }
}
