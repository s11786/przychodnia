/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validator;

import com.controller.PacjentController;
import com.entity.Pacjent;
import java.awt.Component;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author a
 */
@FacesValidator("com.validator.PeselValidator")
public class PeselValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        String s = value.toString();
        
        if(s.length() != 11)
        {
            FacesMessage msg = new FacesMessage("pesel niepoprawny", "zła długość");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
        int checkSum = s.charAt(0) - '0';
        checkSum += 3 * (s.charAt(1) - '0');
        checkSum += 7 * (s.charAt(2) - '0');
        checkSum += 9 * (s.charAt(3) - '0');
        checkSum += 1 * (s.charAt(4) - '0');
        checkSum += 3 * (s.charAt(5) - '0');
        checkSum += 7 * (s.charAt(6) - '0');
        checkSum += 9 * (s.charAt(7) - '0');
        checkSum += 1 * (s.charAt(8) - '0');
        checkSum += 3 * (s.charAt(9) - '0');
        checkSum = 10 - (checkSum % 10);
        
        if(checkSum != s.charAt(10) - '0')
        {
            FacesMessage msg = new FacesMessage("pesel niepoprawny", "zła suma kontrolna");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
