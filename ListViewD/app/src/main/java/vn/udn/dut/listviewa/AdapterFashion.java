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
