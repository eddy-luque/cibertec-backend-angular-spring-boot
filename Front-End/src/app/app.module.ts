import * as AllIcons from '@ant-design/icons-angular/icons';

import { AccountBookFill, AlertFill, AlertOutline } from '@ant-design/icons-angular/icons';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { JWT_OPTIONS, JwtHelperService } from '@auth0/angular-jwt';
import { NZ_I18N, en_US } from 'ng-zorro-antd/i18n';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
// import { NZ_I18N, en_US } from 'ng-zorro-antd/i18n';
import { IconDefinition } from '@ant-design/icons-angular';
import { InterceptorsInterceptor } from './security/interceptors.interceptor';
import { NZ_ICONS } from 'ng-zorro-antd/icon';
import { NgModule } from '@angular/core';
import { NgZorroModule } from './ng-zorro.module';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { PagesModule } from './pages/pages.module';
import es from '@angular/common/locales/es';
import { es_ES } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';

const antDesignIcons = AllIcons as {
  [key: string]: IconDefinition;
};
const icons: IconDefinition[] = Object.keys(antDesignIcons).map(key => antDesignIcons[key])


registerLocaleData(es);

@NgModule({
  declarations: [AppComponent],
  imports: [
    PagesModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgZorroModule,
    FormsModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: es_ES },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorsInterceptor,
      multi: true,
    },
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
    { provide: NZ_I18N, useValue: en_US }, { provide: NZ_ICONS, useValue: icons }
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
