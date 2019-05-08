package rozeridilar.com.fragmenttofragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private static final String TAG = "MainActivity";

    //widgets
    private TextView toolbarTitle;

    @Override
    public void inflateFragment(String fragmentTag, String message) {

        if (fragmentTag.equals(getString(R.string.fragment_a))) {
            FragmentA fragmentA = new FragmentA();
            doFragmentTransaction(fragmentA,getString(R.string.fragment_a),true,message);

        } else if (fragmentTag.equals(getString(R.string.fragment_b))) {

        } else if (fragmentTag.equals(getString(R.string.fragment_c))) {

        }
    }

    @Override
    public void setToolBarTitle(String fragmentTag) {
        toolbarTitle.setText(fragmentTag);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarTitle = findViewById(R.id.toolbar_title);

        init();
    }

    private void init(){
        SelectorFragment selectorFragment = new SelectorFragment();
        doFragmentTransaction(selectorFragment,getString(R.string.fragment_selector),false,"");
    }

    private void doFragmentTransaction(Fragment fragment,String tag,boolean addToBackStack, String message){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment,tag);

        if(!message.equals("")){
            Bundle bundle = new Bundle();
            bundle.putString(getString(R.string.intent_message),message);
            fragment.setArguments(bundle);
        }

        if (addToBackStack){
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();

    }



}
