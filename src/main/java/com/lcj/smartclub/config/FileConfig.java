package com.lcj.smartclub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定位各种文件或图像地址
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    public void addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry registry){

        //apple下的图像地址
        registry.addResourceHandler("/apple/**").addResourceLocations(
                "file:"+System.getProperty("user.dir")+System.getProperty("file.separator")+"apple"
                        +System.getProperty("file.separator")
        );
    }
}