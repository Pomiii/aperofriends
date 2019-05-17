import { Component, OnInit } from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Item} from 'src/app/model/item';
import {ItemService} from 'src/app/service/item.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Friend} from '../../model/friend';
import {TypeItem} from '../../model/typeItem';
import {TypeItemService} from '../../service/typeItem.service';
import {UploadFileService} from '../../service/uploadFileService';
import {HttpEventType, HttpResponse} from '@angular/common/http';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
})
export class ItemFormComponent implements OnInit {

  itemList: BehaviorSubject<Item[]>;
  editItem: boolean;
  availableItems: Item[] = [];
  editedItem: Item;

  typeItemList: BehaviorSubject<TypeItem[]>;
  availableTypeItems: TypeItem[] = [];

  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  id: number;
  nameTypeItem: string;

  constructor(private itemService: ItemService,
              private typeItemService: TypeItemService,
              private uploadService: UploadFileService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.itemList = this.itemService.availableItems$;

    this.availableItems = this.itemService.availableItems;

    this.id = +this.route.snapshot.params.id;
    console.log('this.idItem ' + this.id);

    this.itemService.findItem(this.id).subscribe(item => {
      this.editedItem = item;
    });

    // Permet d'afficher la liste des TypeItems
    this.typeItemService.publishTypeItems();

    this.typeItemService.typeItemListSubject.subscribe(
      (res) => {
        this.availableTypeItems = res;
        if (res !== null) {
        }
      }
    );

    this.typeItemList = this.typeItemService.availableTypeItems$;

    this.availableTypeItems = this.typeItemService.availableTypeItems;
    console.log('Item Form availableTypeItems ' + this.availableTypeItems);

    if (!this.id) {
      this.editItem = true;
      this.editedItem = new Item('', '', new TypeItem(0, ''), 0);
    } else {
      this.editedItem = this.itemService.availableItems.find((it => it.idItem === this.id));
      this.editItem = false;
    }

    this.editedItem.typeItem.nameTypeItem = 'alcool';
  }

  // Vérifie si on est en édition ou en création
  onSave() {
    const newItem = new Item(this.editedItem.nameItem, this.editedItem.picItem, this.editedItem.typeItem, this.editedItem.priceItem)
    this.itemService.createItem(newItem, this.editedItem.typeItem.nameTypeItem);
    return;

    // charge le fichier
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });

    this.selectedFiles = undefined;

    // Pour laisser le temps de charger les données
    setTimeout(() => this.router.navigate(['/item-detail']), 300);

  }

  // Partie UploadFile
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

}
