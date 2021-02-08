package com.hzqing.common.api.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * id 主键校验
 *
 * @author hzqing
 * @date 2019-08-13 21:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class IDRequest extends AbstractRequest {

    private static final long serialVersionUID = 4085265036094778483L;
    /**
     * 主键
     */
    @NotNull(message = "ID cannot be empty.")
    private String id;

    public IDRequest() {
    }


    public IDRequest(String id) {
        this.id = id;
    }

    @Override
    public void checkParams() {
        if (StringUtils.isEmpty(id)) {
        }
    }
}
