import java.io.IOException;
import java.net.URI;

public class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing string.");
            return;
        }

        int port = args.length;

        Server.start(port, new Handler());
    }
}

class Handler implements URLHandler {
    String x = "";

    public String handleRequest(URI url) {
        // if (url.getPath().equals("/")) {
        //     return String.format("String: %d", x);
        // } 
        // else {
        //     System.out.println("Path: " + url.getPath());
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].contains("/add-message?s")) {
                x += parameters[1] + '\n';
                return String.format(x);
            }
        }
        return "404 Not Found!";
        
    }
}
