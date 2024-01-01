import { Component, ElementRef, ViewChild } from "@angular/core";
import { MatButtonModule } from "@angular/material/button";
import { MatDialogModule, MatDialogRef } from "@angular/material/dialog";
import { FileContent } from "../model/FileContent";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { FileServices } from "../services/file.services";
import { MatSnackBar, MatSnackBarModule, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from "@angular/material/snack-bar";
import { CommonModule } from "@angular/common";
import { BrowserModule } from '@angular/platform-browser';

@Component({
    selector: 'input-file-dialog',
    templateUrl: 'inputFileDialog.component.html',
    standalone: true,
    imports: [MatDialogModule, MatButtonModule,MatFormFieldModule, MatInputModule, 
      ReactiveFormsModule, MatSnackBarModule,CommonModule],
  })
  export class FileInputDialog  {
    constructor(private dialogRef: MatDialogRef<FileInputDialog>,
                private formBuilder: FormBuilder,
                private fileService: FileServices,
                private _snackBar: MatSnackBar) {
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
      if (this.formGroup.valid)
      {
        this.fileToUpload = new FileContent();
        this.fileToUpload.Content = this.selectedFiles[0];
        this.fileToUpload.Name = this.formGroup.controls['name'].value
        this.fileToUpload.Description = this.formGroup.controls['description'].value
        this.fileService.pushFileToStorage(this.fileToUpload).then(x => 
          this._snackBar.open("Pomyślnie dodano plik", '', {
            horizontalPosition: 'end',
            verticalPosition: 'top',
            duration: 3000,
          }));
          this.dialogRef.close();
      }
    }
  }