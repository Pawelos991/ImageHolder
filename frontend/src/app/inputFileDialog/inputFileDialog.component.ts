import { Component, ElementRef, ViewChild } from "@angular/core";
import { MatButtonModule } from "@angular/material/button";
import { MatDialogModule, MatDialogRef } from "@angular/material/dialog";
import { FileContent } from "../model/FileContent";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";

@Component({
    selector: 'input-file-dialog',
    templateUrl: 'inputFileDialog.component.html',
    standalone: true,
    imports: [MatDialogModule, MatButtonModule,MatFormFieldModule, MatInputModule,ReactiveFormsModule],
  })
  export class FileInputDialog  {
    constructor(public dialogRef: MatDialogRef<FileInputDialog>,
                private formBuilder: FormBuilder) {
        dialogRef.disableClose = true;
    }

    ngOnInit() {
      this.createForm();
    }

    public inputValue : string;
    public fileToUpload: FileContent;

    @ViewChild('fileUpload') fileUpload : ElementRef<HTMLInputElement>;
    public selectedFiles: FileList;
    public formGroup: FormGroup;

    createForm() {
      this.formGroup = this.formBuilder.group({
        'name': [null, Validators.required],
        'description': [null, Validators.required],
        'file': [null, Validators.required]
      });
    }

    closeDialog() {
        this.dialogRef.close();
    }
    
    onFileUploadClick(){
        this.fileUpload.nativeElement.click();
    }

    public onFileSelected(event: any){
        this.selectedFiles = event.target.files;
      }

    sendFile(event){
      console.log(event);
    }
  }