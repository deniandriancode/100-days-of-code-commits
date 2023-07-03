package org.fam;

import java.util.*;
import java.util.concurrent.atomic.*;
import org.springframework.web.bind.annotation.*;

// TODO: create english word dictionary

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting/find")
    public List<Greeting> findGreeting(@RequestParam(value = "user") String user) throws Exception {
        GreetingData data = new GreetingData();
        List<Greeting> result = new ArrayList<Greeting>();
        for (int i = 0; i < data.userShelfOne.size(); ++i) {
            if (data.userShelfOne.get(i).content.toLowerCase().contains(user.toLowerCase())) {
                result.add(data.userShelfOne.get(i));
            }
        }

        return result;
    }

    @GetMapping("/word")
    public boolean findEnglishWord(@RequestParam(value = "q") String q) throws Exception {
        boolean isExists = false;

        GreetingData data = new GreetingData();
        int result = data.wordNode.path(q).asInt();
        System.out.println(result);
        System.out.println(q);
        if (result == 1)
            isExists = true;

        return isExists;
    }

}
