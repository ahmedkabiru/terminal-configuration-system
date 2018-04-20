package com.globalaccelerex.tcs.service;

import com.globalaccelerex.tcs.domain.Terminal;

import java.util.List;

public interface TerminalService {

    Terminal add(Terminal terminal);

    List<Terminal> getAllTerminal();

    Terminal findById(Long id);

    Terminal update(Long id , Terminal terminal);

    void delete(Long id);

    int countTerminal();

    boolean checkTerminalIdExist(String terminalId);

    boolean checkSerialNoExist(String serialNo);


}
