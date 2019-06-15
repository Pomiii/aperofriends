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

  availableItems: Item[] = [];
  editedItem: Item;
  itemList: BehaviorSubject<Item[]>;

  idItem: number;

  constructor(private itemService: ItemService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    // Permet d'afficher la liste des Friends
    this.itemService.publishItems();

    this.itemService.itemListSubject.subscribe(
      (res) => {
        this.availableItems = res;
        if (res !== null) {
        }
      }
    );

    this.itemList = this.itemService.availableItems$;

    this.idItem = +this.route.snapshot.params.idItem;

    // this.itemService.findItem(this.idItem).subscribe(item => {this.editedItem = item; });

  }

  onDelete(idItem: number) {
    console.log('availableFriends ???? ' + this.availableItems[0].idItem)
    this.availableItems.splice(this.availableItems.findIndex((itId) => itId.idItem === idItem), 1);
    this.itemService.deleteItem(idItem);
    this.router.navigate(['/item-detail']);
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
