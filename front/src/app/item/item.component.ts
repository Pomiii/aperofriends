import { Component, OnInit } from '@angular/core';
import {Item} from '../model/item';
import {BehaviorSubject} from 'rxjs';
import {ItemService} from '../service/item.service';
import {TypeItemService} from '../service/typeItem.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  availableItems: Item[] = [];
  itemBucket: Item[] = [];
  itemList: Item[] = [];
  itemToAdd: Item;

  idItem: number;

  constructor(private itemService: ItemService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // Permet d'afficher la liste des Items
    this.itemService.getAllItem().subscribe(items => this.itemList = items);
    console.log('this.itemList ' + this.itemList);

    this.availableItems = this.itemService.availableItems;
    console.log('this.availableItems ' + this.availableItems);


    this.itemService.findItem(this.idItem).subscribe(item => {
      this.itemToAdd = item;
      this.itemBucket = item.itemList.slice();
      this.itemToAdd = this.itemBucket.pop();
    });
  }

  onAdd(){

  }
}
