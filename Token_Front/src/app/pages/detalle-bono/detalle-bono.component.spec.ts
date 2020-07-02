import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleBonoComponent } from './detalle-bono.component';

describe('DetalleBonoComponent', () => {
  let component: DetalleBonoComponent;
  let fixture: ComponentFixture<DetalleBonoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetalleBonoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleBonoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
