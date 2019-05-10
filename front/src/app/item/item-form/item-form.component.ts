import { Component, OnInit } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Item} from 'src/app/model/item';
import {ItemService} from 'src/app/service/item.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  editedItem: Item;
  id: number;

  constructor(private itemService: ItemService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.id = +this.route.snapshot.params.id;
    console.log('this.idItem ' + this.id);

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

  onAdd() {

  }

}
