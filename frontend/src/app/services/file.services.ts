import { HttpClient, HttpEvent, HttpHeaders, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable, lastValueFrom } from 'rxjs';
import { File } from "../model/File";
import { FileSaverService } from 'ngx-filesaver'; 
import { FileContent } from "../model/FileContent";
import data from '../config/appConfig.json';

@Injectable()
export class FileServices {
    constructor(private httpClient: HttpClient,
        private fileSaverService: FileSaverService) {
        }
        
    public appConfig;
    public urlApi: string;

    public async getFiles(): Promise<Array<File>> {
        var url = data.apiHost + 'images'
        const files =  await this.httpClient.get<Array<File>>(url);
        return lastValueFrom<Array<File>>(files);
    }

    public getFileById(id: number)
    {
        var url = data.apiHost + 'images/'+id
        const downloadLink = document.createElement('a');
        downloadLink.href = url;
        downloadLink.click();
    }

    public async pushFileToStorage(file: FileContent): Promise<any> {
        const dataForm: FormData = new FormData();
        dataForm.append('file', file.Content);
        dataForm.append('name', file.Name);
        dataForm.append('description', file.Description);
        var url = data.apiHost  + 'images'
        var response = await this.httpClient.post(url, dataForm);
        return lastValueFrom<any>(response);
    }
}
