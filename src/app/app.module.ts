import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MultiplequalificationComponent } from './multiplequalification/multiplequalification.component';
import { PaymentComponent } from './payment/payment.component';
import { RegisterlistComponent } from './registerlist/registerlist.component';
import { RegisterfollowupComponent } from './registerfollowup/registerfollowup.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { PhotoComponent } from './photo/photo.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    MultiplequalificationComponent,
    PaymentComponent,
    RegisterlistComponent,
    RegisterfollowupComponent,
    LoginComponent,
    PhotoComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    ToastrModule.forRoot({
      timeOut: 10000,
      positionClass: 'toast-bottom-right',
      preventDuplicates: true,
    }),
    BrowserAnimationsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
