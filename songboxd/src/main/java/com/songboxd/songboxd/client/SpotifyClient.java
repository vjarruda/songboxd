package com.songboxd.songboxd.client;

import com.songboxd.songboxd.dto.SpotifyAlbumResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spotify", url = "https://api.spotify.com/v1")
public interface SpotifyClient {
    @GetMapping("/search")
    SpotifyAlbumResponse searchAlbums(
            @RequestHeader("Authorization") String token,
            @RequestParam("q") String query,
            @RequestParam("type") String type
    );
}
