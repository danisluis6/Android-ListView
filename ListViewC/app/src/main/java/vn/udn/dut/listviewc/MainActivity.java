package vn.udn.dut.listviewc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.udn.dut.listviewc.bean.User;

public class MainActivity extends AppCompatActivity {

    private AdapterUser adapter;
    private List<User> listItems;
    private EditText edtTitle;
    private EditText edtContent;
    private ListView lvArray;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitle = (EditText)findViewById(R.id.edtTitle);
        edtContent = (EditText)findViewById(R.id.edtContent);
        lvArray = (ListView)findViewById(R.id.lvArray);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        listItems = new ArrayList<>();

        listItems.add(new User("Trường An","Cuộc sống an lành, may mắn và hạnh phúc"));
        listItems.add(new User("Thiên Ân","Tấm lòng nhân ái tốt đẹp và sự sâu sắc"));

        adapter = new AdapterUser(this,listItems);
        lvArray.setAdapter(adapter);

        lvArray.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, user.getTitle() + "--" + user.getContent(), Toast.LENGTH_LONG).show();
            }
        });

        lvArray.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showAlertDialog(position);
                return false;
            }
        });

        lvArray.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Toast.makeText(MainActivity.this, "Scroll", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                // load more
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTitle.getText().toString().equals("") || edtContent.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please input valid data!!", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    listItems.add(new User(edtTitle.getText().toString().trim(), edtContent.getText().toString().trim()));
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
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
                        adapter.notifyDataSetChanged();
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
}
