public class App {
    public static void main(String[] args) {
        CustomHttpClient client = new CustomHttpClient();
        client.getAndPrintPage();
        client.handleRedirect();
    }
}
