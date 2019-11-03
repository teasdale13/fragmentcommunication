package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentcommunication.fragment.FirstFragment;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        editText = findViewById( R.id.editText );

        Button btn = findViewById( R.id.button );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment fragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
                assert fragment != null;
                // Utilisation de la fonction créé pour communiquer avec le fragment.
                fragment.setText( editText.getText().toString() );
            }
        } );
    }
}
