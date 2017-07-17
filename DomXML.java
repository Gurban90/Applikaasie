/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnector;

import org.w3c.dom.*;

import java.io.FileInputStream;
import java.io.IOException;


import javax.xml.parsers.*;
import org.xml.sax.SAXException;
/**
 *
 * @author Gerben
 */
public class DomXML {
    DocumentBuilder builder = null;
    Document document = null;
    Element rootElement = null;

    public DomXML() {
        DocumentBuilderFactory builderFactory
                = DocumentBuilderFactory.newInstance();
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        }
        try {
            document = builder.parse(new FileInputStream("C:/java/Data.xml"));
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        rootElement = document.getDocumentElement();
    }

    public String getUrl() {
        NodeList urlNodes = rootElement.getElementsByTagName("url");
        return urlNodes.item(0).getTextContent();
    }

    public String getDriverName() {
        NodeList driverNodes = rootElement.getElementsByTagName("driver");
        return driverNodes.item(0).getTextContent();
    }

    public String getUsername() {
        NodeList userNodes = rootElement.getElementsByTagName("user");
        return userNodes.item(0).getTextContent();
    }

    public String getPassword() {
        NodeList passNodes = rootElement.getElementsByTagName("password");
        return passNodes.item(0).getTextContent();
    }
}
