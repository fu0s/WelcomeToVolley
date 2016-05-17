package example.soufiane.welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    public void openLoginActivity(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }
    public void openSignUpActivity(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}