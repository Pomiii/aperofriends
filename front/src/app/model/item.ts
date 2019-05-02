import {TypeItem} from './typeItem';

export class Item {

  itemList: Item[] = [];

  constructor(public idItem: number,
              public nameItem: string,
              public typeItem: string,
              public priceItem: number) {}
}
