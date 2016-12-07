package com.example.alma19.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
//import com.google.firebase.database.ValueEventListener;


class Post {

    public String age;
    public String email;
    public String facebook;
    public String gender;
    public String instagram;
    public String name;
    public String quote;
    public String twitter;
    public String author;
    public String title;

   public Post(String age, String email) {
        // ...
    }

}
public class profile_display extends AppCompatActivity {







    @Override
    public void onStart() {
        super.onStart();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("https://testingapp-b69be.firebaseio.com/");
        ref.addValueEventListener(new com.google.firebase.database.ValueEventListener() {


                    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Post post = dataSnapshot.getValue(Post.class);
                        System.out.println(post);
                    }


                    public void onCancelled( DatabaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });

//        // Add value event listener to the post
//        // [START post_value_event_listener]
//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                Post post = dataSnapshot.getValue(Post.class);
//                // [START_EXCLUDE]
//                mAuthorView.setText(post.author);
//                mTitleView.setText(post.title);
//                mBodyView.setText(post.body);
//                // [END_EXCLUDE]
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // [START_EXCLUDE]
//                Toast.makeText(PostDetailActivity.this, "Failed to load post.",
//                        Toast.LENGTH_SHORT).show();
//                // [END_EXCLUDE]
//            }
//        };
//        mPostReference.addValueEventListener(postListener);
//        // [END post_value_event_listener]
//
//        // Keep copy of post listener so we can remove it when app stops
//        mPostListener = postListener;
//
//        // Listen for comments
//        mAdapter = new CommentAdapter(this, mCommentsReference);
//        mCommentsRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();

//        // Remove post value event listener
//        if (mPostListener != null) {
//            mPostReference.removeEventListener(mPostListener);
//        }
//
//        // Clean up comments listener
//        mAdapter.cleanupListener();
    }
//
//    public static class Post {
//
//        public String author;
//        public String title;
//
//        public Post(String author, String title) {
//            // ...
//        }
//
//    }
//





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);






    }
}

