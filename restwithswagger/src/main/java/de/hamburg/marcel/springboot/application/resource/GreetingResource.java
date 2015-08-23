package de.hamburg.marcel.springboot.application.resource;

import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.hamburg.marcel.springboot.application.model.Greeting;
import io.swagger.annotations.ApiOperation;

@RestController 
@RequestMapping(value="/greeting")
public class GreetingResource {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value="abfrage mit counter")
    @RequestMapping( method=RequestMethod.GET, produces="application/json" )
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}