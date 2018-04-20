package com.globalaccelerex.tcs.validation.impl;

import com.globalaccelerex.tcs.service.TerminalService;
import com.globalaccelerex.tcs.validation.checkUniqueTerminalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class TerminalIDValidator implements ConstraintValidator<checkUniqueTerminalId,String>
{

    @Autowired
    private  TerminalService terminalService;

    @Override
    public void initialize(checkUniqueTerminalId notExistingTerminal) {

    }

    @Override
    public boolean isValid(String terminalId, ConstraintValidatorContext constraintValidatorContext) {
        return !terminalService.checkTerminalIdExist(terminalId);
    }
}
