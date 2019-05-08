package rozeridilar.com.fragmenttofragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentA extends Fragment {
    private static final String TAG = "FragmentA";

    //outlets
    private TextView mDisplaymessage;
    private String mIncomingMessage = "";

    //vars
    private IMainActivity mIMainActivity;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mIMainActivity.setToolBarTitle(getTag());

        Bundle bundle = this.getArguments();
        if(bundle != null){
            mIncomingMessage = bundle.getString(getString(R.string.intent_message));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        mDisplaymessage = view.findViewById(R.id.incoming_message);

        setIncomingMessage();

        return view;
    }

    private void setIncomingMessage(){
        if (!mIncomingMessage.equals("")){
            mDisplaymessage.setText(mIncomingMessage);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity) getActivity();
    }
    
}
