import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProjectRoutingModule} from "./project.routing.module";
import {ProjectComponent} from "./project.component";
import {ProjectService} from "../../services/Shared/project.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";



@NgModule({
  imports: [
    CommonModule,
    ProjectRoutingModule,
    NgxDatatableModule
  ],
  providers:[ProjectService],
  declarations: [ProjectComponent]


})
export class ProjectModule { }
