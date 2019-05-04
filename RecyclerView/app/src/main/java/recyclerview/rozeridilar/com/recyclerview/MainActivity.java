package recyclerview.rozeridilar.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList();
    private ArrayList<String> mImageUrls = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/1.png");
        mNames.add("rose");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/2.png");
        mNames.add("penguin");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/3.png");
        mNames.add("dices");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/1.png");
        mNames.add("rose");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/2.png");
        mNames.add("penguin");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/3.png");
        mNames.add("dices");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/1.png");
        mNames.add("rose");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/2.png");
        mNames.add("penguin");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/3.png");
        mNames.add("dices");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/1.png");
        mNames.add("rose");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/2.png");
        mNames.add("penguin");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/3.png");
        mNames.add("dices");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initing recycler view");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
