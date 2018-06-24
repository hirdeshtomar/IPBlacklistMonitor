package com.finreach.IPBlacklistMonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finreach.IPBlacklistMonitor.model.IPAddress;


// JPA Repository interface for IP Address persistence
public interface IPAddressRepository extends JpaRepository<IPAddress, Long> {

}
