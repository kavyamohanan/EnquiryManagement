import { Component, OnInit } from '@angular/core';
import { Register } from '../register';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EnquiryService } from '../enquiry.service';
import { Observable } from 'rxjs';
import { ToastrService } from 'ngx-toastr';
import { Course } from '../course';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  register: Register = new Register();
  submitted = false;
  registerForm: FormGroup;
  registrationId: number;
  //private disableButton: boolean = false;
  
  

  data: any;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private enquiryService: EnquiryService,
    private toastr: ToastrService
  ) { }

  ngOnInit() {
    this.createForm();
  }
  createForm() {

    this.registerForm = this.formBuilder.group({

      registrationId: ['', Validators.required],
      name: ['', Validators.required, Validators.pattern['^[a-zA-Z ]{3,30}$']],
      address: ['', Validators.required],
      district: ['', Validators.required],
      state: ['', Validators.required],
      pincode: ['', Validators.required],
      nationality: ['', Validators.required],
      phone: ['', Validators.required],
      gender: ['', Validators.required],
      dob: ['', Validators.required],
      email: ['', Validators.required, Validators.email],
      courseId: ['', Validators.required]
      // photo:['',Validators.required]
    })
  }

  onSubmit() {
   // this.submitted = true; 
    //this.disableButton=true;
     // disable form after 1s
     setTimeout(() => this.registerForm.disable());
     // enable the form after 4s
     setTimeout(() => this.registerForm.enable(), 2000);
    this.register = new Register();
    this.register.name = this.registerForm.controls.name.value;
    this.register.address = this.registerForm.controls.address.value;
    this.register.district = this.registerForm.controls.district.value;
    this.register.state = this.registerForm.controls.state.value;
    this.register.pincode = this.registerForm.controls.pincode.value;
    this.register.nationality = this.registerForm.controls.nationality.value;
    this.register.phone = this.registerForm.controls.phone.value;
    this.register.gender = this.registerForm.controls.gender.value;
    this.register.dob = this.registerForm.controls.dob.value;
    this.register.email = this.registerForm.controls.email.value;
    this.register.courseId = this.registerForm.controls.courseId.value;

    //this.register.photo = this.registerForm.controls.phone.value;

    this.save();

  }

  save() {
    


    /*this.enquiryService.registerAdd(this.register)
    .subscribe(data => { this.data = data, console.log(data) }, error => console.log(error));*/



    //console.log(this.register.registrationId);

    /* this.registerForm.controls.name.reset();
     this.registerForm.controls.state.reset();
     this.registerForm.controls.address.reset();
     this.registerForm.controls.pincode.reset();*/

     this.enquiryService.registerAdd(this.register)
    .subscribe(data => { this.data = data;

      
      console.log(data);
      this.registrationId = this.data.registrationId;
      this.router.navigate(['registerComponent/mulQualification/', this.registrationId]);

      
    this.toastr.success('Personal Details Added Successfully', 'Registration');

  }, error => console.log(error));
    //this.enquiryService.registerAdd(this.register).subscribe(data => console.log(data), error => console.log(error));

    //this.registrationId = this.data.registrationId;
    //console.log("after subscribing "+this.registrationId);

    //-----this.gotoQualification(this.data.registrationId);


   



  /*}
  gotoQualification(registrationId: number) {
    this.router.navigate(['registerComponent/mulQualification/', registrationId]);
    //this.router.navigate(['mulQualification']);    
  }
*/

  }
  
  //drop down box autogenerate from course
 /* courses:Course = new Course();
  getCourseName() : void{

    this.enquiryService.getCourses().subscribe((response)=>{

      ()
       
    })

  }*/


}
