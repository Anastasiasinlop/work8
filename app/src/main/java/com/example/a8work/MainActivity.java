package com.example.a8work;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a8work.R;

public class MainActivity extends AppCompatActivity {
    private ImageButton door;
    private ConstraintLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        door = findViewById(R.id.door);
        main = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void doorbutton(View view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            door.setVisibility(View.INVISIBLE);
            main.setBackground(getDrawable(R.drawable.hell));
            Toast.makeText(getApplicationContext(), "Подключение есть \nДобро пожаловать", Toast.LENGTH_SHORT).show();
        } else {
            door.setVisibility(View.INVISIBLE);
            main.setBackground(getDrawable(R.drawable.stena));
            Toast.makeText(getApplicationContext(), "Подключения нет \nПопробуйте снова", Toast.LENGTH_SHORT).show();
        }

    }
}