import { Component, ElementRef, ViewChild } from "@angular/core";
import {MatButtonModule} from '@angular/material/button';
import { MatTableModule } from "@angular/material/table";

@Component({
    selector: 'content-viewer',
    templateUrl: './content.html',
  })
  export class ContentComponent {
    @ViewChild('fileUpload') fileUpload : ElementRef<HTMLInputElement>;
    @ViewChild('imageTableElement') imgtable : ElementRef<MatTableModule>;

    public imageSource: any;
    public displayedColumns: string[];
    public onFileSelected(inputParams: any){
        console.log(inputParams)
    }

    onFileUploadClick(){
        console.log(this.fileUpload)
        this.fileUpload.nativeElement.click();
    }
  }
  