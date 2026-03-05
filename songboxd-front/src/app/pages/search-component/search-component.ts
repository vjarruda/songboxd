import { Component } from '@angular/core';
import { Spotify } from '../../services/spotify';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-search',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './search-component.html',
  styleUrls: ['./search-component.css']
})
export class SearchComponent {

  query = "";
  albums: any[] = [];

  constructor(private spotifyService: Spotify) {}

  search() {

    if (!this.query) return;

    this.spotifyService.searchAlbums(this.query)
      .subscribe((res: any) => {
        this.albums = res;
      });

  }

}