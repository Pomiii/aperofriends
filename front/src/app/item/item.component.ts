import { Component, OnInit } from '@angular/core';
import {Item} from '../model/item';
import {BehaviorSubject} from 'rxjs';
import {ItemService} from '../service/item.service';
import {TypeItemService} from '../service/typeItem.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BucketService} from '../service/bucketService';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  itemToAdd: Item;
  FriendBucket: Item[] = [];
  itemList: BehaviorSubject<Item[]>;
  availableItems: Item[] = [];

  constructor(private itemService: ItemService,
              private bucketService: BucketService,
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
    console.log('this.itemList : ' + this.itemList)

    this.availableItems = this.itemService.availableItems;

    // Partie d'ajout d'item dans un bucket
    this.itemService.findItem(+this.route.snapshot.params.idItem).subscribe(itemToAdd => {
      // this.item = bucket.itemList.slice();
      this.itemToAdd = this.FriendBucket.pop();
      console.log('this.itemToAdd : ' + this.itemToAdd);
    });
  }

  onAdd() {
    // const itemName = new Item(this.itemToAdd.nameItem)
    console.log('Item Selected: ' + this.itemToAdd);
    // Ici je pousse l'article  dans le panier

    // this.bucketService.itemList.push(this.itemToAdd);
    // this.router.navigate(['/item']);
  }

  // Gestion du chemin pour le fichier uploadé
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
