import { Component, OnInit } from '@angular/core';
import {BucketService} from '../service/bucketService';
import {BehaviorSubject} from 'rxjs';
import {Bucket} from '../model/bucket';

@Component({
  selector: 'app-bucket',
  templateUrl: './bucket.component.html',
  styleUrls: ['./bucket.component.css']
})
export class BucketComponent implements OnInit {

  availableBuckets: Bucket[] = [];
  editedBucket: Bucket;
  bucketList: BehaviorSubject<Bucket[]>;

  constructor(private bucketService: BucketService) { }

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

    this.bucketList = this.bucketService.availableBuckets$;

    this.availableBuckets = this.bucketService.availableBuckets;
  }

  onDelete() {

  }

  onPay() {
  }
}
