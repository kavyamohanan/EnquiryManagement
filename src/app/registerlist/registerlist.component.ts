import { Component, OnInit } from '@angular/core';
import { EnquiryService } from '../enquiry.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Register } from '../register';
import { FormGroup } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-registerlist',
  templateUrl: './registerlist.component.html',
  styleUrls: ['./registerlist.component.scss']
})
export class RegisterlistComponent implements OnInit {

  p:number = 1;
  registers:Observable<Register[]>
  registrationDate:Date;  //searchReg:FormGroup;

  constructor(private enquiryService:EnquiryService,
              private router:Router,
              private auth:AuthService) { }

  ngOnInit() {

    this.reloadData();
    
  }

  //listing registers list
  reloadData() {
    this.registers = this.enquiryService.listRegisters();
  }

  registerFollowUp(registrationId:number){
    this.router.navigate(['registerList/regFollowUp',registrationId]);
    console.log(registrationId);
  }

  onSearch(){
    this.registers = this.enquiryService.searchByDate(this.registrationDate);  
  }

  //logout
  logout(){
    
    this.auth.logout();
    this.router.navigateByUrl('/login');

  }


}
