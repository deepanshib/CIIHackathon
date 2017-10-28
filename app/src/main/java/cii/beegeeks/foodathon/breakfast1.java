package cii.beegeeks.foodathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class breakfast1 extends Fragment {
  EditText edittext;
    public breakfast1() {
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
        View view=inflater.inflate(R.layout.fragment_breakfast1, container, false);
        ImageView imageView=(ImageView)view.findViewById(R.id.back_breakfast);
        edittext=view.findViewById(R.id.editText);
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FatSecretSearchFragment fatsecret=new FatSecretSearchFragment();
                getChildFragmentManager().beginTransaction().replace(R.id.breakfast_layout,fatsecret).commit();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

}
