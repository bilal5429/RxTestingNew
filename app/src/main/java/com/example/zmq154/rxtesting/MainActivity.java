package com.example.zmq154.rxtesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

     List<String> alphabets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphabets=new ArrayList();
        alphabets.add("aaaa");
        alphabets.add("b");
        alphabets.add("c");
        alphabets.add("d");
        alphabets.add("e");
        alphabets.add("f");
        alphabets.add("g");
        alphabets.add("h");


        Observable observable = Observable.create(emitter -> {
                    for (String alphabet : alphabets) {
                        emitter.onNext(alphabet);
                    }
            emitter.onComplete();
                });

//        Observable observable = Observable.create(new ObservableOnSubscribe() {
//            @Override
//            public void subscribe(ObservableEmitter emitter) {
//
//                try {
//
//                    /*
//                     * The emitter can be used to emit each list item
//                     * to the subscriber.
//                     *
//                     * */
//                    for (String alphabet : alphabets) {
//                        emitter.onNext(alphabet);
//                    }
//
//                    /*
//                     * Once all the items in the list are emitted,
//                     * we can call complete stating that no more items
//                     * are to be emitted.
//                     *
//                     * */
//                    emitter.onComplete();
//
//                } catch (Exception e) {
//
//                    /*
//                     * If an error occurs in the process,
//                     * we can call error.
//                     *
//                     * */
//                    emitter.onError(e);
//                }
//            }
//        });


        /*
         * We create an Observer that is subscribed to Observer.
         * The only function of the Observer in this scenario is
         * to print the valeus emitted by the Observer.
         *
         * */
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext: " + o);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        /*
         * We can call this method to subscribe
         * the observer to the Observable.
         * */
        observable.subscribe(observer);




//        Observable.interval(1, TimeUnit.SECONDS)
//
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long value) {
//                        System.out.println("onNext: " + value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });




//        Observable.range(2, 5)
//                .repeat(2)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });



//
//        Observable.fromArray(new String[]{"A", "B", "C", "D", "E", "F"})
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String string) {
//                        System.out.println("onNext: " + string);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//        Observable.fromArray(new String[]{"A", "B", "C", "D", "E", "F"})
//                .buffer(2)
//                .subscribe(new Observer<List<String>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<String> strings) {
//                        System.out.println("onNext(): ");
//                        for (String s : strings) {
//                            System.out.println("String: " + s);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


//        getOriginalObservable()
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(final Integer integer)  {
//                        return (integer * 2);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//


//        getOriginalObservable()
//                .switchMap(new Function<Integer, Observable<Integer>>() {
//                    @Override
//                    public Observable<Integer> apply(final Integer integer)  {
//                        return getModifiedObservable(integer);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });




//        Observable.range(1, 10)
//                .groupBy(new Function<Integer, Boolean>() {
//                    @Override
//                    public Boolean apply(Integer integer) {
//                        return (integer % 2 == 0) ? true : false;
//                    }
//                })
//                .subscribe(new Observer<GroupedObservable<Boolean, Integer>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(GroupedObservable<Boolean, Integer> booleanIntegerGroupedObservable) {
//                        if(booleanIntegerGroupedObservable.getKey()) {
//                            booleanIntegerGroupedObservable.subscribe(new Observer<Integer>() {
//                                @Override
//                                public void onSubscribe(Disposable d) {
//
//                                }
//
//                                @Override
//                                public void onNext(Integer integer) {
//                                    System.out.println("onNext: " + integer);
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//
//                                }
//
//                                @Override
//                                public void onComplete() {
//
//                                }
//                            });
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });



//        Observable.range(1, 10)
//                .scan(new BiFunction<Integer, Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer, Integer integer2) {
//                        return (integer + integer2);
//                    }
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });



//        Observable<Integer> observable1 = Observable.fromArray(1,2,3,4,5,6,7,8,9,10);
//        Observable<Integer> observable2 = Observable.fromArray(11,12,13,14,15,16,17,18,19,20);
////
//        Observable.combineLatest(observable2, observable1,(observable22,observable11)->
//                {
//                    System.out.println(observable22+"  bil  "+observable11);
//                 return   observable22+observable11;
//                }
//        )
////                new BiFunction<Integer, Integer, Integer>() {
////            @Override
////            public Integer apply(Integer aLong, Integer aLong2) throws Exception {
////                System.out.println(aLong+"  bil  "+aLong2);
////               return aLong+aLong2;
////            }
////        } )
//                .subscribe(item -> System.out.println(item+" value"));
//
//
////        Observable.combineLatest(observable1, observable2, new BiFunction<Long, Long, Object>() {
////            @Override
////            public Object apply(Long aLong, Long aLong2) throws Exception {
////                return 10;
////            }
////        } )
////        .subscribe(item -> System.out.println(item));



//
//        try {
//
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//

//        Observable<Long> left = Observable
//                .interval(100, TimeUnit.MILLISECONDS);
//
//        Observable<Long> right = Observable
//                .interval(100, TimeUnit.MILLISECONDS);
//
//        left.join(right,
//                aLong -> Observable.timer(0, TimeUnit.SECONDS),
//                aLong -> Observable.timer(0, TimeUnit.SECONDS),
//                (l, r) -> {
//                    System.out.println("Left result: " + l + " Right Result: " + r);
//                    return l + r;
//                })
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long aLong) {
//                        System.out.println("onNext: " + aLong);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }





//        Observable<String> alphabets1 = Observable
//                .fromArray(new String[]{"1","2","3","4","5","6","7","8","9"})
//                .map(id -> "A" + id);
//
//        Observable<String> alphabets2 = Observable
//                .fromArray(new String[]{"11","12","13","14","15","16","17","18","19"})
//                .map(id -> "B" + id);
//
//        Observable.concat(alphabets1, alphabets2)
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                            System.out.println("onNext: " + s);
//
//                    }
//
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
//
//    private Observable<Integer> getOriginalObservable() {
//        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        return Observable
//                .create(new ObservableOnSubscribe<Integer>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<Integer> emitter) {
//                        for(Integer integer : integers) {
//
//                            if (!emitter.isDisposed()) {
//                                emitter.onNext(integer);
//                            }
//                        }
//
//                        if(!emitter.isDisposed()) {
//                            emitter.onComplete();
//                        }
//                    }
//
//                });
//    }

//
//    private Observable<Integer> getOriginalObservable() {
//        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        return Observable
//                .create(new ObservableOnSubscribe<Integer>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<Integer> emitter) {
//                        for(Integer integer : integers) {
//
//                            if (!emitter.isDisposed()) {
//                                emitter.onNext(integer);
//                            }
//                        }
//
//                        if(!emitter.isDisposed()) {
//                            emitter.onComplete();
//                        }
//                    }
//
//                });
//    }
//
//    private Observable<Integer> getModifiedObservable(final Integer integer) {
//        return Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws InterruptedException {
//                emitter.onNext((integer * 2));
//                emitter.onComplete();
//            }
//        }).subscribeOn(Schedulers.io());
//    }


}
