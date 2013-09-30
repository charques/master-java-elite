package edu.masterjava.xml.tarea07;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ShowAmigosXPath {

	public static void main(String argv[]) {

		try {
			DocumentBuilderFactory builderfactory = DocumentBuilderFactory
					.newInstance();
			builderfactory.setNamespaceAware(true);

			DocumentBuilder builder = builderfactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(new File(
					"WebContent/agenda.xml"));

			XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
			XPath xPath = factory.newXPath();

			XPathExpression expr = xPath.compile("//contacto[@tipo='amigo']");

			Object result = expr.evaluate(xmlDocument, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;

			if (nodes.getLength() > 0) {
				System.out.println("----------------------------");
				System.out.println("- AMIGOS");
				System.out.println("----------------------------");

				Element element;
				for (int i = 0; i < nodes.getLength(); i++) {
					if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
						element = (Element) nodes.item(i);
						String tipo = xPath.evaluate("@tipo", element);
						String nombre = xPath.evaluate("nombre", element);
						String telefono = xPath.evaluate("telefono", element);
						System.out.println("\nContacto");
						System.out.println("----------------------------");
						System.out.println("Tipo : " + tipo);
						System.out.println("Nombre : " + nombre);
						System.out.println("TelŽfono : " + telefono);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
