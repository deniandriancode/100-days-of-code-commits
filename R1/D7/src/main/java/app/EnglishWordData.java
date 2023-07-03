package app;

import java.io.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

@Component
public class EnglishWordData {

    public ObjectMapper mapper = new ObjectMapper();
    public JsonNode wordNode = null;

    public EnglishWordData() {
        try {
            String fileString = "words_dictionary.json";
            File resource = new ClassPathResource(fileString).getFile();
            wordNode = mapper.readTree(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
