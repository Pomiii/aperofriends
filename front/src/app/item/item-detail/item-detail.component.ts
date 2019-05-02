import { Component, OnInit } from '@angular/core';
import {ItemService} from 'src/app/service/item.service';
import {Item} from 'src/app/model/item';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {

  id: number;
  editedItem: Item;
  itemList: Item[] = [];


  constructor(private itemService: ItemService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.itemService.getAllItem().subscribe(items => this.itemList = items);

    this.id = +this.route.snapshot.params.id;

    console.log('editedItem ' + this.editedItem);

    this.itemService.findItem(this.id).subscribe(item => {
      this.editedItem = item;
    })
  }

  // Vérifier si on est en édition ou en création
  onSave() {
    if (!this.id) {
      this.itemService.createItem(this.editedItem);
    } else {
      this.itemService.updateItem(this.editedItem);
    }
    this.router.navigate(['/item-detail']);
  }

}
