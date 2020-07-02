import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BonoComponent } from './pages/bono/bono.component'
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { NosotrosComponent } from './pages/nosotros/nosotros.component';
import { DevelopersComponent} from './pages/developers/developers.component'
import { DetalleBonoComponent } from './pages/detalle-bono/detalle-bono.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [  
  {path:'bono',component:BonoComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'nosotros',component:NosotrosComponent},
  {path:'developers',component:DevelopersComponent},
  {path:'detalleBono/:id',component:DetalleBonoComponent},
  {path:'home',component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
