package com.pp.java.features.http;

import com.github.tomakehurst.wiremock.http.Body;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest
public class HttpTest {

    @Test
    public void shouldGetData(WireMockRuntimeInfo wmRuntimeInfo) {
        var endpoint = "/hello";
        var gson = new Gson();

        var article = new Article("Hello world", "Greetings to the whole world");

        stubFor(get(endpoint)
                .willReturn(
                        ok().withResponseBody(new Body(gson.toJson(article)))));

        var baseUrl = wmRuntimeInfo.getHttpBaseUrl() + endpoint;
        // TODO use HttpClient https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html to download synchronously article from endpoint and Gson library to deserialize body
        Article downloadedArticle = null;

        assertEquals(article, downloadedArticle);
    }

    private static class Article {

        private final String title;
        private final String body;

        Article(String title, String body) {
            this.title = title;
            this.body = body;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Article article = (Article) o;
            return Objects.equals(title, article.title) && Objects.equals(body, article.body);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, body);
        }
    }
}
