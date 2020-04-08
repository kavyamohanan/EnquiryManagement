import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Register } from './register';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Followregister } from './followregister';
import { Multiplequal } from './multiplequal';
import { Payment } from './payment';

@Injectable({
  providedIn: 'root'
})
export class EnquiryService {
 

  constructor(private router:Router,
              private http : HttpClient) { }

  //adding registration details
  public registerAdd(reg:Object):Observable<any>{

      return this.http.post<Register>(environment.apiUrl+"register",reg);
  }

  //listing registers
  public listRegisters(): Observable<any> {
    return this.http.get(environment.apiUrl+"registers");   

  }

  //adding registration follow ups
  public addFollowReg(flreg:Object):Observable<any> {
    return this.http.post<Followregister>(environment.apiUrl+"followupregister",flreg)
  }

  //status updating as informed
  public regStatusUpd(registrationId:number):Observable<any> {
    console.log("inside service+++");
    return this.http.put(environment.apiUrl+"status/"+registrationId,'');
  }

  //search
  public searchByDate(registrationDate:Date): Observable<any> {
    return this.http.get(environment.apiUrl+"registers/"+registrationDate);
  }

  //add multiple qualifications
  public createMulQuals(mulQual:Object):Observable<any>{
    return this.http.post<Multiplequal>(environment.apiUrl+"mulqualification",mulQual);
  }

  //addpayment
  public addPayment(pay:Object):Observable<any>{

    return this.http.post<Payment>(environment.apiUrl+"payment",pay);
}

//reg id adding to photo table
public photoIdUpd(registrationId: number):Observable<any> {
  
  return this.http.put(environment.apiUrl+"/check/photo/"+registrationId,'');
}


}
