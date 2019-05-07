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

public class SelectorFragment extends Fragment {
    private static final String TAG = "SelectorFragment";

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
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mImainActivity = (IMainActivity) getActivity();
    }
}
