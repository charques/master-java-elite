/**
 * 
 */
package edu.masterjava.xml.tarea05;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author carloshernandezarques
 * 
 */
public class ShowXMLDefaultHandler extends DefaultHandler {

	public void startDocument() throws SAXException {
		System.out.println("\nPrincipio del documento...");
	}

	public void endDocument() throws SAXException {
		System.out.println("\nFin del documento...");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		System.out.println("\nProcesando etiqueta...");
		System.out.println("\tNamespace uri: " + uri);
		System.out.println("\tNombre: " + localName);
		System.out.println("\tNombre con prefijo: " + qName);

		// Recorremos los atributos
		System.out.println("\tProcesando " + attributes.getLength()
				+ " atributos...");
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.println("\t\tNombre: " + attributes.getQName(i));
			System.out.println("\t\tValor: " + attributes.getValue(i));
		}

		// TambiŽn podemos obtener los atributos por nombre
		String valorId = attributes.getValue("id");
		if (valorId != null) {
			System.out.println("\tId: " + valorId);
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		System.out.println("\nFin de etiqueta...");
		System.out.println("\tNamespace uri: "+uri);
		System.out.println("\tNombre: "+localName);
		System.out.println("\tNombre con prefijo: "+qName);
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {

		System.out.println("\nProcesando texto dentro de una etiqueta... ");
		System.out.println("\tTexto: "+String.valueOf(ch, start, length));
	}

}
