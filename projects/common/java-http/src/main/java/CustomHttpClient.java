import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.BiConsumer;

public class CustomHttpClient {
    private final HttpClient client = HttpClient.newBuilder().build();

    public void getAndPrintPage() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    public void handleRedirect() {
        try {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://swapi.dev/api/people/1"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        if(statusCode == 200) {
            String body = response.body();
            System.out.println(body);
        } else {

            System.out.println(statusCode);
        }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
