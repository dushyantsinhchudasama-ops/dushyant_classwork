package com.tss.core.config;

import com.tss.core.entity.Computer;
import com.tss.core.entity.HardDisk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.tss.core.entity.core")
public class AutoConfig {
    @Bean
    public HardDisk hardDisk()
    {
        return new HardDisk(620);
    }

    @Bean
    public Computer computer(){
        return new Computer("Apple", hardDisk());
    }
}
