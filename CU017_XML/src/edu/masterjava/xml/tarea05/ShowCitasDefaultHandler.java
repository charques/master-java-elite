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
public class ShowCitasDefaultHandler extends DefaultHandler {

	StringBuffer citaBuffer = null;
	boolean startCita = false;
    
    public void startDocument() throws SAXException {
        //System.out.println("start document   : ");
    }

    public void endDocument() throws SAXException {
        //System.out.println("end document     : ");
    }

    public void startElement(String uri, String localName,
        String qName, Attributes attributes)
    throws SAXException {
    	
    	if (qName.equalsIgnoreCase("CITA")) {
    		citaBuffer = new StringBuffer();
    		citaBuffer.append(qName);
    		citaBuffer.append(":");
    		startCita = true;
        }        
    }

    public void endElement(String uri, String localName, String qName)
    throws SAXException {
        
    	if (qName.equalsIgnoreCase("CITA")) {
    		System.out.println(citaBuffer.toString());
    		startCita = false;
    	}
    }

    public void characters(char ch[], int start, int length)
    throws SAXException {
    	
    	if(startCita) {
    		citaBuffer.append((new String(ch, start, length)).trim());
    		citaBuffer.append(" ");
    	}
    }
	
}
