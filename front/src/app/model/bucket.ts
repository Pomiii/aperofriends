import {Item} from './item';
import {Friend} from './friend';

export class Bucket {

<<<<<<< HEAD
  friendList: Friend[] = [];
  bucket: Item[] = [];

  constructor(public idBucket: number,
              public date: string,
              public total: number) {}
=======
  itemList: Item[] = [];

  constructor(public idBucket: number,
              public date : Date,
              public total : number) {}
>>>>>>> origin
}
