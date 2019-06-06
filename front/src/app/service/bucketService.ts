import {BehaviorSubject, Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Injectable} from '@angular/core';
import {Bucket} from '../model/bucket';
import {environment} from '../../environments/environment';
import {Item} from '../model/item';
import {Friend} from '../model/friend';

@Injectable ({
  providedIn: 'root'
})

export class BucketService {

  bucketFriend: Bucket;

  // la liste des buckets
  availableBuckets: Bucket[];

  // la liste observable que l'on rend visible partout dans l'appli
  availableBuckets$: BehaviorSubject<Bucket[]> = new BehaviorSubject(this.availableBuckets);

  constructor(private httpClient: HttpClient) {

  }

  public bucketListSubject: BehaviorSubject<Bucket[]> = new BehaviorSubject(null);

  public setBucketListSubject(value: Bucket[]) {
    if (value) {
      this.bucketListSubject.next(value);
    } else {
      this.bucketListSubject.next(null);
    }
  }

  public bucketItemsSubject: BehaviorSubject<Item[]> = new BehaviorSubject(null);

  public setbucketItemsSubject(value: Item[]){
    if (value) {
      this.bucketItemsSubject.next(value);
    } else {
      this.bucketItemsSubject.next(null);
    }
  }

  /**
   * La fonction getAllBucket() est privée car elle n'a besoin d'être appellée que dans le service.
   */
  public getAllBucket(): Observable<Bucket[]> {
    return this.httpClient.get<Bucket[]>(environment.apiUrl + '/buckets');
  }

  /**
   * La fonction publishBuckets() est chargée une fois au démarrage de l'application.
   * Elle récupère la liste des Buckets depuis la base de données et met à jour la liste et la liste observable.
   */
  public publishBuckets() {
    this.getAllBucket().subscribe(
      BucketList => {
        this.availableBuckets = BucketList;
        this.availableBuckets$.next(this.availableBuckets);
        this.setBucketListSubject(this.availableBuckets);

      });
  }

  /**
   * @param idBucket l'id qu'il faut rechercher dans la liste.
   */
  public findBucket(bucketId: number): Observable<Bucket> {
    if (bucketId) {
      if (!this.availableBuckets) {
        return this.getAllBucket().pipe(map(buckets => buckets.find(bucket => bucket.idBucket === bucketId)));
      }
      return of(this.availableBuckets.find(bucket => bucket.idBucket === bucketId));
    } else {
      return of(new Bucket(0,  new Date(), 0, new Friend()));
    }
  }

  /**
   * @param newBucket
   */
  public createBucket(newBucket: Bucket) {
    this.httpClient.post<Bucket>(environment.apiUrl + '/createBucket', newBucket).subscribe(
      newBucket => {
        this.availableBuckets.push(newBucket);
        this.availableBuckets$.next(this.availableBuckets);
      }
    );
  }

  /**
   * Fonction de mise à jour d'un Bucket
   * @param bucket
   */
  public updateBucket(bucket: Bucket) {
    this.httpClient.put<Bucket>(environment.apiUrl + '/updateBucket', bucket).subscribe(
      updatedBucket => {
        this.availableBuckets$.next(this.availableBuckets);
      }
    );
  }

  public initBucket(mailFriend: string) {
    this.httpClient.post<Bucket>( environment.apiUrl + '/addBucket/' + mailFriend, null ).subscribe(
      (bucket) => {
        this.bucketFriend = bucket;
        console.log('bucketFriend idBucket: ' + bucket.friend.mailFriend);
      }
    );
  }

  /**
   * Fonction de suppression
   * @param idBucket
   */
  public deleteBucket(idBucket: number) {
    this.httpClient.delete<Bucket>(environment.apiUrl + '/deleteBucket/' + idBucket).subscribe(
    );
  }

  public addItemToBucket(idItem: number, idBucket: Number) {

  }
}
