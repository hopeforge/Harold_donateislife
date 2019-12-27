import { BotModule } from './bot/bot.module';
import { CanaisModule } from './canais/canais.module';
import { CanaisComponent } from './canais/canais.component';
import { NgModule } from '@angular/core';
import { NbMenuModule } from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { ECommerceModule } from './e-commerce/e-commerce.module';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { TwitterModule } from './twitter/twitter.module';

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    DashboardModule,
    ECommerceModule,
    MiscellaneousModule,
    CanaisModule,
    TwitterModule,
    BotModule
  ],
  declarations: [
    PagesComponent,
  ],
})
export class PagesModule {
}
