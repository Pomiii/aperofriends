import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BucketFormComponent } from './bucket-form.component';

describe('BucketFormComponent', () => {
  let component: BucketFormComponent;
  let fixture: ComponentFixture<BucketFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BucketFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BucketFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
