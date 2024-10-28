package com.example.zeovideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.zeovideo.Pojo.AuthSession;

public class AuthActvity extends AppCompatActivity {
    EditText edtUserName,edtCallingJoin;
    Button bt_join;
    // SharedPreferences keys
    private static final String PREF_NAME = "authPref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_CALLID = "callId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      /*  // Check if session exists and skip AuthActivity if it does
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        if (sharedPreferences.contains(KEY_USERNAME) && sharedPreferences.contains(KEY_CALLID)) {
            // Session exists, skip AuthActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish(); // Close AuthActivity
            return;
        }*/

        setContentView(R.layout.activity_auth_actvity);
        initObjects();
        // click on button

        bt_join.setOnClickListener(v -> {
            if(edtUserName.getText().toString().isEmpty()){
                Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show();
            } else if (edtCallingJoin.getText().toString().isEmpty()) {
                Toast.makeText(this, "please enter your join code", Toast.LENGTH_SHORT).show();
            }else{
                AuthSession authSession=new AuthSession(edtUserName.getText().toString(),edtCallingJoin.getText().toString());
               // saveSessionData(authSession);
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("sessionData", authSession);
                startActivity(intent);
                finish(); // Close AuthActivity
            }
        });
    }
    private void initObjects(){
        edtUserName=findViewById(R.id.edtUserName);
        edtCallingJoin=findViewById(R.id.edtCallingJoin);
        bt_join=findViewById(R.id.bt_join);
    }
    // Save session data to SharedPreferences
    private void saveSessionData(AuthSession authSession) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, authSession.getUserName());
        editor.putString(KEY_CALLID, authSession.getCallId());
        editor.apply(); // Commit changes
    }
}