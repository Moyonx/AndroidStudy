package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ChatRoomActivity extends AppCompatActivity {
    private int page;
    private TextView tv_content_info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        //获取控件
        tv_content_info = findViewById(R.id.tv_content_info);

        //获取Intent传值
        Intent intent = getIntent();
        page = intent.getIntExtra("page",-1) + 1;

        //将值展示在控件中
        tv_content_info.setText("从第"+page+"个item跳转而来");

    }
}
