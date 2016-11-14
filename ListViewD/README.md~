# LISTVIEWA

    - Step 1: Design activity_main.xml
        <?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:id="@+id/activity_main"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:paddingBottom="@dimen/activity_vertical_margin"
	    android:paddingLeft="@dimen/activity_horizontal_margin"
	    android:paddingRight="@dimen/activity_horizontal_margin"
	    android:paddingTop="@dimen/activity_vertical_margin"
	    android:orientation="vertical"
	    tools:context="vn.udn.dut.listviewa.MainActivity">
	    <ExpandableListView
		android:id="@+id/lvExp"
		android:layout_width="match_parent"
		android:layout_height="match_parent">
	    </ExpandableListView>
	</LinearLayout>

    - Step 2: Create new xml(list_group) is group header of ListView
	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="fill_parent"
	    android:layout_height="wrap_content"
	    android:orientation="vertical"
	    android:padding="8dp"
	    android:background="@color/LightSeaGreen">
	    <TextView
		android:id="@+id/itemHeader"
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:paddingLeft="?android:attr/expandableListPreferredItemPaddingLeft"
		android:textSize="17dp"
		android:textColor="@color/DarkCyan"/>
	</LinearLayout>

    - Step 3: Create new xml(list_item.xml) 
    	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="match_parent"
	    android:layout_height="55dip"
	    android:orientation="vertical">
	    <TextView
		android:id="@+id/item"
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:textSize="17dip"
		android:paddingTop="5dp"
		android:paddingBottom="5dp"
		android:paddingLeft="?android:attr/expandableListPreferredItemPaddingLeft">
	    </TextView>
	</LinearLayout>

    - Step 4: Create new Adapter[Get ListData, get Context, Get LayoutActivity]. Decide choose layout 
    item of ListView    

    	package vn.udn.dut.listviewa;

	import android.content.Context;
	import android.graphics.Typeface;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.BaseExpandableListAdapter;
	import android.widget.TextView;

	import java.util.HashMap;
	import java.util.List;

	/**
	 * Created by vuongluis on 05/11/2016.
	 */

	public class AdapterFashion extends BaseExpandableListAdapter{

	    private Context context;
	    private List<String> listHeaders;
	    private HashMap<String,List<String>> listData;

	    public AdapterFashion(Context context,List<String> listHeaders,HashMap<String,List<String>> listData){
		this.context = context;
		this.listHeaders = listHeaders;
		this.listData = listData;
	    }

	    @Override
	    public int getGroupCount() {
		return this.listHeaders.size();
	    }

	    @Override
	    public int getChildrenCount(int i) {
		return this.listData.get(this.listHeaders.get(i)).size();
	    }

	    @Override
	    public Object getGroup(int i) {
		return this.listHeaders.get(i);
	    }

	    @Override
	    public Object getChild(int i, int i1) {
		return this.listData.get(this.listHeaders.get(i)).get(i1);
	    }

	    @Override
	    public long getGroupId(int i) {
		return i;
	    }

	    @Override
	    public long getChildId(int i, int i1) {
		return i1;
	    }

	    @Override
	    public boolean hasStableIds() {
		return false;
	    }

	    @Override
	    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
		String headerTitle = (String)getGroup(i);
		if(view == null){
		    LayoutInflater infalInflater = (LayoutInflater) this.context
		            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    view = infalInflater.inflate(R.layout.list_group, null);
		}
		TextView lblListHeader = (TextView) view.findViewById(R.id.itemHeader);
		lblListHeader.setTypeface(null, Typeface.BOLD);
		lblListHeader.setText(headerTitle);
		return view;
	    }

	    @Override
	    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
		    final String childText = (String) getChild(i, i1);
		    if (view == null) {
		        LayoutInflater infalInflater = (LayoutInflater) this.context
		                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		        view = infalInflater.inflate(R.layout.list_item, null);
		    }

		    TextView txtListChild = (TextView) view.findViewById(R.id.item);
		    txtListChild.setText(childText);
		    return view;
	    }

	    @Override
	    public boolean isChildSelectable(int i, int i1) {
		return true;
	    }
	}

    - Step 5: Code MainActivity => Push data 

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

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/ListViewD/1.png)
![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/ListViewD/2.png)

    - ReadMore: http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/        








