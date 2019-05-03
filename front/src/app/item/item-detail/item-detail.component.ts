import { Component, OnInit } from '@angular/core';
import {ItemService} from 'src/app/service/item.service';
import {Item} from 'src/app/model/item';
import {Router, ActivatedRoute} from '@angular/router';
import {BehaviorSubject} from 'rxjs';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {

  itemList: Item[];

  idItem: number;

  constructor(private itemService: ItemService) { }

  ngOnInit() {
    this.itemService.getAllItem().subscribe(items => this.itemList = items);
  }

}
