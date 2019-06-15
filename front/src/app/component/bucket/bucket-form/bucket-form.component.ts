import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {LoginService} from '../../../service/login.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BucketService} from '../../../service/bucketService';
import {Bucket} from '../../../model/bucket';
import {Friend} from '../../../model/friend';

@Component({
  selector: 'app-bucket-form',
  templateUrl: './bucket-form.component.html',
  styleUrls: ['./bucket-form.component.css']
})
export class BucketFormComponent implements OnInit {

  bucketForm = this.fb.group({
    nameBucket: [null, Validators.required],
    event: [null, Validators.required],
    address: [null, Validators.required],
    phone: [null, Validators.required]
  });

  //bucketExistForm = this.fb.group()

  availableBuckets: Bucket[] = [];

  bucketCreated = false;

  newBucket = Bucket;

  id: number;

  constructor(private bucketService: BucketService,
              private loginService: LoginService,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // Permet d'afficher la liste des Friends
    this.bucketService.publishBuckets();

    this.bucketService.bucketListSubject.subscribe(
      (res) => {
        this.availableBuckets = res;
        if (res !== null) {
        }
      }
    );

  }

  onSubmit() {
      const bucket = new Bucket(0, '', new Date() , 0, new Friend(), '', '', '');
      bucket.nameBucket = this.bucketForm.value.nameBucket;
      bucket.event = this.bucketForm.value.event;
      bucket.address = this.bucketForm.value.address;
      bucket.phone = this.bucketForm.value.phone;
      this.bucketService.createBucket(bucket);
      this.bucketCreated = true;
      console.log('Create new Bucket = ', bucket.nameBucket);

    // Pour laisser le temps de charger les données
    setTimeout(() => this.router.navigate(['']), 300);

  }

  onSelect(idBucket : number) {
    this.bucketService.findBucket(idBucket);
    console.log('Select Bucket id Bucket : ' + idBucket);
  }

}
