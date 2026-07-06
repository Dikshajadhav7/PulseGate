package com.pulsegate.probe_service.repository;

import com.pulsegate.probe_service.entity.Probe;
import com.pulsegate.probe_service.entity.ProbeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProbeRepository extends JpaRepository<Probe, Long> {

    boolean existsByUrl(String url);

    List<Probe> findByStatus(ProbeStatus status);

}