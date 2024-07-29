import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ActivityDetailComponent } from './components/activity-detail/activity-detail.component';

export const routes: Routes = [

    { path:'dashboard', component:DashboardComponent },
    { path:'', redirectTo:'dashboard', pathMatch:'full' },
    { path:'*', redirectTo:'dashboard', pathMatch:'full' },
    { path:'activity/id', component: ActivityDetailComponent }
];
