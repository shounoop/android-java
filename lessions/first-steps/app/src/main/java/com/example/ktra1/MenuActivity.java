package com.example.ktra1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.initView();
        registerForContextMenu(this.textView);
    }

    private void initView() {
        this.textView = findViewById(R.id.title);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.color_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.redCamera:
                this.textView.setTextColor(Color.RED);
                break;
            case R.id.yellowCamera:
                this.textView.setTextColor(Color.YELLOW);
                break;
            case R.id.blueCamera:
                this.textView.setTextColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mItemFile:
                Toast.makeText(this, "File", Toast.LENGTH_LONG).show();
                break;
            case R.id.mItemEmail:
                Toast.makeText(this, "Email", Toast.LENGTH_LONG).show();
                break;
            case R.id.mItemPhone:
                Toast.makeText(this, "Phone", Toast.LENGTH_LONG).show();
                break;
            case R.id.mItemExit:
                Toast.makeText(this, "Exit", Toast.LENGTH_LONG).show();
                System.exit(0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}