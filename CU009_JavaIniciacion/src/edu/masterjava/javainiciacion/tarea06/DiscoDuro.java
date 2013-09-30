package edu.masterjava.javainiciacion.tarea06;

/**
 * 
 * Clase que representa un disco duro.
 * 
 * @author carloshernandezarques
 *
 */
public class DiscoDuro {

	/**
	 * Nœmero de cilindros.
	 */
	private int cilindros;
	
	/**
	 * Nœmero de pistas por cilindro.
	 */
	private int pistas;
	
	/**
	 * Nœmero de sectores por pista.
	 */
	private int sectores;
	
	/**
	 * Nœmero de bytes por sector.
	 */
	private int bytes;
	
	/**
	 * 	Constructor. 
	 */
	public DiscoDuro(int pCilindros, int pPistas, int pSectores, int pBytes) {
		this.cilindros = pCilindros;
		this.pistas = pPistas;
		this.sectores = pSectores;
		this.bytes = pBytes;
	}
	
	/**
	 * Capacidad del disco en Bytes.
	 * 
	 * @return
	 */
	public double capacidadB() {
		return cilindros * pistas * sectores * bytes;
	}
	
	/**
	 * Capacidad del disco en KB.
	 * 
	 * @return
	 */
	public double capacidadKB() {
		return capacidadB() / 1024;
	}
	
	/**
	 * Capacidad del disco en MB.
	 * 
	 * @return
	 */
	public double capacidadMB() {
		return capacidadKB() / 1024;
	}
	
	/**
	 * Capacidad del disco en GB.
	 * 
	 * @return
	 */
	public double capacidadGB() {
		return capacidadMB() / 1024;
	}

	/**
	 * @return the cilindros
	 */
	public int getCilindros() {
		return cilindros;
	}

	/**
	 * @param cilindros the cilindros to set
	 */
	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}

	/**
	 * @return the pistas
	 */
	public int getPistas() {
		return pistas;
	}

	/**
	 * @param pistas the pistas to set
	 */
	public void setPistas(int pistas) {
		this.pistas = pistas;
	}

	/**
	 * @return the sectores
	 */
	public int getSectores() {
		return sectores;
	}

	/**
	 * @param sectores the sectores to set
	 */
	public void setSectores(int sectores) {
		this.sectores = sectores;
	}

	/**
	 * @return the bytes
	 */
	public int getBytes() {
		return bytes;
	}

	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	
	
}
