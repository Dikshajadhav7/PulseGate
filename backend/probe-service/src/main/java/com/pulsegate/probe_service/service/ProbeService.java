package com.pulsegate.probe_service.service;

import com.pulsegate.probe_service.dto.request.CreateProbeRequest;
import com.pulsegate.probe_service.dto.request.UpdateProbeRequest;
import com.pulsegate.probe_service.dto.response.ProbeResponse;
import com.pulsegate.probe_service.entity.Probe;
import com.pulsegate.probe_service.exception.ProbeNotFoundException;
import com.pulsegate.probe_service.mapper.ProbeMapper;
import com.pulsegate.probe_service.repository.ProbeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProbeService {

    private final ProbeRepository probeRepository;
    private final ProbeMapper probeMapper;

    public ProbeService(ProbeRepository probeRepository,
                        ProbeMapper probeMapper) {
        this.probeRepository = probeRepository;
        this.probeMapper = probeMapper;
    }

    // Create Probe
    public ProbeResponse createProbe(CreateProbeRequest request) {

        if (probeRepository.existsByUrl(request.getUrl())) {
            throw new RuntimeException("Probe already exists for this URL");
        }

        Probe probe = probeMapper.toEntity(request);

        Probe savedProbe = probeRepository.save(probe);

        return probeMapper.toResponse(savedProbe);
    }

    // Get All Probes
    public List<ProbeResponse> getAllProbes() {

        return probeRepository.findAll()
                .stream()
                .map(probeMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Get Probe By Id
    public ProbeResponse getProbeById(Long id) {

        Probe probe = probeRepository.findById(id)
                .orElseThrow(() ->
                        new ProbeNotFoundException("Probe not found"));

        return probeMapper.toResponse(probe);
    }

    // Update Probe
    public ProbeResponse updateProbe(Long id,
                                     UpdateProbeRequest request) {

        Probe probe = probeRepository.findById(id)
                .orElseThrow(() ->
                        new ProbeNotFoundException("Probe not found"));

        probeMapper.updateEntity(probe, request);

        Probe updatedProbe = probeRepository.save(probe);

        return probeMapper.toResponse(updatedProbe);
    }

    // Delete Probe
    public void deleteProbe(Long id) {

        Probe probe = probeRepository.findById(id)
                .orElseThrow(() ->
                        new ProbeNotFoundException("Probe not found"));

        probeRepository.delete(probe);
    }

}