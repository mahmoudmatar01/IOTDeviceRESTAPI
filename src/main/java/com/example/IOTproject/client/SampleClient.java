//package com.example.IOTproject.client;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.awt.*;
//
//@FeignClient(value = "sampleclient",
//url = "${sample.client.url}",
//configuration = SampleClientConfiguration.class)
//public interface SampleClient {
//    @RequestMapping(method = RequestMethod.GET,
//    value = "/sample",
//    produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<Object> getSampleDataByID(@RequestParam int id);
//}
