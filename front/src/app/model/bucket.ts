import {Item} from './item';
import {Friend} from './friend';

export class Bucket {

  friendList: Friend[] = [];
  bucket: Item[] = [];

  constructor(public idBucket: number,
              public date: string,
              public total: number) {}
}
