import { Component, OnInit } from '@angular/core';
import {BucketService} from '../../service/bucketService';
import {Bucket} from '../../model/bucket';
import {Router} from '@angular/router';

@Component({
  selector: 'app-bucket-account',
  templateUrl: './bucket-account.component.html',
  styleUrls: ['./bucket-account.component.css']
})
export class BucketAccountComponent implements OnInit {

  availableBuckets: Bucket[] = [];

  constructor(private bucketService: BucketService,
              private router: Router) { }

  ngOnInit() {
    this.bucketService.publishBuckets();

    this.bucketService.bucketListSubject.subscribe(
      (res) => {
        this.availableBuckets = res;
        if (res !== null) {
        }
      }
    );
  }

  onDelete(idBucket: number) {
    console.log('availableBuckets ???? ' + this.availableBuckets[0].idBucket);
    this.availableBuckets.splice(this.availableBuckets.findIndex((BuckId) => BuckId.idBucket === idBucket), 1);
    this.bucketService.deleteBucket(idBucket);
    this.router.navigate(['/bucket-account']);
  }

  onSave() {

  }

}
