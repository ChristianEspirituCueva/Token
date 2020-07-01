import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './pages/admin/admin.component'
import { ClienteComponent } from './pages/cliente/cliente.component'
import { BonoComponent } from './pages/bono/bono.component'
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

const routes: Routes = [
  {path:'admin', component:AdminComponent},
  {path:'cliente', component:ClienteComponent},
  {path:'bono',component:BonoComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
