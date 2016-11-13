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
