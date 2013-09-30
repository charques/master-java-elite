package edu.masterjava.jsf.tarea04;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
         
        String email = (String) value;
         
        if(!email.contains("@")) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary("Email no es v‡lido.");
            //message.setDetail("Email no es v‡lido.");
            context.addMessage("Email", message);
            throw new ValidatorException(message);
        }
    }
	
}