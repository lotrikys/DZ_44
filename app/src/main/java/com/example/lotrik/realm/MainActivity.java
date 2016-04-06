package com.example.lotrik.realm;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lotrik.realm.realm.Dog;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Dog dog = new Dog();
        dog.setName("Rex");
        dog.setAge(1);
        Log.d("tag11", "Name of the dog: " + dog.getName());

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();

        Realm realm = Realm.getInstance(realmConfig);

        RealmResults<Dog> puppies = realm.where(Dog.class).lessThan("age", 2).findAll();

        Log.d("tag11", "before " + puppies.size());

        realm.beginTransaction();
        realm.copyToRealm(dog);
        realm.commitTransaction();

        Log.d("tag11", "after " + puppies.size());
    }
}
