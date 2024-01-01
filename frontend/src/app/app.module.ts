import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContentComponent } from './content/content.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import { FileServices } from './services/file.services';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule, MatLabel} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { FileInputDialog } from './inputFileDialog/inputFileDialog.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { CommonModule, NgIf } from '@angular/common';
import { MatPaginatorModule } from '@angular/material/paginator';
import { APP_INITIALIZER } from '@angular/core';
import { Observable, tap } from 'rxjs';


@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatButtonModule,
    MatTableModule,
    HttpClientModule,
    NgbModule,
    MatDialogModule,
    MatInputModule,    
    FileInputDialog,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSnackBarModule,
    CommonModule,
    NgIf,
    MatPaginatorModule,
  ],
  providers: [
    FileServices,
    MatDialog,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
