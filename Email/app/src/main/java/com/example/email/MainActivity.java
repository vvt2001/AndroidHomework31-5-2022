package com.example.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.email.MailItemAdapter;
import com.example.email.MailModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    List<String> senderMail = Arrays.asList("thang.vv194374@sis.hust.edu.vn",
            "son.dd194362@sis.hust.edu.vn", "manh.hd194163@sis.hust.edu.vn",
            "nam.dp194335@sis.hust.edu.vn", "dung.hv194100@sis.hust.edu.vn");
    List<String> title = Arrays.asList("Hello", "Nice", "New assignment",
            "New meeting", "Borrow your homework","Next exam");
    List<String> content = Arrays.asList("Hello World 1","Hello World 2",
            "Hello World 3","Hello World 4","Hello World 5",
            "Hello World 6", "Hello World 7");
    List<String> time = Arrays.asList("11:54 PM", "8:45 AM", "3:12 PM", "5:12 AM", "4:34 PM","8:23 PM", "10:10 AM");
    List<MailModel> items = new ArrayList<MailModel>();
    private void generateValue()
    {
        int min = 0;
        int max = senderMail.size()-1;
        for(int i=1;i<=30;i++)
        {
            int random_int;
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            String newSenderMail = senderMail.get(random_int);
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            String newTitle = title.get(random_int);
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            String newContent = content.get(random_int);
            random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            String newTime = time.get(random_int);

            MailModel newMailModel = new MailModel(newSenderMail, newTitle,
                    newContent, newTime, false);
            items.add(newMailModel);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateValue();
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MailItemAdapter adapter = new MailItemAdapter(items);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
}