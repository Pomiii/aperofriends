import {TypeItem} from './typeItem';

export class Item {

  idItem: number;

  constructor(public nameItem?: string,
              public picItem?: string,
              public typeItem?: TypeItem,
              public priceItem?: number) {}

}
