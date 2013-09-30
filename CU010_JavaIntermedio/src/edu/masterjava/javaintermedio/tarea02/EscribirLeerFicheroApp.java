/**
 * 
 */
package edu.masterjava.javaintermedio.tarea02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * Tarea 2. Emplear java.io.DataInputStream para escribir en un fichero de 
 * salida valores de los tipos b‡sicos en java, y a continuaci—n emplear 
 * java.io.DataInputStream para leer dichos valores de los tipos basicos
 * 
 * @author carloshernandezarques
 *
 */
public class EscribirLeerFicheroApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean booleanValue = true;
		int intValue = 1;
        String stringValue = "Madrid";
        float floatValue = 25.52f;
 		
		try {
            
			// Crea el stream de escritura
            FileOutputStream fos = new FileOutputStream("datos.dat");
            DataOutputStream dos = new DataOutputStream(fos);
 
            // Escribe en el fichero
            dos.writeBoolean(booleanValue);
            dos.writeInt(intValue);
            dos.writeUTF(stringValue);
            dos.writeFloat(floatValue);
            
            dos.flush();
            dos.close();
 
            // Crea el stream de lectura
            FileInputStream fis = new FileInputStream("datos.dat");
            DataInputStream dis = new DataInputStream(fis);
 
            // Lee el fichero
            boolean booleanValue1 = dis.readBoolean();
            System.out.println("booleanValue: " + booleanValue1);
            int intValue1 = dis.readInt();
            System.out.println("intValue: " + intValue1);
            String stringValue1 = dis.readUTF();
            System.out.println("stringValue: " + stringValue1);
            float floatValue1 = dis.readFloat();
            System.out.println("floatValue: " + floatValue1);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
