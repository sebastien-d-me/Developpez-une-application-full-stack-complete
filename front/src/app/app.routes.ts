import { Routes } from "@angular/router";
import { HomePage } from "./pages/home/home.component";
import { MemberRegisterPage } from "./pages/member/register/register.component";
import { MemberLoginPage } from "./pages/member/login/login.component";
import { MemberDashboardPage } from "./pages/member/dashboard/dashboard.component";
import { MemberProfilPage } from "./pages/member/profil/profil.component";
import { ArticleViewPage } from "./pages/articles/view/view.component";
import { ArticlesAddPage } from "./pages/articles/add/add.component";
import { ThemesListPage } from "./pages/themes/list/list.component";
import { ErrorNotFoundPage } from "./pages/error/not-found/not-found.component";


export const routes: Routes = [
    { path: "", component: HomePage },
    { path: "member/register", component: MemberRegisterPage },
    { path: "member/login", component: MemberLoginPage },
    { path: "member/dashboard", component: MemberDashboardPage },
    { path: "member/profil", component: MemberProfilPage },
    { path: "articles/:id", component: ArticleViewPage },
    { path: "articles/add", component: ArticlesAddPage },
    { path: "themes", component: ThemesListPage },
    { path: "**", component: ErrorNotFoundPage }
];