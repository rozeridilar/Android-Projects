package rozeridilar.com.fragmenttofragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        SelectorFragment selectorFragment = new SelectorFragment();
        doFragmentTransaction(selectorFragment,getString(R.string.fragment_selector),false,"");
    }

    private void doFragmentTransaction(Fragment fragment,String tag,boolean addToBackStack, String message){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, fragment);
        if (addToBackStack){
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();

    }
}
