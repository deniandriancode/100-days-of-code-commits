package app;

import java.io.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import com.fasterxml.jackson.databind.*;

@RestController
public class EnglishWordController {

    @Autowired
    EnglishWordData data;

    @GetMapping("/")
    public String index() {
        return "<h1>Welcome Home!</h1>";
    }

    @GetMapping("/word")
    public String findWord(@RequestParam(name = "q", defaultValue = "") String q) {
        if (q.trim().length() == 0) {
            return "Please enter a valid English word.\n";
        }
        JsonNode dictionary = data.wordNode;
        if (dictionary.path(q).isMissingNode()) {
            return String.format("Word '%s' not found. No such English word.\n", q);
        }
        return String.format("Word '%s' is indeed an English word.\n", q);
    }

    @GetMapping("/find")
    public boolean findWordBoolean(@RequestParam(name = "q", defaultValue = "") String q) {
        if (q.trim().length() == 0) {
            return false;
        }
        JsonNode dictionary = data.wordNode;
        if (dictionary.path(q).isMissingNode()) {
            return false;
        }
        return true;
    }

}
