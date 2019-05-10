import {TypeItem} from './typeItem';
import {BehaviorSubject} from 'rxjs';

export class Item {

  itemTab: BehaviorSubject<Item[]>;

  constructor(public idItem: number,
              public nameItem: string,
              public picItem: string,
              public typeItem: TypeItem,
              public priceItem: number) {}
}
