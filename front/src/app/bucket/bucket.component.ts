import { Component, OnInit } from '@angular/core';
import {BucketService} from '../service/BucketService';

@Component({
  selector: 'app-bucket',
  templateUrl: './bucket.component.html',
  styleUrls: ['./bucket.component.css']
})
export class BucketComponent implements OnInit {

  constructor(private buckerService: BucketService) { }

  ngOnInit() {
  }

}
