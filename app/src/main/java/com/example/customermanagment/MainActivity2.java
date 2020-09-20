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

public class MainActivity2 extends AppCompatActivity {

    EditText name,email,address,phone,username,password;
    DatabaseReference reff;
    Button log,reg;
    private Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         name = (EditText) findViewById(R.id.Name);
         email = (EditText) findViewById(R.id.Email);
         address = (EditText) findViewById(R.id.Address);
        phone = (EditText) findViewById(R.id.Phone);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
        log=(Button)findViewById(R.id.button4) ;
        reg=(Button)findViewById(R.id.change) ;
         member=new Member();


         log.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(i);
             }
         });
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
 reg.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         try{
             if (TextUtils.isEmpty(name.getText().toString())){
                 Toast.makeText(getApplicationContext(),"Please Enter the name",Toast.LENGTH_SHORT).show();
             }else if (TextUtils.isEmpty(email.getText().toString())){
                 Toast.makeText(getApplicationContext(),"Please Enter the email",Toast.LENGTH_SHORT).show();
             }else if (TextUtils.isEmpty(address.getText().toString())){
                 Toast.makeText(getApplicationContext(),"Please Enter the name",Toast.LENGTH_SHORT).show();
             }else if (TextUtils.isEmpty(phone.getText().toString())){
                 Toast.makeText(getApplicationContext(),"Please Enter the name",Toast.LENGTH_SHORT).show();
             }else if (TextUtils.isEmpty(username.getText().toString())){
                 Toast.makeText(getApplicationContext(),"Please Enter the name",Toast.LENGTH_SHORT).show();
             }else if (TextUtils.isEmpty(password.getText().toString())){
                 Toast.makeText(getApplicationContext(),"Please Enter the name",Toast.LENGTH_SHORT).show();
             }else{

                 member.setName(name.getText().toString().trim());
                 member.setEmail(email.getText().toString().trim());
                 member.setAddress(address.getText().toString().trim());
                 member.setPhone(phone.getText().toString().trim());
                 member.setUsername(username.getText().toString().trim());
                 member.setPassword(password.getText().toString().trim());
                 reff.child(username.getText().toString()).setValue(member);
                 Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
             }
         }   catch (NumberFormatException e){

             Toast.makeText(getApplicationContext(),"Invalid Member",Toast.LENGTH_SHORT).show();
         }
     }
 });
    }


    // public void register () {
       // EditText name = (EditText) findViewById(R.id.Name);
       // EditText email = (EditText) findViewById(R.id.Email);
       // EditText address = (EditText) findViewById(R.id.Address);
        //EditText phone = (EditText) findViewById(R.id.Phone);
        //EditText username = (EditText) findViewById(R.id.Username);
       // EditText password = (EditText) findViewById(R.id.Password);

      //  Button reg = (Button) findViewById(R.id.button3);

        //reg.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {

                //String id = databaseRefrence.push.getKey();
                // User user = new User(name, email,....)
                //databaseReference.child(id).setValues(user);
            }
      //  });


   // }
//}