package com.piyushpriyadarshi.libraryeventsproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.piyushpriyadarshi.libraryeventsproducer.model.LibraryEvents;
import com.piyushpriyadarshi.libraryeventsproducer.producer.LibraryEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/libraryevents")
@Slf4j
public class LibraryEventsController {


    @Autowired
    private LibraryEventProducer libraryEventProducer;

    @PostMapping
    public ResponseEntity<LibraryEvents> postLibraryEvents(@RequestBody LibraryEvents libraryEvents) throws JsonProcessingException {
//        libraryEventProducer.sendLibraryEvent(libraryEvents);
        SendResult<Integer,String> sendResult =libraryEventProducer.sendLibraryEventSynchronous(libraryEvents);
        if(sendResult!=null){
            log.info("Message Send SuccessFull"+sendResult.getRecordMetadata().toString());
            log.info(sendResult.getProducerRecord().toString());
        }
        //invoke kafka producer
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvents);

    }
    @PutMapping
    public ResponseEntity<LibraryEvents> putLibraryEvents(@RequestBody LibraryEvents libraryEvents){
        //

        return null;
    }
}
