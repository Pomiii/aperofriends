import {Item} from './item';
import {Friend} from './friend';

export class Bucket {

  buyerList: Friend[] = [];
  itemList: Item[] = []

  constructor(public idBucket: number) {}
}
