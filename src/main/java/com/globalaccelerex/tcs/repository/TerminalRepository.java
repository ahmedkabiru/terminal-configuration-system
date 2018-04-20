package com.globalaccelerex.tcs.repository;

import com.globalaccelerex.tcs.domain.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal,Long> {

    Terminal findByTerminalId(String terminalId);

    Terminal findBySerialNo(String SerialNo);
}
