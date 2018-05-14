package teamonethursday.map_application;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by User on 14/05/2018.
 */

public class HomeActivity extends Activity{
    ListView lst;
    String[] fruitname = {"Test", "Test 2", "Test 3"};
    String[] desc = {"Uploader 1", "Uploader 2", "Uploader 3"};
    Integer[] imgid = {R.drawable.flowers, R.drawable.bridge, R.drawable.waterfall};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lst = (ListView) findViewById(R.id.listview);
        customListView  CustomListView= new customListView(this, fruitname, desc, imgid);
        lst.setAdapter(CustomListView);
    }
}