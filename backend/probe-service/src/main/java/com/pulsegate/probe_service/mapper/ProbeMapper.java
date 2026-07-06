package com.pulsegate.probe_service.mapper;

import com.pulsegate.probe_service.dto.request.CreateProbeRequest;
import com.pulsegate.probe_service.dto.request.UpdateProbeRequest;
import com.pulsegate.probe_service.dto.response.ProbeResponse;
import com.pulsegate.probe_service.entity.Probe;
import org.springframework.stereotype.Component;

@Component
public class ProbeMapper {

    public Probe toEntity(CreateProbeRequest request) {

        Probe probe = new Probe();

        probe.setName(request.getName());
        probe.setUrl(request.getUrl());
        probe.setMethod(request.getMethod());
        probe.setIntervalSeconds(request.getIntervalSeconds());
        probe.setTimeoutMs(request.getTimeoutMs());
        probe.setExpectedStatusCode(request.getExpectedStatusCode());

        return probe;
    }

    public void updateEntity(Probe probe, UpdateProbeRequest request) {

        probe.setName(request.getName());
        probe.setUrl(request.getUrl());
        probe.setMethod(request.getMethod());
        probe.setStatus(request.getStatus());
        probe.setIntervalSeconds(request.getIntervalSeconds());
        probe.setTimeoutMs(request.getTimeoutMs());
        probe.setExpectedStatusCode(request.getExpectedStatusCode());
    }

    public ProbeResponse toResponse(Probe probe) {

        ProbeResponse response = new ProbeResponse();

        response.setId(probe.getId());
        response.setName(probe.getName());
        response.setUrl(probe.getUrl());
        response.setMethod(probe.getMethod());
        response.setStatus(probe.getStatus());
        response.setIntervalSeconds(probe.getIntervalSeconds());
        response.setTimeoutMs(probe.getTimeoutMs());
        response.setExpectedStatusCode(probe.getExpectedStatusCode());
        response.setCreatedAt(probe.getCreatedAt());
        response.setUpdatedAt(probe.getUpdatedAt());

        return response;
    }

}