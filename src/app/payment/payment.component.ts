import { Component, OnInit, createPlatformFactory } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Payment } from '../payment';
import { EnquiryService } from '../enquiry.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

  //declaration
  pay:Payment = new Payment();
  paymentForm:FormGroup;
  registrationId:number;
  submitted=false;
  
  constructor(private fb:FormBuilder,
              private enquiryServ:EnquiryService,
              private router:Router,
              private toastr:ToastrService,
              private route:ActivatedRoute) { }

  ngOnInit(){

    this.registrationId = this.route.snapshot.params['registrationId'];
    this.createForm();
  }

  createForm(){

    this.paymentForm = this.fb.group({

    registrationId:['',Validators.required],
    modeOfPayment:['',Validators.required],
    transactionId:['',Validators.required]

    });
  }

  onSubmit(){

    this.submitted=true;
    this.pay = new Payment();
    this.pay.registrationId = this.paymentForm.controls.registrationId.value;
    this.pay.modeOfPayment = this.paymentForm.controls.modeOfPayment.value;
    this.pay.transactionId = this.paymentForm.controls.transactionId.value;

    this.save();
    
  }

  save(){
    this.enquiryServ.addPayment(this.pay).subscribe(data => console.log(data),error => console.log(error));

    //toastr
    this.toastr.success('Payment Added' ,'Registration');
    //this.paymentForm.reset();
    this.gotoPhoto(this.registrationId);
  }

  gotoPhoto(registrationId:number){
    this.router.navigate(['registerComponent/mulQualification/payment/image',this.registrationId]);
  }

}
