package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ResendEmailUtil {
    // For production, it's better to use an environment variable: System.getenv("RESEND_API_KEY")
    private static final String API_KEY = "re_QieapYus_4ZjwE7JiyJ3AuSKtJVGfEvDP";
    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(8))
            .build();

    public static boolean send(String from, String to, String subject, String htmlBody) {
        if (API_KEY == null || API_KEY.isBlank()) {
            System.err.println("[ResendEmailUtil] Missing RESEND_API_KEY environment variable.");
            return false;
        }
        try {
            String json = toJson(from, to, subject, htmlBody);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.resend.com/emails"))
                    .timeout(Duration.ofSeconds(15))
                    .header("Authorization", "Bearer " + API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                    .build();
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();
            if (status >= 200 && status < 300) {
                return true;
            }
            System.err.println("[ResendEmailUtil] Failed status=" + status + " body=" + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String esc(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static String toJson(String from, String to, String subject, String html) {
        return "{" +
                "\"from\":\"" + esc(from) + "\"," +
                "\"to\":[\"" + esc(to) + "\"]," +
                "\"subject\":\"" + esc(subject) + "\"," +
                "\"html\":\"" + esc(html) + "\"" +
                "}";
    }
}
