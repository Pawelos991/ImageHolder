import { HttpClient, HttpEvent, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, lastValueFrom } from 'rxjs';
import { environment } from "src/enviroment/environment";
import { File } from "../model/File";
import { FileSaverService } from 'ngx-filesaver'; 

@Injectable()
export class FileServices {
    constructor(private httpClient: HttpClient,
        private fileSaverService: FileSaverService) {}

    public async getFiles(): Promise<Array<File>> {
        var url = environment.apiUrl + 'images'
        console.log(url);
        const files =  await this.httpClient.get<Array<File>>(url);
        return lastValueFrom<Array<File>>(files);
    }

    public getFileById(id: number)
    {
        var url = environment.apiUrl + 'images/'+id
        const downloadLink = document.createElement('a');
        downloadLink.href = url;
        downloadLink.click();
    }

    public async upladFile(fileToUpload: any): Promise<boolean> {
        var url = environment + 'images'
        const files =  this.httpClient.post<boolean>(url, fileToUpload);
        return await lastValueFrom<boolean>(files);
    }

    pushFileToStorage(file: File): Observable<HttpEvent<{}>> {
        const data: FormData = new FormData();
        //data.append('file', file);
        const newRequest = new HttpRequest('POST', 'http://localhost:8080/savefile', data, {
        reportProgress: true,
        responseType: 'text'
        });
        return this.httpClient.request(newRequest);
    }
}
