package cii.beegeeks.foodathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;


public class mytrack extends Fragment {

    public mytrack() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_mytrack, container, false);
        BoomMenuButton bmb;
        bmb = (BoomMenuButton) view.findViewById(R.id.bmb);
        HamButton.Builder builder1 = new HamButton.Builder()
                .normalImageRes(R.drawable.salad)
                .normalTextRes(R.string.menu_option1)
                .subNormalTextRes(R.string.opt1_detail).normalColorRes(R.color.opt1).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        getChildFragmentManager().beginTransaction().replace(R.id.home, new breakfast1()).commit();
                    }
                });
        bmb.addBuilder(builder1);
        HamButton.Builder builder4 = new HamButton.Builder()
                .normalImageRes(R.drawable.salad)
                .normalTextRes(R.string.menu_option4)
                .subNormalTextRes(R.string.opt4_detail).normalColorRes(R.color.opt4).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        getChildFragmentManager().beginTransaction().replace(R.id.home, new lunch1()).commit();
                    }
                });
        bmb.addBuilder(builder4);
        HamButton.Builder builder5 = new HamButton.Builder()
                .normalImageRes(R.drawable.salad)
                .normalTextRes(R.string.menu_option5)
                .subNormalTextRes(R.string.opt5_detail).normalColorRes(R.color.opt5).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        getChildFragmentManager().beginTransaction().replace(R.id.home, new dinner1()).commit();
                    }
                });
        bmb.addBuilder(builder5);
        HamButton.Builder builder3 = new HamButton.Builder()
                .normalImageRes(R.drawable.cocktail)
                .normalTextRes(R.string.menu_option3)
                .subNormalTextRes(R.string.opt3_detail).normalColorRes(R.color.opt2).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        getChildFragmentManager().beginTransaction().replace(R.id.home, new snacks1()).commit();
                    }
                });
        bmb.addBuilder(builder3);
        HamButton.Builder builder2 = new HamButton.Builder()
                .normalImageRes(R.drawable.run)
                .normalTextRes(R.string.menu_option2)
                .subNormalTextRes(R.string.opt2_detail).normalColorRes(R.color.opt3).listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {

                        getChildFragmentManager().beginTransaction().replace(R.id.home, new excercise1()).commit();
                    }
                });
        bmb.addBuilder(builder2);
        return view;
    }


}
