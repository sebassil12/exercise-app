import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, map, tap, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { LoginRequest } from './loginRequest';
import { environment } from 'src/app/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  //Para notificar cambios en el inicio de sesion y data del usuario
  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentUserData:BehaviorSubject<String> = new BehaviorSubject<String>("");
  
  constructor(private http:HttpClient) { 
    this.currentUserLoginOn = new BehaviorSubject<boolean>(sessionStorage.getItem("token")!=null);
    this.currentUserData = new BehaviorSubject<String>(sessionStorage.getItem("token")||"");
  }  
  
  login(credentials:LoginRequest):Observable<any>{
    return this.http.post<any>(environment.urlHost+"auth/login", credentials).pipe(
      tap((userData) =>{
        sessionStorage.setItem("token", userData.token);
        this.currentUserData.next(userData.token);
        this.currentUserLoginOn.next(true);
      }),
      map((userData) => userData.token),
      catchError(this.handleError)
    )
  }

  logout():void{
    sessionStorage.removeItem("token");
    this.currentUserLoginOn.next(false);
  }

  private handleError(error:HttpErrorResponse){
    if(error.status === 0){
      console.error("Error", error.error)
    }
    else{
      console.error("Error de backend", error);
    }
    return throwError(()=> new Error("Error inesperado intente nuevamente"))
  }

  get userData():Observable<String>{
    return this.currentUserData.asObservable();
  }

  get userLoginOn():Observable<boolean>{
    return this.currentUserLoginOn.asObservable();
  }

  get userToken():String{
    return this.currentUserData.value;
  }
  
}
