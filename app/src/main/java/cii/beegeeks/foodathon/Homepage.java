package cii.beegeeks.foodathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;

public class Homepage extends AppCompatActivity {
BoomMenuButton bmb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        bmb=(BoomMenuButton)findViewById(R.id.bmb);
//        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
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

    }
}
