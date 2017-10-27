package cii.beegeeks.foodathon;
import android.graphics.drawable.Drawable;
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

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.poliveira.parallaxrecyclerview.ParallaxRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
BoomMenuButton bmb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //Floating bButoon code
        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        HamButton.Builder builder1 = new HamButton.Builder()
                .normalImageRes(R.drawable.salad)
                .normalTextRes(R.string.menu_option1)
                .subNormalTextRes(R.string.opt1_detail).normalColorRes(R.color.opt1);
        bmb.addBuilder(builder1);
        HamButton.Builder builder4 = new HamButton.Builder()
                .normalImageRes(R.drawable.salad)
                .normalTextRes(R.string.menu_option4)
                .subNormalTextRes(R.string.opt4_detail).normalColorRes(R.color.opt4);
        bmb.addBuilder(builder4);
        HamButton.Builder builder5 = new HamButton.Builder()
                .normalImageRes(R.drawable.salad)
                .normalTextRes(R.string.menu_option5)
                .subNormalTextRes(R.string.opt5_detail).normalColorRes(R.color.opt5);
        bmb.addBuilder(builder5);
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
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
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



    }

}
