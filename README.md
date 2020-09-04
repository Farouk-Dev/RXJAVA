# RXJAVA
RxJava est basé sur la règle du 3Os :
- Observables
- Observers
- Operators<br/>
<h2>Les différents types de l'observable sont :</h2>
<ul>
<li>Maybe : Il vérifie si le data a été reçu ou pas (true/false).</li> 
<li>Single : Il vérifie le data et si le data a été reçu ou pas .</li>
<li>Completable :Il vérifie s'ils ont été reçu ou pas (true/false).</li>
<li>Observable :Il vérifie les datas et s'ils ont été reçu ou pas (pour ce cas  si l'observable est plus rapide que l'observer "Backpressure" on peut risquer de perdre des données).</li>
<li>Flowable : C'est un observable qui nous  permet  de gérer le problème de  "backpressure"</li>
 </ul>
 <h2>Les différents callbacks à utiliser dans  le cas  d'un backpressure :</h2>
 <ul>
<li><b>onBackpressureDrop</b> : Suppression du data  qui est en attente.</li> 
<li><b>onBackpressureLatest</b> : La dernière data qui a été reçu sera traité.</li>
<li><b>onBackpressureBuffer</b> :Un buffer  avec un size x est disponible pour stocker  les datas qui sont en attente .</li>
Dans le cas ou il ya  un overflow "buffer chargé" on peut appeler les callbacks suivants:
   <ul>
<li><b>ON_OVERFLOW_ERROR</b> : Lancer une erreur.</li> 
<li><b>ON_OVERFLOW_DROP_LATEST</b> : Supprission du data la plus récente dans le buffer.</li>
<li><b>ON_OVERFLOW_DRO_OLDEST</b> :Supprission du data la plus ancienne dans le buffer.</li>
 
 </ul>
  </ul>
  <h2>Il ya deux autre types d'observables:</h2>
  <ul>
<li><b>Cold observables</b> : Les observables sont paresseux dans le sens où ils n'exécutent des valeurs que lorsque quelque chose y souscrit(observer). Pour chaque abonné l'Observable démarre une nouvelle exécution .</li> 
<li><b>Hot observables</b> : Il est capable de partager des données entre plusieurs observateurs.</li>

Les types du hot observables sont les suivants:
   <ul>
<li><b>ConnectableObservable</b> : Voir ce commit "Hot observable = ConnectableObservable" .</li> 
<li><b>PublishSubject</b> : Voir ce commit "Hot observable = PublishSubject".</li>
<li><b>BehaviorSubject</b> : Voir ce commit "Hot observable = BehaviorSubject".</li>
<li><b>ReplaySubject</b> : Voir ce commit "Hot observable = ReplaySubject".</li>
<li><b>AsyncSubject</b> : Voir ce commit "Hot observable = AsyncSubject".</li>
 </ul>
  </ul>
   <h2>Observer:</h2>
   Celui qui va écouter l'observable.
   <h2>methodes de construction :</h2>
   voir ce commit "Observer & factory methods".
   <h2>Le multi-threading</h2>
   Afin de chsoir le thread qu'on va utiliser avec RxJava il  faut  passer par <span>Schedulers</span> qui est liée  avec le Threadpool qui contient  les thread suivants :
  <ul>
<li><b>Schedulers.io()()</b> : A utiliser par défaut.</li>
<li><b>Schedulers.computation()</b> : On utilise ce thread pour des opération compliquées.</li>
<li><b>Schedulers.newThread()</b> :Toujous ouvre un nouveau thread .</li>
<li><b>AndroidSchedulers.mainThread()</b> :C'est notre thread principale .</li>
<li><b>Schedulers.trampoline()</b> : Basé sur l'algorithme FIFO,Toujours une seule opération en exécution .</li>
 </ul>
  RXJava gère le multi-threading à travers les  opérateurs  suivants :
  <ul>
<li><b>SubscribeOn()</b> : Préciser le Thread de l'upStream .</li>
<li><b>ObserveOn()</b> : Préciser le Thread du downStream.</li>
 </ul>
 Le stream liée  à l'observable s'appelle "upStream" .</br>
 Le stream liée  à l'observer s'appelle "downStream" .
