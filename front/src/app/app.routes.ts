import { Routes } from "@angular/router";
import { HomePage } from "./pages/home/home.component";
import { MemberRegisterPage } from "./pages/user/register/register.component";
import { MemberLoginPage } from "./pages/user/login/login.component";
import { MemberFeedPage } from "./pages/user/feed/feed.component";
import { MemberProfilPage } from "./pages/user/profil/profil.component";
import { PostsAddPage } from "./pages/posts/add/add.component";
import { PostsViewPage } from "./pages/posts/view/view.component";
import { TopicsListPage } from "./pages/topics/list/list.component";
import { ErrorNotFoundPage } from "./pages/error/not-found/not-found.component";


export const routes: Routes = [
    { path: "", component: HomePage },
    { path: "user/register", component: MemberRegisterPage },
    { path: "user/login", component: MemberLoginPage },
    { path: "user/feed", component: MemberFeedPage },
    { path: "user/profil", component: MemberProfilPage },
    { path: "posts/add", component: PostsAddPage },
    { path: "posts/:id", component: PostsViewPage },
    { path: "topics", component: TopicsListPage },
    { path: "404", component: ErrorNotFoundPage },
    { path: "**", redirectTo: "/404" }
];