package com.globalaccelerex.tcs.validation.impl;

import com.globalaccelerex.tcs.service.TerminalService;
import com.globalaccelerex.tcs.validation.checkUniqueSerialNo;
import com.globalaccelerex.tcs.validation.checkUniqueTerminalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class SerialNoValidator implements ConstraintValidator<checkUniqueSerialNo,String> {

    @Autowired
    private TerminalService terminalService;
    @Override
    public void initialize(checkUniqueSerialNo constraintAnnotation) {

    }
    @Override
    public boolean isValid(String serialNo, ConstraintValidatorContext constraintValidatorContext) {
        return !terminalService.checkSerialNoExist(serialNo);
    }
}

