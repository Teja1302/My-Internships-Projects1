package Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private Map<String, String> linkMap; 
    private Random random;
    private static final String BASE_URL = "https://short.en/";

    public LinkShortener() {
        linkMap = new HashMap<>();
        random = new Random();
    }

    
    private String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

  
    public String shortenURL(String longURL) {
        String shortURL = generateRandomString(6); 

      
        while (linkMap.containsKey(shortURL)) {
            shortURL = generateRandomString(6);
        }

        linkMap.put(shortURL, longURL);
        return BASE_URL + shortURL;
    }

    public String getLongURL(String shortURL) {
        String shortKey = shortURL.replace(BASE_URL, "");
        return linkMap.getOrDefault(shortKey, "URL not found");
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();

      
        String longURL = "https://www.example.com/very/long/url/to/be/shortened";
        String shortLink = linkShortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortLink);

        String retrievedURL = linkShortener.getLongURL(shortLink);
        System.out.println("Retrieved URL: " + retrievedURL);
    }
}
