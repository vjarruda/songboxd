package com.songboxd.songboxd.service;

import com.songboxd.songboxd.client.SpotifyAuthClient;
import com.songboxd.songboxd.client.SpotifyClient;
import com.songboxd.songboxd.dto.AlbumItemDTO;
import com.songboxd.songboxd.dto.SpotifyAlbumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotifyService {
    private final SpotifyAuthClient authClient;
    private final SpotifyClient spotifyClient;

    @Value("${spotify.client-id}")
    private String clientId;

    @Value("${spotify.client-secret}")
    private String clientSecret;

    public List<AlbumItemDTO> searchAlbums(String query) {
        String authHeader = "Basic " + Base64.getEncoder()
                .encodeToString((clientId + ":" + clientSecret).getBytes());

        var tokenResponse = authClient.getToken(authHeader, "grant_type=client_credentials");
        String accessToken = (String) tokenResponse.get("access_token");


        SpotifyAlbumResponse response = spotifyClient.searchAlbums("Bearer " + accessToken, query, "album");

        return response.getAlbums().getItems();
    }
}