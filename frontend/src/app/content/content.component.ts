import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import {MatButtonModule} from '@angular/material/button';
import {MatDialog, MatDialogRef, MatDialogModule} from '@angular/material/dialog';
import { MatTableDataSource, MatTableModule } from "@angular/material/table";
import { FileServices } from "../services/file.services";
import { File } from "../model/File";
import { take } from "rxjs/operators";
import { FileInputDialog } from "../inputFileDialog/inputFileDialog.component";
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';

@Component({
    selector: 'content-viewer',
    templateUrl: './content.html',
  })
  export class ContentComponent implements  OnInit{
    constructor(
      private fileService: FileServices,
      public dialog: MatDialog){}
  
    public fileList: Array<File> = new Array<File>();
    dataSource = new MatTableDataSource<File>();

    ngOnInit(): void {
       this.fileService.getFiles().then(reponse => { 
        this.dataSource = new MatTableDataSource<File>(reponse); 
        this.dataSource.paginator = this.paginator;
      });
    }
  

    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild('imageTableElement') imgtable : ElementRef<MatTableModule>;

    public displayedColumns: string[] = ["name","description","actions"] ;

    getFileById(elementToSave: any){
      this.fileService.getFileById(elementToSave.id);
    }

    openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
      let dialogRef = this.dialog.open(FileInputDialog , {
        width: '700px',
        disableClose: true 
      });

      
    dialogRef.afterClosed().subscribe(result => {
      this.fileService.getFiles().then(reponse => { 
        this.dataSource = new MatTableDataSource<File>(reponse); 
        this.dataSource.paginator = this.paginator;
      });
    });
    }
  }
  