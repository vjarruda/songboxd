package com.songboxd.songboxd.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumsList {
    private List<AlbumItemDTO> items;
}
