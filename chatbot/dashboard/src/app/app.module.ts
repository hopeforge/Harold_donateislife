import { SmartTableService } from './@core/mock/smart-table.service';
import { BotService } from './../bot.service';
import { TwitterService } from './../twitter.service';
/**
 * @license
 * Copyright Akveo. All Rights Reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CoreModule } from './@core/core.module';
import { ThemeModule } from './@theme/theme.module';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {
  NbDatepickerModule,
  NbDialogModule,
  NbMenuModule,
  NbSidebarModule,
  NbToastrModule,
  NbWindowModule,
} from '@nebular/theme';
import { AuthGuard } from './@core/utils/auth-guard.service';
import { NbAuthModule } from './pages/auth/auth.module';
import { NbPasswordAuthStrategy, NbAuthJWTToken } from './pages/auth/public_api';
import { DashboardService } from '../dashboard.service';
import { PerfilService } from '../perfi.service';


const formSetting: any = {
  redirectDelay: 0,
  showMessages: {
    success: true,
  },
};

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,

    ThemeModule.forRoot(),

    NbSidebarModule.forRoot(),
    NbMenuModule.forRoot(),
    NbDatepickerModule.forRoot(),
    NbDialogModule.forRoot(),
    NbWindowModule.forRoot(),
    NbToastrModule.forRoot(),
    CoreModule.forRoot(),
    NbAuthModule.forRoot({
      strategies: [
        NbPasswordAuthStrategy.setup({
          name: 'email',
          token: {
            class: NbAuthJWTToken,
            key: 'token',
          },
          baseEndpoint: '',
              login: {
                endpoint: 'api/auth/login',
                method: 'post',
                redirect: {
                  success: '/dashboard/',
                  failure: null, // stay on the same page
                },
              },
              register: {
                endpoint: 'api/auth/register',
                redirect: {
                  success: '/welcome/',
                  failure: null, // stay on the same page
                },
              },
              logout: {
                endpoint: 'api/auth/logout',
                redirect: {
                  success: '/',
                  failure: null,
                },
                defaultErrors: ['Algo de errado, tente novamente.'],
                defaultMessages: ['Log out efetuado com sucesso.'],
              }
        }),
        
      ],
      forms: {
        login: formSetting,
           register: formSetting,
           requestPassword: formSetting,
           resetPassword: formSetting,
           logout: {
             redirectDelay: 0,
           },
      },
    }), 
  ],
  providers: [
    AuthGuard,
    TwitterService,
    BotService,
    SmartTableService,
    DashboardService,
    PerfilService
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
