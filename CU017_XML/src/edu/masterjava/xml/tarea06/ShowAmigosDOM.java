package edu.masterjava.xml.tarea06;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ShowAmigosDOM {

	public static void main(String argv[]) {

		try {
			File file = new File("WebContent/agenda.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("contacto");

			System.out.println("----------------------------");
			System.out.println("- AMIGOS");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String tipo = eElement.getAttribute("tipo");

					if (tipo.equalsIgnoreCase("AMIGO")) {
						System.out.println("\nContacto");
						System.out.println("----------------------------");

						System.out.println("Tipo : "
								+ eElement.getAttribute("tipo"));
						System.out.println("Nombre : "
								+ eElement.getElementsByTagName("nombre")
										.item(0).getTextContent());
						System.out.println("TelŽfono : "
								+ eElement.getElementsByTagName("telefono")
										.item(0).getTextContent());
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
