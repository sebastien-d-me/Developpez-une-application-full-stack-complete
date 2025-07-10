import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-page-informations',
  standalone: true,
  imports: [],
  templateUrl: './page-informations.component.html',
  styleUrl: './page-informations.component.scss'
})
export class PageInformationsComponent {
    @Input() title = "";
}
