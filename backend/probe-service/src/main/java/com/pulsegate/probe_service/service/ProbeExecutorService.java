package com.pulsegate.probe_service.service;

import com.pulsegate.probe_service.entity.Probe;
import com.pulsegate.probe_service.entity.ProbeResult;
import com.pulsegate.probe_service.repository.ProbeRepository;
import com.pulsegate.probe_service.repository.ProbeResultRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class ProbeExecutorService {

    private final RestTemplate restTemplate;

    private final ProbeResultRepository probeResultRepository;

    private final ProbeRepository probeRepository;

    public ProbeExecutorService(
            RestTemplate restTemplate,
            ProbeResultRepository probeResultRepository,
            ProbeRepository probeRepository) {

        this.restTemplate = restTemplate;
        this.probeResultRepository = probeResultRepository;
        this.probeRepository = probeRepository;
    }

    public void executeProbe(Probe probe) {

        ProbeResult result = new ProbeResult();

        result.setProbe(probe);

        long startTime = System.currentTimeMillis();

        try {

            ResponseEntity<String> response =
                    restTemplate.getForEntity(probe.getUrl(), String.class);

            long endTime = System.currentTimeMillis();

            result.setStatusCode(response.getStatusCode().value());

            result.setResponseTimeMs(endTime - startTime);

            result.setSuccess(
                    response.getStatusCode().value()
                            == probe.getExpectedStatusCode()
            );

            String body = response.getBody();

            if (body != null && body.length() > 2000) {
                body = body.substring(0, 2000);
            }

            result.setResponseBody(body);

            result.setErrorMessage(null);

        } catch (Exception ex) {

            long endTime = System.currentTimeMillis();

            result.setStatusCode(0);

            result.setResponseTimeMs(endTime - startTime);

            result.setSuccess(false);

            result.setErrorMessage(ex.getMessage());

            result.setResponseBody(null);

        }

        probeResultRepository.save(result);
        probe.setLastExecutedAt(LocalDateTime.now());

        probeRepository.save(probe);

    }

}