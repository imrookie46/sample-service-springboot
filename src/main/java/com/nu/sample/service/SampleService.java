/**
* Author: ImRookie46
* 2019
*/
package com.nu.sample.service;

import com.nu.sample.dao.SampleDao;
import com.nu.sample.data.AlbumServiceClient;
import com.nu.sample.data.SampleEntity;
import com.nu.sample.model.AlbumServiceModel;
import com.nu.sample.model.ResponseBodyModel;
import com.nu.sample.model.Sample2ResModel;
import com.nu.sample.model.SampleReqModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Put your logic here
 *
 * */
import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    AlbumServiceClient albumServiceClient;
    @Autowired
    private SampleDao sampleDao;

    public SampleService(SampleDao sampleDao,
                         AlbumServiceClient albumServiceClient) {
        this.sampleDao = sampleDao;
        this.albumServiceClient = albumServiceClient;
    }


    public ResponseBodyModel searchTablebyUsername(SampleReqModel reqDetails){
        logger.info("searchTablebyUsername: " + reqDetails.getUserName());

        // need query?
        // send query task to Dao
        List<SampleEntity> sampleEntities = sampleDao.searchTablebyUsername(reqDetails.getUserName());
        for(SampleEntity sampleEntity : sampleEntities){
            logger.info("item:" + sampleEntity.getEmail() + "|" + sampleEntity.getFirstName());
        }


        // let's build response data
        // make class object that require your output expectation
        // add something to that class
        List<Sample2ResModel> sample2ResModel = new ArrayList<>();

        for(SampleEntity sampleEntity : sampleEntities){
            Sample2ResModel sampleItem = new Sample2ResModel();
            sampleItem.setEmail(sampleEntity.getEmail());
            sampleItem.setFirstName(sampleEntity.getFirstName());
            sampleItem.setLastName(sampleEntity.getLastName());
            sample2ResModel.add(sampleItem);
        }



        // need to communicate to other microservice?
        // let's use Feign to other microservice to get something
        // must have interface to handle Feign to each microservice
        // this only work, if both microservice are registered to service registry.
        // please dissable this lines if you want to test without, service registry
        List<AlbumServiceModel> albumServiceModelList = albumServiceClient.getAlbum(reqDetails.getUserName());
        logger.info("get from album: "+albumServiceModelList.size());


        // build final response body
        // it should be default response structure
        ResponseBodyModel responseBody = new ResponseBodyModel();
        responseBody.setStatus(0);
        responseBody.setMessage("Ok");
        responseBody.setData(sample2ResModel);

        return responseBody;
    }
}
