package com.chenjiacheng.webapp.controller.model.validation;

import com.chenjiacheng.webapp.controller.model.Request;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by chenjiacheng on 2025/2/17 23:04
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Data
public class ValidationRequest extends Request implements Serializable {

    @NotNull(message = "name cannot be null")
    private String name;

}
