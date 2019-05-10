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
  editedItem = Item;
  itemList: BehaviorSubject<Item[]>;

  idItem: number;

  constructor(private itemService: ItemService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // Permet d'afficher la liste des Items
    this.itemService.publishItems();

    this.itemService.itemListSubject.subscribe(
      (res) => {
        this.availableItems = res;
        if (res !== null) {
          console.log('res ????' , res[2].typeItem);
        }
      }
    );

    this.itemList = this.itemService.availableItems$;

    this.availableItems = this.itemService.availableItems;

    this.idItem = +this.route.snapshot.params.idItem;
  }
}
