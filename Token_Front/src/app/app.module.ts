import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { LoginComponent } from './pages/login/login.component';
import { BonoComponent } from './pages/bono/bono.component';
import { RegisterComponent } from './pages/register/register.component';
import { NosotrosComponent } from './pages/nosotros/nosotros.component';
import { DevelopersComponent } from './pages/developers/developers.component';
import { DetalleBonoComponent } from './pages/detalle-bono/detalle-bono.component';
import { HomeComponent } from './pages/home/home.component';

@NgModule({  
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    FormsModule
  ],
  providers: [
    { provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { appearance: 'fill' } },
  ],
  entryComponents: [AppComponent],
  declarations: [AppComponent, LoginComponent, BonoComponent, RegisterComponent, NosotrosComponent, DevelopersComponent, DetalleBonoComponent, HomeComponent],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
