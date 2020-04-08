import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Coordinator } from '../coordinator';
import { LocationStrategy } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  isSubmitted = false;
  coordinator: Coordinator;

  constructor(private formBuilder: FormBuilder,
    private locationStrategy: LocationStrategy,
    private router: Router,
    private auth: AuthService) {

    //preventing back button in browser
    history.pushState(null, null, window.location.href);

    this.locationStrategy.onPopState(() => {
      history.pushState(null, null, window.location.href);
    });

  }

  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({

      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  get formControls() {
    return this.loginForm.controls;
  }

  //button ng submit action
  onLogin() {

    this.isSubmitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    if (this.loginForm.valid) {
      //alert('User form is valid!!')

      //////
      this.auth.login(this.loginForm.value)
        .subscribe(data => {
          this.coordinator = data;
          console.log(data.username);
          /////


          if (data.username != null) {
            this.isSubmitted = true;
            localStorage.setItem('ACCESS_TOKEN', "access_token");
            localStorage.setItem('Username', data.username);

            this.router.navigateByUrl("registerList");

          }
          else {
            window.alert("Wrong username or password");
          }
        }, (error) => {
          console.log(error);
          window.alert("Wrong username or password");
        }
        );
    } else {
      alert('User form is not valid!!')
      return;

    }

  }
//preventing push back
// Define a function to handle back button and use anywhere
preventBackButton() {
  history.pushState(null, null, location.href);
  this.locationStrategy.onPopState(() => {
    history.pushState(null, null, location.href);
  })
}
}




