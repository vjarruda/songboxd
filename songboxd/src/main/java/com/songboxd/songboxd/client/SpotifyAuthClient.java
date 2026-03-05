package com.songboxd.songboxd.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "spotifyAuthClient", url = "https://accounts.spotify.com")
public interface SpotifyAuthClient {

    @PostMapping(value = "/api/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Map<String, Object> getToken(
            @RequestHeader("Authorization") String basicAuth,
            @RequestBody String grantType // Mudamos de @RequestParam para @RequestBody
    );
}

