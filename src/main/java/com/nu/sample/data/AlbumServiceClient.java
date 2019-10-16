package com.nu.sample.data;

import com.nu.sample.model.AlbumServiceModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * for feign to other Album microservice
 * application name of Album MS is "service-album"
 * */
@FeignClient(name="service-album")
public interface AlbumServiceClient {

    /**
     * map to controller in Album microservice
     * path: "/users/{id}/albums"
     * put it to obect that has same field with the response from Album microservice
     * */
    @GetMapping("/users/{id}/albums")
    public List<AlbumServiceModel> getAlbum(@PathVariable String id);
}
