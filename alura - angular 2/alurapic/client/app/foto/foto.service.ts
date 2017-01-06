import { Http, Headers, Response } from '@angular/http';
import { FotoComponent } from './foto.component';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class FotoService {

    http: Http;
    headers: Headers;
    url: string = 'v1/fotos';

    constructor(http: Http){
        this.http = http;
        // cria uma instância de Headers
        this.headers = new Headers();
        // Adiciona o tipo de conteúdo application/json 
        this.headers.append('Content-Type', 'application/json');
    }

    cadastra(foto: FotoComponent): Observable<Response> {
        return this.http.post(this.url, JSON.stringify(foto), { headers: this.headers });
    }

    lista(): Observable<FotoComponent[]> {
        return this.http.get(this.url)
            .map(res => res.json());
    }

    remove(foto: FotoComponent){
        return this.http.delete(this.url + '/' + foto._id);
    }
}