# LISTVIEWA

    - Step 1: Designed GUI Android ---> Contain ListView WidgetAndroid.
    <?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    tools:context="vn.udn.dut.listview.MainActivity">
	    <ListView
		android:id="@+id/lvBook"
		android:layout_width="match_parent"
		android:layout_height="wrap_content">
	    </ListView>
	</LinearLayout>

    - Step 2: Writting code in MainActivity.java to control push data into ListView
    package vn.udn.dut.listview;

	import android.support.v7.app.AppCompatActivity;
	import android.os.Bundle;
	import android.widget.ArrayAdapter;
	import android.widget.ListView;

	import java.util.ArrayList;
	import java.util.List;

	public class MainActivity extends AppCompatActivity {

	    private ListView lvBook;
	    private List<String> listOfBook;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvBook = (ListView)findViewById(R.id.lvBook);
		listOfBook = new ArrayList<>();

		listOfBook.add(new String("Chỉ Có Thể Là Yêu"));
		listOfBook.add(new String("Luyện Trí Nhớ"));
		listOfBook.add(new String("Tiểu Sử Steve Jobs"));
		listOfBook.add(new String("Trò Chơi Tư Duy"));
		listOfBook.add(new String("Cô Gái Tháng Mười"));
		listOfBook.add(new String("Chuyên Đề Đẹp"));
		listOfBook.add(new String("Chuyên Đề Du Lịch"));

		for(int i = 0; i < 30; i++){
		    listOfBook.add(String.format("%s %d","Luis Nguyen Van",i));
		}

		/** Adapter => This is a bridge to connect data from Activity to view ListView **/
		ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfBook);
		lvBook.setAdapter(adapter);
	    }
	}

    - NOTE: ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfBook);
    => Using item defautl ListView [android.layout.simple_list_item_1]
![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/1.png)

# LISTVIEWB 
=> USING BASICADAPTER 
    - Step 1: Design GUI include ListView, Button, TextView, EditText
    <?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:id="@+id/activity_main"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:background="@color/MintCream"
	    android:orientation="vertical"
	    tools:context="vn.udn.dut.listviewb.MainActivity">

	    <LinearLayout
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:orientation="vertical">
		<LinearLayout
		    android:layout_width="match_parent"
		    android:layout_height="wrap_content"
		    android:orientation="horizontal"
		    android:background="@drawable/rounded_edittext"
		    android:layout_marginTop="10dp"
		    android:layout_marginLeft="15dp"
		    android:layout_marginRight="15dp">
		    <TextView
		        android:layout_width="wrap_content"
		        android:layout_height="wrap_content"
		        android:id="@+id/tvTitle"
		        android:text="Title: "
		        android:textSize="20dp"
		        android:textColor="@color/OrangeRed"
		        android:layout_marginTop="7dp"
		        android:paddingRight="5dp"
		        android:paddingLeft="5dp"
		        android:textStyle="bold"/>

		    <EditText
		        android:id="@+id/edtTitle"
		        android:layout_width="match_parent"
		        android:layout_height="wrap_content"
		        android:orientation="horizontal"
		        android:padding="10dp"
		        android:background="@drawable/rounded_edittext"
		        android:layout_marginTop="5dp"
		        android:layout_marginBottom="5dp"
		        android:layout_marginLeft="15dp"
		        android:layout_marginRight="15dp"/>
		</LinearLayout>

		<LinearLayout
		    android:layout_width="match_parent"
		    android:layout_height="wrap_content"
		    android:orientation="horizontal"
		    android:background="@drawable/rounded_edittext"
		    android:layout_marginTop="15dp"
		    android:layout_marginLeft="15dp"
		    android:layout_marginRight="15dp">
		    <TextView
		        android:layout_width="wrap_content"
		        android:layout_height="wrap_content"
		        android:id="@+id/tvContent"
		        android:text="Content: "
		        android:textSize="20dp"
		        android:textColor="@color/MediumVioletRed"
		        android:layout_marginTop="7dp"
		        android:paddingRight="5dp"
		        android:paddingLeft="5dp"
		        android:textStyle="bold"/>

		    <EditText
		        android:id="@+id/edtContent"
		        android:layout_width="match_parent"
		        android:layout_height="wrap_content"
		        android:orientation="horizontal"
		        android:padding="10dp"
		        android:background="@drawable/rounded_edittext"
		        android:layout_marginTop="5dp"
		        android:layout_marginBottom="5dp"
		        android:layout_marginLeft="15dp"
		        android:layout_marginRight="15dp"/>
		</LinearLayout>

	    </LinearLayout>

	    <Button
		android:id="@+id/btnAdd"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:layout_gravity="center"
		android:layout_marginTop="8dp"
		android:background="@drawable/rounded_edittext"
		android:text="Add"
		android:textStyle="bold"
		android:textColor="@color/Chocolate" />

	    <ListView
		android:id="@+id/lvBasic"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:layout_marginTop="10dp"
		android:layout_marginLeft="15dp"
		android:layout_marginRight="15dp"
		android:background="@drawable/rounded_listview">

	    </ListView>
	</LinearLayout>

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/2.png)

    - Adapter extends BasicAdapter 
    + BasicAdapter get data from Activity [ArrayList<> or List<>]
    + BasicAdapter has: view = layoutInflater.inflate(R.layout.item_listview_user, null);
    => We customize item of ListView example: item_listview_user

    - Step 2: Customize item_listview_user

    <?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:orientation="vertical">
	    <TextView
		android:id="@+id/tvTitle"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="Name"
		android:textColor="#ff0000"
		android:textSize="20dp" />

	    <TextView
		android:id="@+id/tvContent"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:text="Content" />
	</LinearLayout>

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/3.png)

    - Step 3: Prepare Activity with data[List or ArrayList]
    
    package vn.udn.dut.listviewb;

	import android.support.v7.app.AppCompatActivity;
	import android.os.Bundle;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.ListView;

	import java.util.ArrayList;
	import java.util.List;

	import vn.udn.dut.listviewb.bean.User;

	public class MainActivity extends AppCompatActivity {

	    private EditText edtTitle;
	    private EditText edtContent;
	    private Button btnAdd;

	    private List<User> listItems;
	    private ListView lvBasic;

	    private AdapterUser adapterUser;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edtTitle = (EditText)findViewById(R.id.edtTitle);
		edtContent = (EditText)findViewById(R.id.edtContent);
		lvBasic = (ListView)findViewById(R.id.lvBasic);

		listItems = new ArrayList<>();

		listItems.add(new User("Trường An","Cuộc sống an lành, may mắn và hạnh phúc"));
		listItems.add(new User("Thiên Ân","Tấm lòng nhân ái tốt đẹp và sự sâu sắc"));

		adapterUser = new AdapterUser(this,listItems);
		lvBasic.setAdapter(adapterUser);

	    }
	}

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/4.png)
  
    - Step 4: Add Event of ListView
    + setOnItemClickListener()

    	lvBasic.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, user.getTitle() + "--" + user.getContent(), Toast.LENGTH_LONG).show();
            }
        });

        lvBasic.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showAlertDialog(position);
                return false;
            }
        });

        lvBasic.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Toast.makeText(MainActivity.this, "Scroll", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                // load more
            }
        });

    + Create a new DialogBox

	private void showAlertDialog(final int position) {
		AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
		builder1.setTitle("Confirm Delete");
		builder1.setMessage("Do yout want delete item!!");
		builder1.setCancelable(true);

		builder1.setPositiveButton(
		        "Yes",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		                listItems.remove(position);
		                adapterUser.notifyDataSetChanged();
		                dialog.cancel();
		            }
		        });

		builder1.setNegativeButton(
		        "No",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		            }
		        });

		AlertDialog alert11 = builder1.create();
		alert11.show();
	    }

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/5.png)
![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/6.png)

    - Step 5: Relative Button or TextView or EditText With ListView

	btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTitle.getText().toString().equals("") || edtContent.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please input valid data!!", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    listItems.add(new User(edtTitle.getText().toString().trim(), edtContent.getText().toString().trim()));
                    adapterUser.notifyDataSetChanged();
                }
            }
        });

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/7.png)

# LISTVIEWC 
=> USING ARRAYADAPTER 
    - Step 1: Writting code adapter to push data from activity to listview
    package vn.udn.dut.listviewc;

	import android.content.Context;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.ArrayAdapter;
	import android.widget.TextView;

	import java.util.List;

	import vn.udn.dut.listviewc.bean.User;

	/**
	 * Created by vuongluis on 05/11/2016.
	 */

	public class AdapterUser extends ArrayAdapter<User>{

	    private List<User> listItems;
	    private Context context;
	    private LayoutInflater mLayoutInflater;

	    public AdapterUser(Context context, List<User> listItems) {
		super(context, 0, listItems);

		this.context = context;
		this.listItems = listItems;
		mLayoutInflater = LayoutInflater.from(context);
	    }

	    @Override
	    public int getCount() {
		if (listItems.isEmpty()) {
		    return 0;
		}
		return listItems.size();
	    }

	    @Override
	    public View getView(int i, View view, ViewGroup viewGroup) {
		// Get the data item for this position
		final User user = listItems.get(i);
		ViewHolder viewHolder;
		// Check if an existing view is being reused, otherwise inflate the view
		if (view == null) {
		    view = mLayoutInflater.inflate(R.layout.item_listview_user, null, false);
		    // Lookup view for data population
		    viewHolder = new ViewHolder();
		    viewHolder.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		    viewHolder.tVContent = (TextView) view.findViewById(R.id.tvContent);
		    view.setTag(viewHolder);
		} else {
		    viewHolder = (ViewHolder) view.getTag();
		}

		// Populate the data into the template view using the data object
		viewHolder.tvTitle.setText(user.getTitle());
		viewHolder.tVContent.setText(user.getContent());
		// Return the completed view to render on screen
		return view;
	    }

	    private static class ViewHolder {
		TextView tvTitle;
		TextView tVContent;
	    }
	}

    - Step 2: Finish Code MainActivity

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/8.png)

# ExRecycle 
=> USING BASICADAPTER 

    - Step 1: See video youtube talk to about "ExRecycle"
    - Step 2: Installer: compile 'com.android.support:recyclerview-v7:24.2.1'

    







