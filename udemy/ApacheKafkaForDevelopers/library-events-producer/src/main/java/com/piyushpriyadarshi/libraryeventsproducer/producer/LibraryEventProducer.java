package com.piyushpriyadarshi.libraryeventsproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piyushpriyadarshi.libraryeventsproducer.model.LibraryEvents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class LibraryEventProducer {

    @Autowired
    private KafkaTemplate<Integer,String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;



    public void sendLibraryEvent(LibraryEvents libraryEvents) throws JsonProcessingException {
        String data=objectMapper.writeValueAsString(libraryEvents);
        ListenableFuture<SendResult<Integer,String>> listenableFuture= kafkaTemplate.sendDefault(libraryEvents.getLibraryEventId(),data);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("SomeError Occurred"+throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {
                log.info("SuccessFully Send the Data to Kafka Topic"+integerStringSendResult.getRecordMetadata());
            }
        });

    }

    public SendResult<Integer, String> sendLibraryEventSynchronous(LibraryEvents libraryEvents) throws JsonProcessingException {
        String data=objectMapper.writeValueAsString(libraryEvents);
        SendResult<Integer,String> sendResult=null;
        try {
             sendResult= kafkaTemplate.sendDefault(libraryEvents.getLibraryEventId(),data).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return sendResult;


    }
}
