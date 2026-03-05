package com.songboxd.songboxd.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumItemDTO {
    private String id;
    private String name;
    private String release_date;
    private List<ArtistDTO> artists;
    private List<ImageDTO> images;

    public String getUrlImagem() {
        return (images != null && !images.isEmpty()) ? images.get(0).getUrl() : null;
    }
}
