package me.wonwoo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by wonwoolee on 2017. 9. 3..
 */
@RestController
public class PersonController {

  private final PersonGenerator personGenerator;

  public PersonController(PersonGenerator personGenerator) {
    this.personGenerator = personGenerator;
  }

  @GetMapping("/{name}")
  Mono<Person> getPerson(@PathVariable String name) {
    return personGenerator.findByName(name);
  }

  @GetMapping("/")
  Flux<Person> getPersons() {
    return personGenerator.findAll();
  }
}
