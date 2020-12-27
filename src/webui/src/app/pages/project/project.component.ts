import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProjectService} from "../../services/project.service";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ConfirmationComponent} from "../../shared/confirmation/confirmation.component";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  modalRef!: BsModalRef
  projectForm!:FormGroup;
  page = new Page();

  cols=[
    {prop:'id',name:'No'},
    {prop:'projectName',name:'Project Name', sortable:false},
    {prop:'projectCode',name:'Project Code',sortable: false},
  ]
  rows = [];

  constructor(private projectService: ProjectService,
              private modalService:BsModalService,
              private formBuilder:FormBuilder) {

  }

  ngOnInit() {

    this.setPage({offset: 0});

    this.projectForm =  this.formBuilder.group({
        'projectCode':[null,[Validators.required,Validators.minLength(2),Validators.maxLength(10)]],
        'projectName':[null,[Validators.required,Validators.minLength(4)]]

    });

  }

  get f() { return this.projectForm.controls }//arayüzdeki validatiınlara buradan erişecek


  saveProject(){
    if (!this.projectForm.valid){
      return;
    }

    this.projectService.createProject(this.projectForm.value).subscribe(
      response => {

        console.log(response);
        this.closeAndResetModal();
        this.setPage({offset: 0});


      }
    )
  }

  closeAndResetModal(){
    this.projectForm.reset();
    this.modalRef.hide();
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  setPage(pageInfo: any) {
    this.page.page = pageInfo.offset;
    this.projectService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.number;
      this.page.totalElements=pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }
  showDeleteConfimation(){
    const modal=this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation(
      'Test Header Content',
      'Test Body Content'
    );
    (<ConfirmationComponent>modal.content).onClose.subscribe(result=>{
      if (result===true){
        console.log("Yes")
      }else if (result===false){
        console.log(false);
      }
    })
}




}
