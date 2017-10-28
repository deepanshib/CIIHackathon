package cii.beegeeks.foodathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
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
        mytrack m1=new mytrack();
        getSupportFragmentManager().beginTransaction().replace(R.id.home,m1).commit();
        //Floating bButoon code
        bmb = (BoomMenuButton) findViewById(R.id.bmb);

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



        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottomBar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.track, "My Track").setActiveColorResource(R.color.nav1))
                .addItem(new BottomNavigationItem(R.drawable.alternative, "Alternatives").setActiveColorResource(R.color.nav2))
                .addItem(new BottomNavigationItem(R.drawable.healthissues, "Health Issues").setActiveColorResource(R.color.nav3))
                .addItem(new BottomNavigationItem(R.drawable.users, "My Profile").setActiveColorResource(R.color.nav4))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

                switch(position)
                {
                    case 0:
                    {
                        mytrack m1=new mytrack();
                        getSupportFragmentManager().beginTransaction().replace(R.id.home,m1).commit(); break;
                    }
                    case 1: {
                        Alternative m2 = new Alternative();
                        getSupportFragmentManager().beginTransaction().replace(R.id.home, m2).commit();
                        break;
                    }
                    case 2: {
                        Health m3 = new Health();
                        getSupportFragmentManager().beginTransaction().replace(R.id.home, m3).commit();
                        break;
                    }
                    case 3:
                    {
                        Profile m4=new Profile();
                        getSupportFragmentManager().beginTransaction().replace(R.id.home,m4).commit(); break;
                    }

                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
            }
        });
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
