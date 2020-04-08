import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { MultiplequalificationComponent } from './multiplequalification/multiplequalification.component';
import { PaymentComponent } from './payment/payment.component';
import { RegisterlistComponent } from './registerlist/registerlist.component';
import { RegisterfollowupComponent } from './registerfollowup/registerfollowup.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';
import { PhotoComponent } from './photo/photo.component';



const routes: Routes = [
{path:'registerComponent',component:RegisterComponent},
{path:'registerComponent/mulQualification/:registrationId',component:MultiplequalificationComponent},
{path:'registerComponent/mulQualification/payment/:registrationId',component:PaymentComponent},
{path:'registerList',component:RegisterlistComponent,canActivate:[AuthGuard]},
{path:'registerList/regFollowUp/:registrationId',component:RegisterfollowupComponent},
{path:'login',component:LoginComponent},
{path:'registerComponent/mulQualification/payment/image/:registrationId',component:PhotoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
