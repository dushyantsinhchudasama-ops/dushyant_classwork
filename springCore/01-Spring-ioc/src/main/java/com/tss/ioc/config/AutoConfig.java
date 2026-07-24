package com.tss.ioc.config;

import com.tss.ioc.entity.Computer;
import com.tss.ioc.entity.Harddisk;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {

    @Bean
    public Computer computer()
    {
        return new Computer("Apple", harddisk());
    }

    @Bean
    public Harddisk harddisk()
    {
        return new Harddisk(326);
    }

}
