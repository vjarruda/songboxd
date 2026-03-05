package com.songboxd.songboxd.controller;

import com.songboxd.songboxd.dto.AlbumItemDTO;
import com.songboxd.songboxd.service.SpotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/albums")
public class AlbumController {

    private final SpotifyService spotifyService;

    @GetMapping("/search")
    public List<AlbumItemDTO> search(@RequestParam String query){
        return spotifyService.searchAlbums(query);
    }
}
