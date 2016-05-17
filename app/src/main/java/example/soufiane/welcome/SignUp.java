package example.soufiane.welcome;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends Activity {


    EditText nameInput;
    EditText passwordInput;
    EditText confirmPasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameInput = (EditText) findViewById(R.id.nameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        confirmPasswordInput = (EditText) findViewById(R.id.confirmPasswordInput);


    }
    public void signup(View view) {
        if (!passwordInput.getText().toString().equals(confirmPasswordInput.getText().toString())) {
            Toast.makeText(getApplicationContext(), "The passwords do not match", Toast.LENGTH_LONG).show();
        } else {
            /*String json = "{\"name\": \"" + nameInput.getText() + "\", \"password\":\"" + passwordInput.getText() + "\"}";
            networkHelper.post("http://192.168.1.19:8000/signup", json, new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                }
                @Override
                public void onResponse(Response response) throws IOException {
                    String responseStr = response.body().string();
                    final String messageText = "Status code : " + response.code() +
                            "\n" +
                            "Response body : " + responseStr;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), messageText, Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });*/
            RequestQueue queue = Volley.newRequestQueue(this);
            String url ="http://192.168.1.27:3000/login";
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            final Pattern pattern = Pattern.compile("<div>(.+?)</div>");
                            final Matcher matcher = pattern.matcher(response.toString());
                            matcher.find();
                                nameInput.setText("Response is: " + matcher.group(1));


                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            nameInput.setText("That didn't work!");
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("email", "Alif");
                    params.put("password", "http://itsalif.info");

                    return params;
                }
            };
            queue.add(postRequest);
        }
    }
}
