import {TypeItem} from './typeItem';

export class Item {

  itemTab: Item[];
  idItem: number;

  constructor(public nameItem: string,
              public picItem: string,
              public typeItem: TypeItem,
              public priceItem: number) {}
}
