import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile/profile.service';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html',
  styleUrls: ['./http.component.css']
})
export class HttpComponent implements OnInit {

  user = {
    name: "morpheus",
    job: "leader"
  };
  createReponse: any;


  constructor(private profileService: ProfileService) { }

  ngOnInit(): void {
  }


  addUser() : void {
    let json : string =JSON.stringify(this.user);
    this.profileService.addUser(json).subscribe(
      data => {
        this.createReponse = data;

    })
  }
}
