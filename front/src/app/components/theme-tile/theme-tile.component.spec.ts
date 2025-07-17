import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeTileComponent } from './theme-tile.component';

describe('ThemeTileComponent', () => {
  let component: ThemeTileComponent;
  let fixture: ComponentFixture<ThemeTileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemeTileComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemeTileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
