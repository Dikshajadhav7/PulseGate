package com.pulsegate.probe_service.repository;

import com.pulsegate.probe_service.entity.Probe;
import com.pulsegate.probe_service.entity.ProbeResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProbeResultRepository extends JpaRepository<ProbeResult, Long> {

    List<ProbeResult> findByProbeOrderByCheckedAtDesc(Probe probe);

}