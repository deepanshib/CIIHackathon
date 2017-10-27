package cii.beegeeks.foodathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static cii.beegeeks.foodathon.Male_female.gender;

public class User_info extends AppCompatActivity {
    private ImageView info_submit;
    private ImageView male_btn;
    private ImageView female_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ImageView info_submit=(ImageView)findViewById(R.id.info_submit);
        ImageView male_btn = (ImageView)findViewById(R.id.male_btn);
        ImageView female_btn = (ImageView)findViewById(R.id.female_button);


        if(gender == true)
        {
            female_btn.setImageResource(R.drawable.buttonfemale_faded);
        }
        else {
            male_btn.setImageResource(R.drawable.button_faded);
        }


        info_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Homepage.class));
            }
        });
    }
}
