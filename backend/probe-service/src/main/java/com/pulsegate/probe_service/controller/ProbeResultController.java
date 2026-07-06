package com.pulsegate.probe_service.controller;

import com.pulsegate.probe_service.dto.response.ProbeResultResponse;
import com.pulsegate.probe_service.entity.Probe;
import com.pulsegate.probe_service.entity.ProbeResult;
import com.pulsegate.probe_service.exception.ProbeNotFoundException;
import com.pulsegate.probe_service.repository.ProbeRepository;
import com.pulsegate.probe_service.repository.ProbeResultRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ProbeResultController {

    private final ProbeRepository probeRepository;
    private final ProbeResultRepository probeResultRepository;

    public ProbeResultController(ProbeRepository probeRepository,
                                 ProbeResultRepository probeResultRepository) {

        this.probeRepository = probeRepository;
        this.probeResultRepository = probeResultRepository;
    }

    @GetMapping("/{probeId}")
    public List<ProbeResultResponse> getResults(
            @PathVariable Long probeId) {

        Probe probe = probeRepository.findById(probeId)
                .orElseThrow(() ->
                        new ProbeNotFoundException("Probe not found"));

        List<ProbeResult> results =
                probeResultRepository.findByProbeOrderByCheckedAtDesc(probe);

        List<ProbeResultResponse> response = new ArrayList<>();

        for (ProbeResult result : results) {

            ProbeResultResponse dto = new ProbeResultResponse();

            dto.setId(result.getId());
            dto.setStatusCode(result.getStatusCode());
            dto.setResponseTimeMs(result.getResponseTimeMs());
            dto.setSuccess(result.getSuccess());
            dto.setErrorMessage(result.getErrorMessage());
            dto.setResponseBody(result.getResponseBody());
            dto.setCheckedAt(result.getCheckedAt());

            response.add(dto);
        }

        return response;
    }
}