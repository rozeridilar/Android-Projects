package rozeridilar.com.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentOne extends Fragment {
    private static final String TAG = "FragmentOne";

    private Button btnFragmentOne;
    private Button btnFragmentTwo;
    private Button btnFragmentThree;
    private Button btnNavSecondActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);

        btnFragmentOne = view.findViewById(R.id.btnNavFrag1);
        btnFragmentTwo = view.findViewById(R.id.btnNavFrag2);
        btnFragmentThree = view.findViewById(R.id.btnNavFrag3);
        btnNavSecondActivity = view.findViewById(R.id.btnNavSecondActivity);

        Log.d(TAG, "onCreateView: started");

        btnFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"In Fragment 1",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).changeAdapter(0);
            }
        });

        btnFragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Going to fragment 2",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).changeAdapter(1);
            }
        });

        btnFragmentThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Going to fragment 3",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).changeAdapter(2);
            }
        });

        btnNavSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Going to Second Activity",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(),SecondActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }
}
