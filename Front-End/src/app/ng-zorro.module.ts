import { NgModule } from '@angular/core';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzBreadCrumbModule } from 'ng-zorro-antd/breadcrumb';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzCheckboxModule } from 'ng-zorro-antd/checkbox';
import { NzDescriptionsModule } from 'ng-zorro-antd/descriptions';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzNotificationModule } from 'ng-zorro-antd/notification';
import { NzPageHeaderModule } from 'ng-zorro-antd/page-header';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzSpaceModule } from 'ng-zorro-antd/space';
import { NzTableModule } from 'ng-zorro-antd/table';

@NgModule({
  declarations: [],
  imports: [],
  exports:[
    NzLayoutModule,
    NzBreadCrumbModule,
    NzMenuModule,
    NzFormModule,
    NzInputModule,
    NzIconModule,
    NzCheckboxModule,
    NzButtonModule,
    NzNotificationModule,
    NzTableModule,
    NzPageHeaderModule,
    NzSpaceModule,
    NzDescriptionsModule,
    NzModalModule,
    NzSelectModule,
    NzAvatarModule
  ]
})
export class NgZorroModule { }
