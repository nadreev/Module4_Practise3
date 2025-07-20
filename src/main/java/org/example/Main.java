package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

    System.out.println("Example_1");
        for (int i = 1; i <= 5; i++) {
            getById(i);
        }
    System.out.println("Example_2");
        TODO todo = new TODO();
        todo.setUserId("1");
        todo.setTitle("Hello everyone");
        todo.setCompleted(true);
        postHttpClient(todo);

    System.out.println("Example_3");
        TODO todo_put = new TODO();
        todo_put.setTitle("Amended title");
        todo_put.setCompleted(true);
        putHttpClient(todo_put);

    System.out.println("Example_4");
    delete_HttpClient(1);

    }


    public static void getById(int id) throws URISyntaxException, IOException, InterruptedException {

        HttpClient client = newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/" + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        TODO post = mapper.readValue(response.body(), TODO.class);

        System.out.print("ID "+post.getId()+"\t");
        System.out.println("Description "+post.getTitle());
    }

public static void postHttpClient(TODO todo) throws IOException, URISyntaxException, InterruptedException {

    HttpClient client = newHttpClient();

    ObjectMapper mapper = new ObjectMapper();
    String load =  mapper.writeValueAsString(todo);

    HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://jsonplaceholder.typicode.com/todos/"))
            .POST(HttpRequest.BodyPublishers.ofString(load))
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println("Server response "+response.toString());
    }

    public static void putHttpClient(TODO todo) throws IOException, URISyntaxException, InterruptedException {

        HttpClient client = newHttpClient();

        ObjectMapper mapper = new ObjectMapper();
        String load =  mapper.writeValueAsString(todo);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                .PUT(HttpRequest.BodyPublishers.ofString(load))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Server response "+response.toString());
    }

    public static void delete_HttpClient(int id) throws IOException, URISyntaxException, InterruptedException {

        HttpClient client = newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos/"+id))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Server response "+response.toString());
    }

}



