package ch.trivadis.workshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Anatole Tresch
 */
@RestController
@RequestMapping("/")
public class HelloController {

  private Set<String> whoWasHere = new HashSet<>();

  @GetMapping(path = "/hello/{name}", produces = "text/html")
  public String get(@PathVariable("name") String name) {
    whoWasHere.add(name);
    return buildPage("Hallo Welt", "Hallo " + name);
  }

  @GetMapping(path = "/whowashere", produces = "text/html")
  public String getVisitors() {
    return buildPage("Visitors", whoWasHere.toString());
  }

  @GetMapping(path = "/time", produces = "text/html")
  public String getTime() {
    return buildPage("Current Time", LocalDateTime.now().toString());
  }

  @GetMapping(path = "/env", produces = "text/html")
  public String getEnv() {
    return buildPage("Environment", System.getenv().toString());
  }

  private String buildPage(String title, String text){
    return "<html><head><title>"+title+"</title></head></html>" +
            "<body>" +
            "<h1>"+title+"</h1>" +
            "<pre>\n"+
              text +
            "</pre>" +
            "</body>";
  }

}
