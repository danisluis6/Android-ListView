package vn.udn.dut.listviewb;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.udn.dut.listviewb.bean.User;

/**
 * Created by vuongluis on 05/11/2016.
 */

public class AdapterUser extends BaseAdapter {

    private List<User> listItems;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterUser(Context context,List<User> listItems){
        this.context = context;
        this.listItems = listItems;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (listItems.isEmpty() || listItems == null) {
            return 0;
        }
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        User country = (User) getItem(i);
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_listview_user, null);
            holder = new ViewHolder();
            holder.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            holder.tvContent = (TextView) view.findViewById(R.id.tvContent);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        holder.tvTitle.setText(country.getTitle());
        holder.tvContent.setText(country.getContent());

        return view;
    }

    public static class ViewHolder {
        TextView tvTitle;
        TextView tvContent;
    }
}
