package com.pulsegate.probe_service.controller;

import com.pulsegate.probe_service.dto.request.CreateProbeRequest;
import com.pulsegate.probe_service.dto.request.UpdateProbeRequest;
import com.pulsegate.probe_service.dto.response.ProbeResponse;
import com.pulsegate.probe_service.service.ProbeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/probes")
public class ProbeController {

    private final ProbeService probeService;

    public ProbeController(ProbeService probeService) {
        this.probeService = probeService;
    }

    @PostMapping
    public ProbeResponse createProbe(
            @Valid @RequestBody CreateProbeRequest request) {

        return probeService.createProbe(request);
    }

    @GetMapping
    public List<ProbeResponse> getAllProbes() {

        return probeService.getAllProbes();
    }

    @GetMapping("/{id}")
    public ProbeResponse getProbeById(
            @PathVariable Long id) {

        return probeService.getProbeById(id);
    }

    @PutMapping("/{id}")
    public ProbeResponse updateProbe(
            @PathVariable Long id,
            @Valid @RequestBody UpdateProbeRequest request) {

        return probeService.updateProbe(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteProbe(
            @PathVariable Long id) {

        probeService.deleteProbe(id);

        return "Probe deleted successfully";
    }
}