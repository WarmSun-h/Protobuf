package com.protobuf.protobuftest.config;/**
 * @author Hu MengLong
 * @date 2020/7/29 17:11
 * @version 1.0
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName config
 * @Description TODO
 * @Author Hml
 * @DATE 2020/7/29 17:11
 * @Version 1.0
 **/
@Configuration
public class config {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
