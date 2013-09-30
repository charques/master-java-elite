package edu.masterjava.jsf.tarea02;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Conversor de numero de cuenta.
 * 
 * @author carloshernandezarques
 */
@FacesConverter("edu.masterjava.jsf.tarea02.NumCuentaConverter")
public class NumCuentaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		if (value == null || (value.trim().length() < 20)) {
			FacesMessage msg = new FacesMessage("error numCuenta",
					"El nœmero de cuenta debe tener 20 caracteres.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
		
		if(! validateDc(value)) {
			FacesMessage msg = new FacesMessage("error numCuenta",
					"El nœmero de cuenta no es correcto.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}

		String entidad = new String(value.substring(0, 4));
		String oficina = new String(value.substring(4, 8));
		String dc = new String(value.substring(8, 10));
		String numCuenta = new String(value.substring(10, 20));
		
		StringBuffer numeroCuentaAsString = new StringBuffer();
		numeroCuentaAsString.append(entidad + " ");
		numeroCuentaAsString.append(oficina + " ");
		numeroCuentaAsString.append(dc + " ");
		numeroCuentaAsString.append(numCuenta);
		
		NumCuenta numeroCuenta = new NumCuenta();
		numeroCuenta.setNumCuenta(numeroCuentaAsString.toString());

		return numeroCuenta;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		return value.toString();
	}

	/**
	 * Valida el DC
	 * @param cadena
	 * @return
	 */
	public static boolean validateDc(String cadena) {

		String entidadOficina;
		String dc;
		String numCuenta;

		int vals1[] = new int[8];
		int vals2[] = new int[10];

		int peso[] = { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };

		entidadOficina = new String(cadena.substring(0, 8));
		dc = new String(cadena.substring(8, 10));
		numCuenta = new String(cadena.substring(10, 20));

		int suma1 = 0;
		for (int i = 0; i < 8; i++)

		{
			vals1[i] = Integer.parseInt(entidadOficina.substring(i, i + 1))
					* peso[i + 2];
			suma1 = suma1 + vals1[i];
		}
		int result1 = suma1 % 11;
		result1 = 11 - result1;
		if (result1 == 10)
			result1 = 1;
		else if (result1 == 11)
			result1 = 0;

		int suma2 = 0;
		for (int i = 0; i < 10; i++) {
			vals2[i] = Integer.parseInt(numCuenta.substring(i, i + 1)) * peso[i];
			suma2 = suma2 + vals2[i];
		}
		int result2 = suma2 % 11;
		result2 = 11 - result2;
		if (result2 == 10)
			result2 = 1;
		else if (result2 == 11)
			result2 = 0;

		if (result1 == Integer.parseInt(dc.substring(0, 1))
				&& result2 == Integer.parseInt(dc.substring(1, 2)))
			return true;
		else
			return false;
	}
}
