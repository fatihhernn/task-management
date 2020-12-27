import {Injectable} from "@angular/core";
import {ApiService} from "./api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Injectable({
  providedIn:'root'
})
export class  ProjectService{

  private PROJECT_PATH="/project";

  constructor(private apiService:ApiService) {
  }
// @ts-ignore
  getAll(page):Observable<any>{
    return this.apiService.get(this.PROJECT_PATH+'/pagination',page).pipe(map(
      res=>{
        if(res){
          return res;
        }
        else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  // @ts-ignore
  getById(id):Observable<any>{
    return this.apiService.get(this.PROJECT_PATH,id).pipe(map(
      res=>{
        if(res){
          return res;
        }
        else {
          console.log(res);
          return {};
        }
      }
    ));
  }

  // @ts-ignore
  createProject(project): Observable<any> {
    return this.apiService.post(this.PROJECT_PATH, project).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      })
    );
  }
  // @ts-ignore
  delete(id):Observable<any>{
    return this.apiService.delete(this.PROJECT_PATH,id).pipe(map(
      res=>{
        if(res){
          return res;
        }
        else {
          console.log(res);
          return {};
        }
      }
    ));
  }


}
