import { ExtraOptions, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { AuthGuard } from './@core/utils/auth-guard.service';
import { NbAuthComponent } from './pages/auth/components/auth.component';
import { NbLoginComponent } from './pages/auth/components/login/login.component';
import { NbRegisterComponent } from './pages/auth/components/register/register.component';
import { NbLogoutComponent } from './pages/auth/components/logout/logout.component';
import { NbRequestPasswordComponent } from './pages/auth/components/request-password/request-password.component';
import { NbResetPasswordComponent } from './pages/auth/components/reset-password/reset-password.component';

const routes: Routes = [
  {
    path: 'pages',
    canActivate: [AuthGuard], // here we tell Angular to check the access with our AuthGuard
    loadChildren: 'app/pages/pages.module#PagesModule' 
  },
  {
    path: 'auth',
    component: NbAuthComponent,
    children: [
      {
        path: '',
        component: NbLoginComponent,
      },
      {
        path: 'login',
        component: NbLoginComponent,
      },
      {
        path: 'register',
        component: NbRegisterComponent,
      },
      {
        path: 'logout',
        component: NbLogoutComponent,
      },
      {
        path: 'request-password',
        component: NbRequestPasswordComponent,
      },
      {
        path: 'reset-password',
        component: NbResetPasswordComponent,
      },
    ],
  },
  { path: '', redirectTo: 'pages', pathMatch: 'full' },
  { path: '**', redirectTo: 'pages' },
];

const config: ExtraOptions = {
  useHash: false,
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
