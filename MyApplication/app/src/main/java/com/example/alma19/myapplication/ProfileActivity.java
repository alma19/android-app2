package com.example.alma19.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    


    //view objects
    public TextView textViewUserEmail; //used to be private
    private Button buttonLogout;


    private DatabaseReference databaseReference;

    public TextView textViewName;
    public EditText editTextName, editTextAge, editTextGender, editTextQuote, editTextFacebook, editTextTwitter, editTextInstagram, editTextEmail; //used to be private
    public Button buttonSave; //used to be private
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();


        //if user not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, login_activity.class));
        }

        //getting the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();


        //getting the views from xml resource

       // editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextGender = (EditText) findViewById(R.id.editTextGender);
        editTextQuote = (EditText) findViewById(R.id.editTextQuote);
        editTextFacebook = (EditText) findViewById(R.id.editTextFacebook);
        editTextTwitter = (EditText) findViewById(R.id.editTextTwitter);
        editTextInstagram = (EditText) findViewById(R.id.editTextInstagram);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        textViewName = (TextView) findViewById(R.id.textViewName);


        buttonSave = (Button) findViewById(R.id.buttonSave);


        buttonSave.setOnClickListener(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textviewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome " + user.getEmail());



        //adding listener to button
        buttonLogout.setOnClickListener(this);
        //buttonLogout.setOnClickListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }





    public void saveUserInformation() { //was private void
        //getting values to store

        String name = editTextName.getText().toString().trim();
     //   String add = editTextAddress.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String gender = editTextGender.getText().toString().trim();
        String quote = editTextQuote.getText().toString().trim();
        String facebook = editTextFacebook.getText().toString().trim();
        String twitter = editTextTwitter.getText().toString().trim();
        String instagram = editTextInstagram.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();



     // UserInformation userInformation = new UserInformation(name, add);
        //adding values
        UserInformation userInformation = new UserInformation(name, age, gender, quote, facebook, twitter, instagram, email);


        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this, "Information Saved...", Toast.LENGTH_LONG).show();





    }





    @Override
    public void onClick(View view) {

        if (view == buttonLogout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, login_activity.class));
        }

        if (view == buttonSave) {
            saveUserInformation();
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Profile Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
