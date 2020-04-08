import { Component, OnInit } from '@angular/core';
import { Multiplequal } from '../multiplequal';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EnquiryService } from '../enquiry.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-multiplequalification',
  templateUrl: './multiplequalification.component.html',
  styleUrls: ['./multiplequalification.component.scss']
})
export class MultiplequalificationComponent implements OnInit {

  mulQual: Multiplequal = new Multiplequal();//ts(class)
  submitted = false;
  mulQualForm:FormGroup;
  registrationId:number;

  constructor(private fb:FormBuilder,
              private enquirySer:EnquiryService,
              private router:Router,
              private route:ActivatedRoute,
              private toastr:ToastrService) { }

  ngOnInit(){
    //passing id 
    this.registrationId =this.route.snapshot.params['registrationId'];
    this.createForm();
  }
 
  createForm() {
    this.mulQualForm = this.fb.group({
     
    qualificationId:['',Validators.required],
    registrationId:['',Validators.required],
    mark:['',Validators.required],
    yearOfPass:['',Validators.required],
    institution:['',Validators.required]
    });
    console.log("testing... validator inside ");
    
  }

  onSubmitQual(){
    console.log("inside on submit..");
    this.submitted=true;
    this.mulQual = new Multiplequal();

    this.mulQual.qualificationId = this.mulQualForm.controls.qualificationId.value;
    this.mulQual.mark = this.mulQualForm.controls.mark.value;
    this.mulQual.registrationId = this.mulQualForm.controls.registrationId.value;
    this.mulQual.yearOfPass = this.mulQualForm.controls.yearOfPass.value;
    this.mulQual.institution = this.mulQualForm.controls.institution.value;

    this.save();
  }

  save(){

    this.enquirySer.createMulQuals(this.mulQual)
   .subscribe(data => console.log(data), error => console.log(error));

   //reset form values
    this.mulQualForm.controls.qualificationId.reset();
    this.mulQualForm.controls.mark.reset();
    this.mulQualForm.controls.yearOfPass.reset();
    this.mulQualForm.controls.institution.reset();
    //toastr
    this.toastr.success('if you want to add another qualification,enter again & add','Registration');
    this.gotoAgainMulQual(this.registrationId);
   
  }
  gotoAgainMulQual(registrationId:number){
    //this.router.navigate(['mulQualification',this.registrationId]);
    this.router.navigate(['registerComponent/mulQualification/',registrationId]); 
  }

  gotoPayment(registrationId:number){
    this.router.navigate(['registerComponent/mulQualification/payment/',registrationId]);
  }

}
