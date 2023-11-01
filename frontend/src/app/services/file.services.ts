import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from 'rxjs';
import { environment } from "src/enviroment/environment";
import { File } from "../model/File";
@Injectable()
export class FileServices {
    constructor(private httpClient: HttpClient) {}

    public async getFiles(): Promise<Array<File>> {
        var url = environment.apiUrl + 'images'
        console.log(url);
        const files =  await this.httpClient.get<Array<File>>(url);
        return lastValueFrom<Array<File>>(files);
    }

    public async upladFile(fileToUpload: any): Promise<boolean> {
        var url = environment + 'images'
        const files =  this.httpClient.post<boolean>(url, fileToUpload);
        return await lastValueFrom<boolean>(files);
    }
}