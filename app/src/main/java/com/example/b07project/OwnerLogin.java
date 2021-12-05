package com.example.b07project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class OwnerLogin extends AppCompatActivity implements Contract.View{
    private Contract.Presenter presenter;
    public static final String USERNAME = "com.example.myfirstapp.MESSAGE";
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        presenter = new MyPresenter(new MyModel(), this);
    }

    public String getUsername(){
        EditText text = findViewById(R.id.Username);
        username = text.getText().toString();
        return text.getText().toString();
    }
    public String getPassword(){
        EditText text = findViewById(R.id.Password);
        return text.getText().toString();
    }

    public void handleClick(View view){
        presenter.Check_Account("Owners");
    }

    public void Alert(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(OwnerLogin.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setNegativeButton("Close", (dialog, which) -> dialog.cancel());
        builder.show();
    }


    public void NextPage(User user, String type){
        Intent intent = new Intent(this, DisplayOwnerActivity.class);
        intent.putExtra(DisplayOwnerActivity.Owner_Key, (Serializable) user);
        startActivity(intent);
    }


}