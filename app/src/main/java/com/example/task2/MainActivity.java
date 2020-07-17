package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView cityFrom;
    private View shadowView;
    private TextView cityTo;
    private EditText cityEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityFrom = findViewById(R.id.cityFrom);
        cityTo = findViewById(R.id.cityTo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void onClickSetCityFrom(View view) {

        viewDialog("from");

    }

    public void onClickSetCityTo(View view) {

        viewDialog("to");

    }

    public void setText(String city){
        shadowView.setVisibility(View.GONE);
        String string = cityEdit.getText().toString();
        if(city == "to") {
            cityTo.setText(string);
        } else {
            cityFrom.setText(string);
        }
    }

    public void viewDialog(final String city) {
        shadowView = findViewById(R.id.shadow_view);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View popupView = inflater.inflate(R.layout.popup, null);
        cityEdit = popupView.findViewById(R.id.city);

        builder.setView(popupView)

                .setPositiveButton(R.string.sign, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        shadowView.setVisibility(View.VISIBLE);
                        setText(city);
                    }
                })
                .setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}