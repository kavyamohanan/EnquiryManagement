import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Coordinator } from './coordinator';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private httpClient: HttpClient, private router: Router) { }

  login(logindata: Coordinator) {
    localStorage.setItem('ACCESS_TOKEN', "access_token");
    localStorage.setItem('Username', "userInfo.userName");

    return this.httpClient.get<Coordinator>(environment.apiUrl + 'login/' + logindata.username + '&' + logindata.password);

  }


  public logout() {
    localStorage.removeItem('ACCESS_TOKEN');
    localStorage.removeItem('Username');
  }

  //calling from authguard
  public isLoggedIn() {
    if (localStorage.getItem('ACCESS_TOKEN') == null) {
      this.router.navigateByUrl('/login');
    }
    else {
      return localStorage.getItem('ACCESS_TOKEN') !== null;
    }

  }

}



