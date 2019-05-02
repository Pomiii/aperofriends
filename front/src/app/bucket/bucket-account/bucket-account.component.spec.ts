import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BucketAccountComponent } from './bucket-account.component';

describe('BucketAccountComponent', () => {
  let component: BucketAccountComponent;
  let fixture: ComponentFixture<BucketAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BucketAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BucketAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
