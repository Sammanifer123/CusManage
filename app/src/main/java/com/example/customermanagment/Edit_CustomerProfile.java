package com.example.customermanagment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Edit_CustomerProfile extends AppCompatActivity {
    TextView Editusername,Editname,Editemail,Editaddress,Editphone;
    Button resetpassword,save;
    ImageButton usernamepencil,namepencil,emailpencil,addresspencil,phonepencil;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__customer_profile);
        Editusername=(TextView)findViewById(R.id.edusername);
        Editname=(TextView)findViewById(R.id.edname);
        Editemail=(TextView)findViewById(R.id.edemail);
        Editaddress=(TextView)findViewById(R.id.edaddress);
        Editphone=(TextView)findViewById(R.id.edphone);

        usernamepencil=(ImageButton)findViewById(R.id.imageButton);
      namepencil=  (ImageButton)findViewById(R.id.imageButton2);
      emailpencil=(ImageButton)findViewById(R.id.imageButton3);
        addresspencil=(ImageButton)findViewById(R.id.imageButton4);
        phonepencil=(ImageButton)findViewById(R.id.imageButton5);




        Intent li=getIntent();
        final String username= li.getStringExtra("username");
        viewCustomerDetails();
        editUsername();
        editname();




    }

    private void editname() {
        namepencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam =Editname.getText().toString();
                updatename(nam);

            }
        });
    }
//update username

    private void updatename( final String nam) {
        //get dialog box to change the user name
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.update_user_name_dialog,null);
        dialogBuilder.setView(dialogView);

        final EditText EditingName =(EditText)dialogView.findViewById(R.id.editText5);
        Button cancel =(Button) dialogView.findViewById(R.id.cancel);
        Button change=(Button)dialogView.findViewById(R.id.change);
        dialogBuilder.setTitle("Change Your Name");
        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam=EditingName.getText().toString().trim();
                String usernamepattern="";
                if (nam.isEmpty()){
                    EditingName.setError("change!!");

                }else {
                    if(!(nam.matches(usernamepattern))){
                        EditingName.setError("Invalid Name");
                    }
                    else
                        updatenameDialog(nam);
                    EditingName.setText(nam);
                    alertDialog.dismiss();
                }
            }

            //change in firebase updated username
            private boolean updatenameDialog(final String nam) {
                Intent go=getIntent();
                final String username=go.getStringExtra("username");
                DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Member").child(username);
                databaseReference.orderByChild("username").equalTo(username).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                        if (dataSnapshot.exists()){
                            dataSnapshot.getRef().child("username").setValue(nam);
                        }
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                return true;
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

    }

//update username

    private void editUsername() {
        usernamepencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un =Editusername.getText().toString();
                updateusername(un);

            }
        });
    }
//update username

    private void updateusername( final String un) {
        //get dialog box to change the user name
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.update_user_name_dialog,null);
        dialogBuilder.setView(dialogView);

        final EditText EditingUserName =(EditText)dialogView.findViewById(R.id.editText5);
        Button cancel =(Button) dialogView.findViewById(R.id.cancel);
        Button change=(Button)dialogView.findViewById(R.id.change);
        dialogBuilder.setTitle("Change your Username");
        final AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un=EditingUserName.getText().toString().trim();
                String usernamepattern="";
                if (un.isEmpty()){
                    EditingUserName.setError("change!!");

                }else {
                    if(!(un.matches(usernamepattern))){
                        EditingUserName.setError("Invalid username");
                    }
                    else
                        updateusernameDialog(un);
                    EditingUserName.setText(un);
                    alertDialog.dismiss();
                }
            }

            //change in firebase updated username
            private boolean updateusernameDialog(final String un) {
                Intent go=getIntent();
                final String username=go.getStringExtra("username");
                DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Member").child(username);
                databaseReference.orderByChild("username").equalTo(username).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                        if (dataSnapshot.exists()){
                            dataSnapshot.getRef().child("username").setValue(username);
                        }
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                return true;
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

    }

//display user details
    private void viewCustomerDetails(){
        Intent i=getIntent();
        String username=i.getStringExtra("username");
        System.out.println(username);
        reff= FirebaseDatabase.getInstance().getReference().child("Member").child(username);
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String cusuname=snapshot.child("username").getValue(String.class).toString();
                String cusname=snapshot.child("name").getValue(String.class).toString();
                String email=snapshot.child("email").getValue(String.class).toString();
                String cusaddress=snapshot.child("address").getValue(String.class).toString();
                String cusphone=snapshot.child("phone").getValue(String.class).toString();

                System.out.println(cusaddress+cusuname);
                Editusername.setText(cusuname);
                Editname.setText(cusname);
                Editemail.setText(email);
                Editaddress.setText(cusaddress);
                Editphone.setText(cusphone);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}