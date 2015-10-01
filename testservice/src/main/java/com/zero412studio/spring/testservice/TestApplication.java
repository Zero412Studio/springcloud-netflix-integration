package com.zero412studio.spring.testservice;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * EurekaApplication
 */
@SpringBootApplication
@EnableWebMvc
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class TestApplication {
    public static void main(final String[] args) throws Exception {
        SpringApplication.run(TestApplication.class, args);
    }

    // make sure that this runs in AWS picking up correct data center info
    // this also means that app runs in AWS needs to have aws profile enabled
    @Bean
    @Profile(value = "aws")
    public EurekaInstanceConfigBean eurekaInstanceConfig() {
        EurekaInstanceConfigBean b = new EurekaInstanceConfigBean();
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");

        b.setDataCenterInfo(info);
        b.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
        b.setIpAddress(info.get(AmazonInfo.MetaDataKey.localIpv4));

        return b;
    }
}
