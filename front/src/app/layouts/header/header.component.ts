import { Component } from '@angular/core';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
    isMemberMenu = false;

    constructor(private router: Router) {

        this.router.events.subscribe(() => {
            switch(this.router.url) {
                case "/":
                    this.isMemberMenu = false;
                    break;
                case "/register":
                    this.isMemberMenu = false;
                    break;
                case "/login":
                    this.isMemberMenu = false;
                    break;
                default:
                    this.isMemberMenu = true;
                    break;
            }
        });
    }
}
