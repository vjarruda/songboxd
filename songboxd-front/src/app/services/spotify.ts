import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class Spotify {
  private api = "http://localhost:8080/api/albums";

  constructor(private http: HttpClient) {}

  searchAlbums(query: string) {
    return this.http.get(`${this.api}/search?query=${query}`);
  }
}
