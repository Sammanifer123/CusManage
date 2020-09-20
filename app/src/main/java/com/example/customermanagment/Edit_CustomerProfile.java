package com.example.customermanagment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Edit_CustomerProfile extends AppCompatActivity {
    EditText Editusername,Editname,Editemail,Editaddress,Editphone;
    Button resetpassword,save,delete;
    DatabaseReference reff;
    Intent intent;
    Member memberobj;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__customer_profile);
        this.intent=getIntent();
        Intent li=getIntent();
        final String username= li.getStringExtra("username");


        Editusername=(EditText)findViewById(R.id.UserName);
        Editname=(EditText)findViewById(R.id.Name);
        Editemail=(EditText)findViewById(R.id.EmailAddress);
        Editaddress=(EditText)findViewById(R.id.PostalAddress);
        Editphone=(EditText)findViewById(R.id.editTextPhone);

        resetpassword=(Button)findViewById(R.id.button6);
        save=(Button)findViewById(R.id.button5);
        delete=(Button)findViewById(R.id.button7);

        Editusername.setText(intent.getStringExtra("username"));
        Editname.setText(intent.getStringExtra("name"));
        Editemail.setText(intent.getStringExtra("email"));
        Editaddress.setText(intent.getStringExtra("address"));
        Editphone.setText(intent.getStringExtra("phone"));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAccount();
            }

            private void updateAccount() {
                reff= FirebaseDatabase.getInstance().getReference().child("Member").child(username);
                memberobj = new Member();
                try {
                    if (TextUtils.isEmpty(Editusername.toString())){
                        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(Editname.toString())){
                        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(Editemail.toString())){
                        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(Editaddress.toString())){
                        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(Editphone.toString())){
                        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        memberobj.setUsername(Editusername.getText().toString().trim());
                        memberobj.setName(Editname.getText().toString().trim());
                        memberobj.setEmail(Editemail.getText().toString().trim());
                        memberobj.setAddress(Editaddress.getText().toString().trim());
                        memberobj.setPhone(Editphone.getText().toString().trim());
                        String path=Editusername.getText().toString();
                        reff.child(path).setValue(memberobj);
                         Editusername.setText(memberobj.Username);
                         Editname.setText(memberobj.Name);
                         Editemail.setText(memberobj.Email);
                         Editaddress.setText(memberobj.Address);
                         Editphone.setText(memberobj.Phone);
                    }

                }catch (NumberFormatException e){


                    Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                }
            }
        });











    }
}