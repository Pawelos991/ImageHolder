import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import {MatButtonModule} from '@angular/material/button';
import { MatTableModule } from "@angular/material/table";
import { FileServices } from "../services/file.services";
import { File } from "../model/File";

@Component({
    selector: 'content-viewer',
    templateUrl: './content.html',
  })
  export class ContentComponent implements  OnInit{
    constructor(private fileService: FileServices){}
  
    public fileList: Array<File> = new Array<File>();

    ngOnInit(): void {
       this.fileService.getFiles()
         .then(reponse => 
          {
            this.fileList = reponse;
            console.log(reponse);
          });
    }
    
    @ViewChild('fileUpload') fileUpload : ElementRef<HTMLInputElement>;
    @ViewChild('imageTableElement') imgtable : ElementRef<MatTableModule>;

    public displayedColumns: string[] = ["name","description","actions"] ;
    public onFileSelected(inputParams: any){
    }

    onFileUploadClick(){
        this.fileUpload.nativeElement.click();
    }

    getFileById(id: any){
      console.log(id);
    }
  }
  