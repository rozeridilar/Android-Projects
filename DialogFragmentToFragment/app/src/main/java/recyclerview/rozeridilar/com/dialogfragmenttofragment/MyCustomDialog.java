package recyclerview.rozeridilar.com.dialogfragmenttofragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyCustomDialog extends DialogFragment {

    private static final String TAG = "MyCustomDialog";

    public interface OnInputSelected{
        void sendInput(String input);
    }


    public OnInputSelected onInputSeleced;


    //widgets
    private EditText mInput;
    private TextView mActionOk,mActionCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_my_custom,container,false);

        mActionCancel = view.findViewById(R.id.action_cancel);
        mActionOk = view.findViewById(R.id.action_ok);
        mInput = view.findViewById(R.id.input);


        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: cancel clicked.");
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ok clicked.");

                String input = mInput.getText().toString();

                if(!input.equals("")){
                    onInputSeleced.sendInput(input);
                }

                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            onInputSeleced = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttachFragment: ClassCastException" + e.getMessage());
        }
    }
}
