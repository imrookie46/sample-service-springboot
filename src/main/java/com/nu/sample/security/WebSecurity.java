/**
* Author: ImRookie46
* 2019
*/
package com.nu.sample.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment env;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public WebSecurity(Environment env) {

        this.env = env;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("security scan");

        http.csrf().disable(); // disable bcz will use jwtoken

        // permission
        http.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip")); // allow any url pattern with ip address

        http.headers().frameOptions().disable();
    }

}
