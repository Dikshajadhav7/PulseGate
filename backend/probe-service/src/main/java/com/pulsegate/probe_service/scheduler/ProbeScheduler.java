package com.pulsegate.probe_service.scheduler;

import com.pulsegate.probe_service.entity.Probe;
import com.pulsegate.probe_service.entity.ProbeStatus;
import com.pulsegate.probe_service.repository.ProbeRepository;
import com.pulsegate.probe_service.service.ProbeExecutorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProbeScheduler
{

    private final ProbeRepository probeRepository;
    private final ProbeExecutorService probeExecutorService;

    public ProbeScheduler(ProbeRepository probeRepository,
                          ProbeExecutorService probeExecutorService)
    {

        this.probeRepository = probeRepository;
        this.probeExecutorService = probeExecutorService;
    }

    @Scheduled(fixedRate = 30000)
    public void executeActiveProbes()
    {

        List<Probe> probes = probeRepository.findByStatus(ProbeStatus.ACTIVE);

        for (Probe probe : probes)
        {

            probeExecutorService.executeProbe(probe);
        }

    }

}