package com.learning.stall.service;

import com.learning.stall.dto.StallDTO;
import com.learning.stall.model.Stall;
import com.learning.stall.repository.StallRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class StallService {

    private final RestClient restClient;

    @Autowired
    private StallRepository stallRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StallKafkaProducer stallKafkaProducer;

    @Autowired
    public StallService(RestClient.Builder restClientBuilder){
        restClient = restClientBuilder.build();
    }

    public String getMessageUsingRestClient(){
        String response =
                restClient.get().uri("http://reqres.in/api/users/2")
                        .retrieve().body(String.class);
        return response;
    }

    public StallDTO getStallDetailsOnID(Integer id){
        Optional<Stall> stall = stallRepository.findById(id);
        System.out.println("Stall retrieved from repository " + stall.get());
        return this.modelMapper.map(stall.get(), StallDTO.class);
    }

    public StallDTO persistStallDetails(StallDTO stallDTO){
        Stall stall = this.modelMapper.map(stallDTO, Stall.class);
        System.out.println("Stall entity representation after mapping" + stall);
        Stall savedStallInDB = stallRepository.save(stall);
        //Invoke Notification Service to Kafka, this should happen async
        stallKafkaProducer.sendMessage("");
        System.out.println("Returned immediately as producer is started in a different thread " + stall);
        return this.modelMapper.map(savedStallInDB, StallDTO.class);
        //return new StallDTO();
    }

    public StallDTO getStallDetailsOnCategory(String category) {
        return this.modelMapper.map(stallRepository.findByCategory(category), StallDTO.class);
    }
}
