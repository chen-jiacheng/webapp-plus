package com.chenjiacheng.webapp.start.controller.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * Created by chenjiacheng on 2025/2/17 22:57
 *
 * @author chenjiacheng
 * @since 1.0.0
 */

@Data
public abstract class Request implements Serializable {

    @NotNull(message = "requestNo must be null")
    private String requestNo;

    @NotNull(message = "requestDate must be null")
    private String requestDate;

    @NotNull(message = "requestSystem must be null")
    private String requestSystem;

    @NotNull(message = "traceId must be null")
    private String traceId;

    public Request(String requestNo, String requestDate, String requestSystem, String traceId) {
        this.requestNo = requestNo;
        this.requestDate = requestDate;
        this.requestSystem = requestSystem;
        this.traceId = traceId;
    }

    public Request() {
    }
}
