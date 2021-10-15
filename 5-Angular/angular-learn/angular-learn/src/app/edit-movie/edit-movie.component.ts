import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { movies } from '../data';
import { Movie } from '../movie/model/movie';

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.css']
})
export class EditMovieComponent implements OnInit {
  movie!: Movie;
  constructor(private route : ActivatedRoute) { }

  ngOnInit(): void {
    let id : any = this.route.snapshot.paramMap.get('id');
    for (let i = 0; i < movies.length; i++) {
      if (movies[i].id == id) {
        this.movie = movies[i];
      }
    }

  }

}
