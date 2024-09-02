import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { NavbarComponent } from './dashboard/navbar/navbar.component';
import { authGuard } from './guards/auth.guard';


export const routes: Routes = [

    { path: "login", component: LoginComponent },
    { path: "register", component: RegisterComponent },
    { path: "dashboard", component: NavbarComponent, canActivate: [authGuard] },
    { path: "", redirectTo: "/dashboard", pathMatch: "full" },
    { path: "**", redirectTo: "/dashboard", pathMatch: "full" }

];
