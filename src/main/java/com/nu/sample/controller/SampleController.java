package com.nu.sample.controller;

import com.nu.sample.data.SampleEntity;
import com.nu.sample.model.ResponseBodyModel;
import com.nu.sample.model.SampleReqModel;
import com.nu.sample.model.SampleResModel;
import com.nu.sample.service.SampleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class SampleController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Environment env;
    @Autowired
    SampleService sampleService;

    /**
     * sample GET request
     * @ param: userName
     * @ res : in json/xml
     * */
    @GetMapping(value="/{userName}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SampleResModel> status(@PathVariable("userName") String userName)
    {

        SampleResModel returnValue = new SampleResModel();
        returnValue.setUserName(userName);
        logger.info("Hello, " + returnValue.getUserName());

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }



    /**
     * sample POST request
     * content-type in request must be set json/xml
     * @ req body
     * @ res body
     * */
    @PostMapping(value = "/tableCheck",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<ResponseBodyModel> tableCheck(@RequestHeader("user_id") String user_id,
                                                        @Validated @RequestBody SampleReqModel reqDetails){

        logger.info("table checking for user_id :" + user_id);

        // pass jobs to service class
        ResponseBodyModel responseBody = sampleService.searchTablebyUsername(reqDetails);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
