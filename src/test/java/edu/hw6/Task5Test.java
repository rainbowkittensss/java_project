package edu.hw6;

import org.junit.jupiter.api.Test;
import java.net.URI;
import static edu.hw6.Task5.HackerNews;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    void task5TestNews() {
        long jdkReleaseNotes = 37570037;
        long incorrectId = -1;
        long isItAboutProgramming = 38297124;

        String ansJdk = "JDK 21 Release Notes";
        String ansNotAboutProgramming = "Ketamine-based clinics are improving veterans' mental health";
        String ansWrongId = "-";

        String jdkReleaseNotesTitle = HackerNews.news(jdkReleaseNotes);
        String isItAboutProgrammingTitle = HackerNews.news(isItAboutProgramming);
        String wrongIdTitle = HackerNews.news(incorrectId);

        assertThat(jdkReleaseNotesTitle).isEqualTo(ansJdk);
        assertThat(isItAboutProgrammingTitle).isEqualTo(ansNotAboutProgramming);
        assertThat(wrongIdTitle).isEqualTo(ansWrongId);
    }

    @Test
    void task5TestTopStories() {
        long[] ans = HackerNews.hackerNewsTopStories();

        assertThat(HackerNews.news(ans[3]).equals("_")).isFalse();  //убедимся, что найдены какие-то статьи
        assertThat(HackerNews.news(ans[10]).equals("_")).isFalse();
        assertThat(HackerNews.news(ans[5]).equals("_")).isFalse();
    }
    @Test
    void task5TestTopStoriesWithoutAnswer(){
        HackerNews.setUriForTest(URI.create("https://edu.tinkoff.ru/"));

        long[] ans = HackerNews.hackerNewsTopStories();

        assertThat(ans).isEqualTo(new long[0]);
        HackerNews.setDefaultUri();
    }
}
