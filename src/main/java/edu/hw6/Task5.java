package edu.hw6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    static class HackerNews {
        private static URI uri;
        private static final int WAITING_SECONDS = 3;

        public static void setUriForTest(URI newUri) {
            uri = newUri;
        }

        public static void setDefaultUri() {
            uri = URI.create("https://hacker-news.firebaseio.com/v0/topstories.json");
        }

        public static long[] hackerNewsTopStories() {
            if (uri == null) {
                setDefaultUri();
            }
            var request = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .timeout(Duration.of(WAITING_SECONDS, ChronoUnit.SECONDS))
                .build();
            try (HttpClient client = HttpClient.newHttpClient()) {
                String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
                String[] respValues = response.substring(1, response.length() - 1).split(",");
                long[] ans = new long[respValues.length];
                for (int i = 0; i < respValues.length; ++i) {
                    ans[i] = Long.parseLong(respValues[i]);
                }
                return ans;
            } catch (Exception exc) {
                return new long[0];
            }
        }

        public static String news(long id) {
            var request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
                .GET()
                .timeout(Duration.of(WAITING_SECONDS, ChronoUnit.SECONDS))
                .build();
            try (HttpClient client = HttpClient.newHttpClient()) {
                String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
                Pattern pattern = Pattern.compile(".*title\":\"([^\"]+)\".*\":.*");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    response = matcher.group(1);
                } else {
                    response = "-";
                }
                return response;
            } catch (Exception exc) {
                return "";
            }
        }
    }
}
