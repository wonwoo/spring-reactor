package me.wonwoo.web;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by wonwoolee on 2017. 9. 3..
 */
@Service
public class PersonGenerator {

  private final static Flux<Person> GENERATOR = Flux.just(
      new Person("Heineken"),
      new Person("Hoegaarden"),
      new Person("Miller"),
      new Person("Guinness"),
      new Person("Corona"),
      new Person("Budweiser")
  );

  public Mono<Person> findByName(String name) {
    return GENERATOR
        .filter(person -> person.getName().equals(name))
        .next()
        .log();
  }

  public Flux<Person> findAll() {
    return GENERATOR.log();
  }

}
