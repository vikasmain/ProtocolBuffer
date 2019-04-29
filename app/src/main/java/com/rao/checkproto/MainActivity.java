package com.rao.checkproto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rao.checkproto.pb.Sample;

public class MainActivity extends AppCompatActivity {
    TextView title, desc, url;
    Button testKotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sample sample = new Sample.Builder()
                .name(" Hello from Protobuffer description")
                .description(" Hello from ProtocolBuffer name")
                .id(1)
                .url("https://google.com")
                .x(1)
                .y(1)
                .build();
        title = (TextView) findViewById(R.id.title);
        desc = (TextView) findViewById(R.id.desc);
        url = (TextView) findViewById(R.id.url);
        testKotlin=(Button)findViewById(R.id.test_kotlin);
        title.setText("This is Description field from proto file -"+sample.name);
        desc.setText("This is name field from proto file -"+sample.description);
        url.setText("This is url field from proto file - "+sample.url);
        testKotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,KotlinActivity.class));
            }
        });
    }
}
