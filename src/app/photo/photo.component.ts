import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { EnquiryService } from '../enquiry.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-photo',
  templateUrl: './photo.component.html',
  styleUrls: ['./photo.component.scss']
})
export class PhotoComponent implements OnInit {

  //for image upload
  public selectedFile;
  public event1;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;
  //for reg id
  registrationId:number;


  constructor(private httpClient:HttpClient,private route:ActivatedRoute,
              private enquirySer:EnquiryService,
              private router:Router,
              private toastr:ToastrService,
              private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.registrationId = this.route.snapshot.params['registrationId'];
  }

  //image uploading
  public  onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
  };

 }


 // This part is for uploading
 onUpload() {

  const uploadData = new FormData(); 
  //passing registrationId as json value
  uploadData.append('registrationId', JSON.stringify(this.registrationId));
  //uploadData.append('registrationId',this.registrationId);
  
  uploadData.append('myFile', this.selectedFile, this.selectedFile.name);
  

  this.httpClient.post('http://localhost:8081/check/upload/', uploadData)
  .subscribe(
               res => {console.log(res);
                       this.receivedImageData = res;
                       this.base64Data = this.receivedImageData.pic;
                       this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data;
                       this.toastr.success('Image Uploaded', 'Enquiry Management');
                       //this.toastr.error('Upload Failed, Try again!', 'Enquiry Management');
                      },
               err => {console.log('Error Occured during saving: ' + err);

            }
            );

            console.log("Completed");
            
            this.gotoHome();


 }

  gotoHome(){
    this.toastr.success('Registration Completed Successfully', 'Enquiry Management');
    
    this.router.navigate(['']);
  }

}
