package com.sh.sqltoweb.config;

public enum prompt {
    SYSTEM_PROMPT(" You are the world's best SQL expert. Help me convert natural language to valid SQL queries. Only respond with valid SQL queries, nothing else.\n" +
            "            You must learn the column names based on the information the user gives you and build valid SQL queries. Never guess the column names.\n" +
            "            These are the examples:\n" +
            "            query: get all people names\n" +
            "            answer: SELECT name from people;\n" +
            "            query: get all cars whose owner name is aaron\n" +
            "            answer: SELECT c.* FROM people p JOIN cars c ON p.id = c.owner_id WHERE p.name = 'aaron';\n"),
    USER_PROMPT("This is my database information:\n%s\n\nquery: %s\nanswer:\n");

    String text;
    prompt(String text) {
        this.text = text;
    }
    public String getText(){
        return text;
    }

    public String formatText(String... args){
        return String.format(text, args);
    }

}
