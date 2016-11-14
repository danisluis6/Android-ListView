package vn.udn.dut.listviewa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AdapterFashion adapter;
    private ExpandableListView lvExp;
    private List<String> listHeader;
    private HashMap<String,List<String>> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Object Widget ListView
        lvExp = (ExpandableListView)findViewById(R.id.lvExp);

        // Prepare List Data, Using global variable
        prepareListData();

        // set Adapter
        adapter = new AdapterFashion(this,listHeader,listData);
        lvExp.setAdapter(adapter);

        // Not using event
    }

    protected void prepareListData(){
        listHeader = new ArrayList<String>();
        listData = new HashMap<String, List<String>>();

        // Adding child data
        listHeader.add("Top 250");
        listHeader.add("Now Showing");
        listHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listData.put(listHeader.get(0), top250); 
        listData.put(listHeader.get(1), nowShowing);
        listData.put(listHeader.get(2), comingSoon);
    }
}
