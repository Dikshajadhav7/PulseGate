package com.pulsegate.probe_service.dto.response;

import com.pulsegate.probe_service.entity.HttpMethod;
import com.pulsegate.probe_service.entity.ProbeStatus;

import java.time.LocalDateTime;

public class ProbeResponse {

    private Long id;

    private String name;

    private String url;

    private HttpMethod method;

    private ProbeStatus status;

    private Integer intervalSeconds;

    private Integer timeoutMs;

    private Integer expectedStatusCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ProbeResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public ProbeStatus getStatus() {
        return status;
    }

    public void setStatus(ProbeStatus status) {
        this.status = status;
    }

    public Integer getIntervalSeconds() {
        return intervalSeconds;
    }

    public void setIntervalSeconds(Integer intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
    }

    public Integer getTimeoutMs() {
        return timeoutMs;
    }

    public void setTimeoutMs(Integer timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public Integer getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public void setExpectedStatusCode(Integer expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}