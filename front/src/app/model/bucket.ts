import {Item} from './item';
import {Friend} from './friend';

export class Bucket {

  itemList: Item[] = [];

  constructor(public idBucket: number,
              public date : Date,
              public total : number) {}
}
