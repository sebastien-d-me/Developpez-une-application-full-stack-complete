import { Routes } from "@angular/router";
import { NotAuthGuard } from "./guards/not-auth.guard";
import { AuthGuard } from "./guards/auth.guard";
import { HomePage } from "./pages/home/home.component";
import { MemberRegisterPage } from "./pages/user/register/register.component";
import { MemberLoginPage } from "./pages/user/login/login.component";
import { MemberLogoutPage } from "./pages/user/logout/logout.component";
import { MemberFeedPage } from "./pages/user/feed/feed.component";
import { MemberProfilPage } from "./pages/user/profil/profil.component";
import { PostsAddPage } from "./pages/posts/add/add.component";
import { PostsViewPage } from "./pages/posts/view/view.component";
import { TopicsListPage } from "./pages/topics/list/list.component";
import { ErrorNotFoundPage } from "./pages/error/not-found/not-found.component";


export const routes: Routes = [
    { path: "", component: HomePage, canActivate: [NotAuthGuard] },
    { path: "user/register", component: MemberRegisterPage, canActivate: [NotAuthGuard] },
    { path: "user/login", component: MemberLoginPage, canActivate: [NotAuthGuard] },
    { path: "user/logout", component: MemberLogoutPage, canActivate: [AuthGuard] },
    { path: "user/feed", component: MemberFeedPage, canActivate: [AuthGuard] },
    { path: "user/profil", component: MemberProfilPage, canActivate: [AuthGuard] },
    { path: "posts/add", component: PostsAddPage, canActivate: [AuthGuard] },
    { path: "posts/:id", component: PostsViewPage, canActivate: [AuthGuard] },
    { path: "topics", component: TopicsListPage, canActivate: [AuthGuard] },
    { path: "404", component: ErrorNotFoundPage },
    { path: "**", redirectTo: "/404" }
];