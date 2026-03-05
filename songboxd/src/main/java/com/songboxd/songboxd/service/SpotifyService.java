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

    private String accessToken;
    private long tokenExpiration;

    private String getAccessToken() {

        if (accessToken != null && System.currentTimeMillis() < tokenExpiration) {
            return accessToken;
        }

        String authHeader = "Basic " + Base64.getEncoder()
                .encodeToString((clientId + ":" + clientSecret).getBytes());

        var tokenResponse = authClient.getToken(authHeader, "grant_type=client_credentials");

        accessToken = (String) tokenResponse.get("access_token");

        int expiresIn = (int) tokenResponse.get("expires_in");

        tokenExpiration = System.currentTimeMillis() + (expiresIn * 1000);

        return accessToken;
    }

    public List<AlbumItemDTO> searchAlbums(String query) {

        String token = getAccessToken();

        SpotifyAlbumResponse response = spotifyClient.searchAlbums(
                "Bearer " + token,
                query,
                "album"
        );

        return response.getAlbums().getItems();
    }
}