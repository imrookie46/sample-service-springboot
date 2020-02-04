/**
* Author: ImRookie46
* 2019
*/
package com.nu.sample.dao;

import com.nu.sample.data.SampleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SampleDao {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Environment env;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<SampleEntity> searchTablebyUsername(String userName){

        logger.info("query searchTablebyUsername : " + userName);

        String sql = "SELECT * FROM users where last_name = ? ";

        RowMapper<SampleEntity> rowMapper =  new BeanPropertyRowMapper<SampleEntity>(SampleEntity.class);

        List<SampleEntity> sampleList = jdbcTemplate.query(sql,new Object[]{userName},rowMapper);


        return sampleList;
    }

}
