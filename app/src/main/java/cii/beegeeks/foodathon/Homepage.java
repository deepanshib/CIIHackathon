package cii.beegeeks.foodathon;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.poliveira.parallaxrecyclerview.ParallaxRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
BoomMenuButton bmb;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String username="",userid="";
    private int RC_SIGN_IN=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //Floating bButoon code

        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    username = user.getDisplayName();
                    userid = user.getEmail();

                    Toast.makeText(getApplicationContext(), "You're now signed in. Welcome.", Toast.LENGTH_SHORT).show();
                } else {
                    // User is signed out
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER,
                                            AuthUI.GOOGLE_PROVIDER)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };


        bmb=(BoomMenuButton)findViewById(R.id.bmb);
        HamButton.Builder builder1 = new HamButton.Builder()
                    .normalImageRes(R.drawable.salad)
                    .normalTextRes(R.string.menu_option1)
                    .subNormalTextRes(R.string.opt1_detail).normalColorRes(R.color.opt1);
            bmb.addBuilder(builder1);
        HamButton.Builder builder3 = new HamButton.Builder()
                .normalImageRes(R.drawable.cocktail)
                .normalTextRes(R.string.menu_option3)
                .subNormalTextRes(R.string.opt3_detail).normalColorRes(R.color.opt2);
        bmb.addBuilder(builder3);
        HamButton.Builder builder2 = new HamButton.Builder()
                .normalImageRes(R.drawable.run)
                .normalTextRes(R.string.menu_option2)
                .subNormalTextRes(R.string.opt2_detail).normalColorRes(R.color.opt3);
        bmb.addBuilder(builder2);

        //Bottom navigation code

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottomBar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.track, "My Track").setActiveColorResource(R.color.nav1))
                .addItem(new BottomNavigationItem(R.drawable.alternative, "Alternatives").setActiveColorResource(R.color.nav2))
                .addItem(new BottomNavigationItem(R.drawable.healthissues, "Health Issues").setActiveColorResource(R.color.nav3))
                .addItem(new BottomNavigationItem(R.drawable.users, "My Profile").setActiveColorResource(R.color.nav4))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });

        //Header
        RecyclerView myRecycler = (RecyclerView) findViewById(R.id.myRecycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        myRecycler.setLayoutManager(manager);
        myRecycler.setHasFixedSize(true);

        final List<String> content = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            content.add(getListString(i));


        ParallaxRecyclerAdapter<String> stringAdapter = new ParallaxRecyclerAdapter<String>(content) {

            @Override
            public void onBindViewHolderImpl(RecyclerView.ViewHolder viewHolder, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
                ((TextView) viewHolder.itemView).setText(content.get(i));
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolderImpl(ViewGroup viewGroup, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
                return new SimpleViewHolder(getLayoutInflater().inflate(android.R.layout.simple_list_item_1, viewGroup, false));
            }

            @Override
            public int getItemCountImpl(ParallaxRecyclerAdapter parallaxRecyclerAdapter) {
                return content.size();
            }
        };


        stringAdapter.setParallaxHeader(getLayoutInflater().inflate(R.layout.my_header, myRecycler, false), myRecycler);
        stringAdapter.setOnParallaxScroll(new ParallaxRecyclerAdapter.OnParallaxScroll() {
            @Override
            public void onParallaxScroll(float percentage, float offset, View parallax) {
//                Drawable c = mToolbar.getBackground();
//                c.setAlpha(Math.round(percentage * 255));
//                mToolbar.setBackground(c);
            }

            // Event triggered when you click on a item of the adapter.
           public void onClick(View v, int position) {

            }
        });
        myRecycler.setAdapter(stringAdapter);
    }
    static class SimpleViewHolder extends RecyclerView.ViewHolder {

        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }

    public String getListString(int position) {
        return position + " - android";
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Sign-in succeeded, set up the UI
                startActivity(new Intent(getApplicationContext(),Male_female.class));
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                // Sign in was canceled by the user, finish the activity
                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
}
