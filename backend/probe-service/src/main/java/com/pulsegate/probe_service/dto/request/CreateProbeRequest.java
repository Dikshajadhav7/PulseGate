package com.pulsegate.probe_service.dto.request;

import com.pulsegate.probe_service.entity.HttpMethod;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateProbeRequest {

    @NotBlank(message = "Probe name is required")
    private String name;

    @NotBlank(message = "URL is required")
    private String url;

    @NotNull(message = "HTTP Method is required")
    private HttpMethod method;

    @NotNull(message = "Interval is required")
    @Min(value = 10, message = "Interval must be at least 10 seconds")
    private Integer intervalSeconds;

    @NotNull(message = "Timeout is required")
    @Min(value = 1000, message = "Timeout must be at least 1000 ms")
    private Integer timeoutMs;

    @NotNull(message = "Expected status code is required")
    private Integer expectedStatusCode;

    public CreateProbeRequest() {
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
}