package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    Button context,popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context  = findViewById(R.id.btn_context);
        popup =findViewById(R.id.btn_popup);
        registerForContextMenu(context);
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),popup);
                popupMenu.getMenuInflater().inflate(R.menu.option,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item1:
                                nextActivity(menuItem.getTitle().toString());
                                break;
                            case R.id.item2:
                                nextActivity(menuItem.getTitle().toString());
                                break;
                            case R.id.item3:
                                nextActivity(menuItem.getTitle().toString());
                                break;
                        }
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                nextActivity(item.getTitle().toString());
                break;
            case R.id.item2:
                nextActivity(item.getTitle().toString());
                break;
            case R.id.item3:
                nextActivity(item.getTitle().toString());
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                nextActivity(item.getTitle().toString());
                break;
            case R.id.item2:
                nextActivity(item.getTitle().toString());
                break;
            case R.id.item3:
                nextActivity(item.getTitle().toString());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void nextActivity(String text) {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("key",text);
        startActivity(intent);
    }
}