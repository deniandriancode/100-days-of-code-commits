package org.fam;

import org.springframework.core.io.*;

import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;

public class GreetingData {

    public List<Greeting> userShelfOne = new ArrayList<Greeting>();
    public JsonNode wordNode;

    public GreetingData() throws Exception {
        initShelfOne();
        initSampleData();
    }

    public void initShelfOne() {
        userShelfOne.add(new Greeting(1, "John Doe"));
        userShelfOne.add(new Greeting(2, "Jane Doe"));
        userShelfOne.add(new Greeting(3, "Brad"));
        userShelfOne.add(new Greeting(4, "Kevin"));
        userShelfOne.add(new Greeting(5, "Charless"));
        userShelfOne.add(new Greeting(6, "Claire"));
        userShelfOne.add(new Greeting(7, "Smith"));
    }

    public void initSampleData() throws Exception {
        File jsonFile = new ClassPathResource("words_dictionary.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(jsonFile);
        wordNode = node;
    }

}
