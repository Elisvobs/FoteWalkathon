package com.whitney.nyaradzowalkathon;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    private String mUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        // Initialize Firebase Auth
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        mFirebaseUser = mFirebaseAuth.getCurrentUser();
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        if(mFirebaseUser == null){
//            // Not logged in, launch the Log In activity
//            loadLogInView();
//        } else {
//            mUserId = mFirebaseUser.getUid();
//
//            // Set up ListView
//            final ListView listView = findViewById(R.id.listView);
//            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                    android.R.layout.simple_list_item_1, android.R.id.text1);
//            listView.setAdapter(adapter);
//
//            final EditText text = findViewById(R.id.todoText);
//            final String name = text.getText().toString();
//            final Button button = findViewById(R.id.addButton);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    //child gets a reference to the specified node if it exists or creates it if it doesn’t exist
//                    mDatabase.child("user").child(mUserId).child("name").setValue(text.getText().toString());
////                    mDatabase.child("users").child(mUserId)
////                            .child("name").child(name)
////                            .child("gender").child(gender)
////                            .child("contact").child(contact)
////                            .child("shirtSize").child(shirtSize)
////                            .child("emergency").child(emergency)
////                            .child("nationality").child(nationality)
////                            .child("company").child(company);
//                }
//            });
//
//            mDatabase.child("user").child(mUserId).addChildEventListener(new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                    adapter.add((String) dataSnapshot.child("name").getValue());
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//                    adapter.remove((String) dataSnapshot.child("name").getValue());
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        }
//    }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        getMenuInflater().inflate(R.menu.menu_main, menu);
////        return true;
////    }
////
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        int id = item.getItemId();
////        if (id == R.id.action_logout) {
////            return true;
////        }
////        return super.onOptionsItemSelected(item);
////    }
//
//    private void loadLogInView() {
//        Intent intent = new Intent(this, LogInActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
    }
}