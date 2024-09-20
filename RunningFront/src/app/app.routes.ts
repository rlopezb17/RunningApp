import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { NavbarComponent } from './dashboard/navbar/navbar.component';
import { authGuard } from './guards/auth.guard';
import { ProfileComponent } from './dashboard/profile/profile.component';
import { DataComponent } from './dashboard/profile/data/data.component';


export const routes: Routes = [

    { path: "login", component: LoginComponent },
    { path: "register", component: RegisterComponent },
    { path: "", component: NavbarComponent, canActivate: [authGuard], children: [
        { path: "profile", component: ProfileComponent, children: [
            { path: "data/:id", component: DataComponent },
        ] }
    ] },
    { path: "**", redirectTo: "", pathMatch: "full" }

];
