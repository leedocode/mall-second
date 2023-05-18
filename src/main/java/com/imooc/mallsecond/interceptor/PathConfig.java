package com.imooc.mallsecond.interceptor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述: TODO
 */
@Component
@ConfigurationProperties(prefix = "excludeurl")
@Data
public class PathConfig {
    private String[] strings;
}
