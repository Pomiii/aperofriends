import {Item} from './item';
import {Friend} from './friend';

export class Bucket {

  itemList: Item[] = [];

  constructor(public idBucket?: number,
              public nameBucket?: string,
              public date?: Date,
              public total?: number,
              public friend?: Friend,
              public event?: string,
              public address?: string,
              public phone?: string) {}
}
