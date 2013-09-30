/**
 * 
 */
package edu.masterjava.xml.tarea05;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * @author carloshernandezarques
 * 
 */
public class ShowCitasSAX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			// Crea el SAX parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			 
			// Ignora las declaracion del DTD
			XMLReader parser = saxParser.getXMLReader();
			parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			parser.setFeature("http://xml.org/sax/features/validation", false);

			// Carga el XML
			File file = new File("WebContent/agenda.xml");
			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			InputSource inputSource = new InputSource(reader);
			inputSource.setEncoding("UTF-8");

			// Realiza el parseo
			ShowCitasDefaultHandler handler = new ShowCitasDefaultHandler();
			//ShowXMLDefaultHandler handler = new ShowXMLDefaultHandler();
			saxParser.parse(inputSource, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
