package com.test.testtask.database;

import android.app.Application;
import android.widget.Toast;

import com.test.testtask.database.model.Reponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ReponseRepository {

    private final DataBase dataBase;
    private Application application;
    public ReponseRepository(@NonNull Application application) {
        this.application = (Application) application.getApplicationContext();
        dataBase = DataBase.getDatabase(this.application);
    }

    public void insert(final Reponse reponse){
        Completable.fromAction( () -> dataBase.listUsersDao().insert(reponse))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {
                    }
                    @Override
                    public void onComplete() {
                        Toast.makeText(application,"Data inserted", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(application,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
