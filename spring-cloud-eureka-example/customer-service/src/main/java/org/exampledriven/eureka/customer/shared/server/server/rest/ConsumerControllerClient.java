package org.exampledriven.eureka.customer.shared.server.server.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Controller
public class ConsumerControllerClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public void getEmployee() throws RestClientException, IOException {

        List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer");
        ServiceInstance serviceInstance=instances.get(0);

        String baseUrl = serviceInstance.getUri().toString();

        baseUrl=baseUrl+"/employee";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(),String.class);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println("response: " + instances.size());
        System.out.println(response.getBody());
    }

    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }
}
