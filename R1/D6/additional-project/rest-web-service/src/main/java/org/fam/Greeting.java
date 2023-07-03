package org.fam;

// public record Greeting(long id, String content) { }

public class Greeting {
    
    public long id;
    public String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
