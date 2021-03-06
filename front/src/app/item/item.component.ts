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
  itemList: BehaviorSubject<Item[]>;

  bucketItem: Item[] = [];
  itemToAdd: Item;

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
        }
      }
    );

    this.itemList = this.itemService.availableItems$;

    this.availableItems = this.itemService.availableItems;

    this.idItem = +this.route.snapshot.params.idItem;

    // Partie d'ajout d'item dans un bucket
    this.itemService.findItem(+this.route.snapshot.params.idItem).subscribe(itemList => {
      console.log('Init ajout panier ', this.itemList);
    });
  }

  onAdd(id: number) {
    this.router.navigate(['/item']);
  }

  julo(pathImage: string) {
    let bananaSplit;
    if (pathImage.indexOf('/') > -1) {
      bananaSplit = pathImage.split('/');
    } else {
      bananaSplit = pathImage.split('\\');
    }
    return bananaSplit[bananaSplit.length - 1];
  }

  julo1(pathImage: string) {
    return 'assets/images/' + this.julo(pathImage);
  }

}
