package com.globalaccelerex.tcs.service.impl;

import com.globalaccelerex.tcs.domain.Terminal;
import com.globalaccelerex.tcs.repository.TerminalRepository;
import com.globalaccelerex.tcs.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalServiceImpl  implements TerminalService{


    private TerminalRepository terminalRepository;

    @Autowired
    public TerminalServiceImpl(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @Override
    public Terminal add(Terminal terminal) {
          return terminalRepository.save(terminal);
    }

    @Override
    public List<Terminal> getAllTerminal() {
        return terminalRepository.findAll();
    }

    @Override
    public Terminal findById(Long id) {
        return terminalRepository.getOne(id);
    }

    @Override
    public Terminal update(Long id, Terminal terminal) {
        Terminal terminal1 = findById(id);
        if(terminal1 != null){
             terminal1.setTerminalId(terminal.getTerminalId());
             terminal1.setSerialNo(terminal.getSerialNo());
             terminal1.setMerchantNo(terminal.getMerchantNo());
             terminal1.setMerchantName(terminal.getMerchantName());
             terminal1.setMerchantType(terminal.getMerchantType());
             terminal1.setMerchantPhone(terminal.getMerchantPhone());
             terminal1.setTerminalOwner(terminal.getTerminalOwner());
             terminal1.setMerchantAddress(terminal.getMerchantAddress());
        }

        return terminalRepository.save(terminal1);
    }

    @Override
    public void delete(Long id) {
        terminalRepository.deleteById(id);
    }

    @Override
    public int countTerminal() {
        List<Terminal> list =getAllTerminal();
        return  list.size();
    }

    @Override
    public boolean checkTerminalIdExist(String terminalId) {
        return terminalRepository.findByTerminalId(terminalId) != null;
    }

    @Override
    public boolean checkSerialNoExist(String serialNo) {
        return terminalRepository.findBySerialNo(serialNo) != null;
    }


}
