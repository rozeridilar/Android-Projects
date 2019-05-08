package rozeridilar.com.fragmenttofragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SelectorFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "SelectorFragment";

    //outlets
    private Button btnFragmentA,btnFragmentB,btnFragmentC;
    private EditText mMessage;

    //vars
    private IMainActivity mImainActivity;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: " + getTag());
        mImainActivity.setToolBarTitle(getTag());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector,container,false);
        mMessage = view.findViewById(R.id.message);
        btnFragmentA = view.findViewById(R.id.btn_fragment_a);
        btnFragmentB = view.findViewById(R.id.btn_fragment_b);
        btnFragmentC = view.findViewById(R.id.btn_fragment_c);

        btnFragmentA.setOnClickListener(this);
        btnFragmentB.setOnClickListener(this);
        btnFragmentC.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String message = mMessage.getText().toString();

        switch (view.getId()){
            case R.id.btn_fragment_a:{
                mImainActivity.inflateFragment(getString(R.string.fragment_a),message);
                break;
            }
            case R.id.btn_fragment_b:{

                break;
            }
            case R.id.btn_fragment_c:{

                break;
            }
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mImainActivity = (IMainActivity) getActivity();
    }


}
