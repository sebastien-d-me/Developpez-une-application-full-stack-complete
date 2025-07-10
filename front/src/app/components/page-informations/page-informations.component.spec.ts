import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageInformationsComponent } from './page-informations.component';

describe('PageInformationsComponent', () => {
  let component: PageInformationsComponent;
  let fixture: ComponentFixture<PageInformationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PageInformationsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageInformationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
