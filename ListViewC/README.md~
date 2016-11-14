
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

![alt tag](https://github.com/danisluis6/Android-ListView/blob/master/ListViewC/8.png)

# ExRecycle 
=> USING BASICADAPTER 

    - Step 1: See video youtube talk to about "ExRecycle"
    - Step 2: Installer: compile 'com.android.support:recyclerview-v7:24.2.1'

    







