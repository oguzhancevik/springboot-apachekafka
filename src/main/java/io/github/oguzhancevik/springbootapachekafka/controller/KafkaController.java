package io.github.oguzhancevik.springbootapachekafka.controller;

import io.github.oguzhancevik.springbootapachekafka.model.KafkaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

  @Autowired
  private KafkaTemplate<String, KafkaModel> kafkaTemplate;

  @PostMapping
  public void post(@RequestBody KafkaModel kafkaModel){
    kafkaTemplate.send("myTopic", kafkaModel);
  }

}
