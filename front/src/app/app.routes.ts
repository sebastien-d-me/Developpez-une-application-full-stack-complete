import { Routes } from '@angular/router';
import { RegisterComponent } from './pages/member/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/member/login/login.component';
import { DashboardComponent } from './pages/member/dashboard/dashboard.component';
import { ThemesListComponent } from './pages/themes/themes-list/themes-list.component';
import { CreateArticleComponent } from './pages/articles/create-article/create-article.component';
import { PageNotFoundComponent } from './pages/error/page-not-found/page-not-found.component';

export const routes: Routes = [
    { path: "", component: HomeComponent },
    { path: "register", component: RegisterComponent },
    { path: "login", component: LoginComponent },
    { path: "dashboard", component: DashboardComponent },
    { path: "themes", component: ThemesListComponent},
    { path: "articles/ajouter", component: CreateArticleComponent},
    { path: "**", component:PageNotFoundComponent }
];
