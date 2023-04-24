package com.nyxei.pollingus.Repository;



import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Configuration;


import lombok.Data;



@Configuration

@ConfigurationProperties(prefix = "com.nyxei.pollingus")

@Data

public class CustomProperties {


    private String apiUrl;


}

