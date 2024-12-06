import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { enableProdMode } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';

if (process.env['NODE_ENV'] === 'production') {
  enableProdMode();
}

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes)  // Fornece as rotas para o aplicativo
  ]
}).catch(err => console.error(err));
