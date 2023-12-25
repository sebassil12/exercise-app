import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators} from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginError:string = "";
  loginForm = this.formBuilder.group({
    username:['', Validators.required],
    password:['',Validators.required]

  })
  
  constructor(private formBuilder:FormBuilder, private router:Router){ }


  ngOnInit(): void {
  }

  get username(){
    return this.loginForm.controls.username;
  }

  get password(){
    return this.loginForm.controls.password;
  }

  login(){
    if(this.loginForm.valid){
      console.log("auth")
    }
    else{
      console.log("no auth")
    }
  }

}
