import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Followregister } from '../followregister';
import { EnquiryService } from '../enquiry.service';
import { Observable } from 'rxjs';
import { Register } from '../register';
import { environment } from 'src/environments/environment';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-registerfollowup',
  templateUrl: './registerfollowup.component.html',
  styleUrls: ['./registerfollowup.component.scss']
})
export class RegisterfollowupComponent implements OnInit {

  registrationId:number;
  regFollowForm:FormGroup;
  followreg:Followregister = new Followregister();
  registers:Observable<Register[]>
  submitted = false;

  constructor(private route:ActivatedRoute,
              private fb:FormBuilder,
              private enquiryService:EnquiryService,
              private router:Router,
              private toastr:ToastrService) { }

  ngOnInit(): void {

    this.registrationId =this.route.snapshot.params['registrationId'];
    this.followUpR();

  }
  //adding follow up
  followUpR() {
    
    this.regFollowForm = this.fb.group({

      registrationId:['',Validators.required],
      examDate:['',Validators.required],
      resourceId:['',Validators.required]

    });

  }

  onSubmit(){
    this.submitted = true;
    this.followreg = new Followregister;
    this.followreg.registrationId = this.regFollowForm.controls.registrationId.value;
    this.followreg.examDate = this.regFollowForm.controls.examDate.value;
    this.followreg.resourceId = this.regFollowForm.controls.resourceId.value;

    this.save();
  }
  //private todate = new Date();

  save(){

    this.enquiryService.addFollowReg(this.followreg).subscribe(data => console.log(data),
    error => console.log(error));

    this.gotoStatus();
    
  }
  gotoStatus() {

    this.enquiryService.regStatusUpd(this.registrationId).subscribe(data => console.log(data),
    error => console.log(error));

   // this.enquiryService.regStatusUpd(this.registrationId);
    console.log("hello" +this.registrationId);

    this.toastr.success('follow up added and status updated', 'Enquiry Management');
    this.gotoList();
  }

  gotoList(){
    
    this.registers = this.enquiryService.listRegisters();
    this.router.navigate(['registerList']);
  }

  

}
