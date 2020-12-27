import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProjectRoutingModule} from "./project.routing.module";
import {ProjectComponent} from "./project.component";
import {ProjectService} from "../../services/project.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {SharedModule} from "../../shared/shared.module";
import {BsModalService} from "ngx-bootstrap";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
    imports: [
        CommonModule,
        ProjectRoutingModule,
        NgxDatatableModule,
        SharedModule,
        ReactiveFormsModule
    ],
  providers:[ProjectService,BsModalService],
  declarations: [ProjectComponent]


})
export class ProjectModule { }
