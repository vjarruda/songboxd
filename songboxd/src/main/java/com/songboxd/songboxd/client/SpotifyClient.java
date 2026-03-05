package com.songboxd.songboxd.client;

import com.songboxd.songboxd.dto.SpotifyAlbumResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public interface SpotifyClient {
    @GetMapping("/search")
    SpotifyAlbumResponse searchAlbums(
            @RequestHeader("Authorization") String token,
            @RequestParam("q") String query,
            @RequestParam("type") String type
    );
}
