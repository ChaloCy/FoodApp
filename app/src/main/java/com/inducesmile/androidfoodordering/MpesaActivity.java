package com.inducesmile.androidfoodordering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.inducesmile.androidfoodordering.R;
import com.inducesmile.androidfoodordering.entities.SuccessObject;
import com.inducesmile.androidfoodordering.network.GsonRequest;
import com.inducesmile.androidfoodordering.network.VolleySingleton;
import com.inducesmile.androidfoodordering.util.Helper;

import java.util.HashMap;

public class MpesaActivity extends AppCompatActivity {

    private Button pay_button;
    private EditText text_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpesa);

        pay_button = findViewById(R.id.pay_button);
        text_phone = findViewById(R.id.phone);

        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text_phone.getText().toString().trim().length() != 10){
                    Toast.makeText(MpesaActivity.this, "Enter a valid phone number", Toast.LENGTH_LONG).show();
                    return;
                }

                placeOrder();
            }
        });
    }

    private void placeOrder(){
        HashMap<String, String> params = (HashMap<String, String>) getIntent().getExtras().get("order");
        params.put("phone", text_phone.getText().toString().trim());

        GsonRequest<SuccessObject> serverRequest = new GsonRequest<SuccessObject>(
                Request.Method.POST,
                Helper.PATH_TO_PLACE_ORDER,
                SuccessObject.class,
                params,
                new Response.Listener<SuccessObject>() {
                    @Override
                    public void onResponse(SuccessObject response) {
                        if (response.getSuccess() == 1) {
                            // TODO handle success, can show success dialog, with exit buttons
                            Toast.makeText(MpesaActivity.this, "Payment initiated. Enter PIN to authorize", Toast.LENGTH_LONG).show();
                        } else {
                            //TODO handle error
                            Toast.makeText(MpesaActivity.this, "Oops. Failed to place order", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO handle volley error
                        Toast.makeText(MpesaActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });

        serverRequest.setRetryPolicy(new DefaultRetryPolicy(
                Helper.MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(MpesaActivity.this).addToRequestQueue(serverRequest);
    }
}