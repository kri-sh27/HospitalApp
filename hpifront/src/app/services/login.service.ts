import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './healper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }


// //Current User which is logged in
// public getCurrentUser():Observable<any>{
//   let userStr=localStorage.getItem("user"); 
//   return 
// }

  //generate token

  public generateToken(loginData:any):Observable<any>{
    return this.http.post(`${baseUrl}/authenticate`,loginData)
  }

  //login user=> setting token in local storage 

  public loginUser(token:any){
    localStorage.setItem('token',token);
    return true;
  }

  //islogin=> user is logged in or not
  public isLoggedIn(){
    let tokenStr=localStorage.getItem("token")
    if(tokenStr==undefined || tokenStr==''||tokenStr==null){
      return false;
    }else{
      return true;
    }
  }
  // Logout: remove token frm local storage
  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user')
    return true;
  }

  //get token
  public getToken(){
    return localStorage.getItem('token');
  }

  //set userDetail
  public setUser(user:any){
    localStorage.setItem("user",JSON.stringify(user));
    // console.log(user);
  }

  //getUser
  public getUser(){

    let userStr=localStorage.getItem("user"); 
    if(userStr!=null){
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }
  
  }


  //getUsrRole
  public getUserRole(){
    let user=this.getUser();
    return user.authorities[0].authority;
  }


  //current user:which isloggedin
  public getCurrentUser(){
    
   return this.http.get(`${baseUrl}/current-user`);
  }
    // public getCompleteUser(){
    //   let usr=this.getUser();
    //   let tokn=this.getToken();
    //   return {
    //     tokn:tokn,
    //     email:usr.email,
    //     password:usr.password
    //   }
      
    // }
}
