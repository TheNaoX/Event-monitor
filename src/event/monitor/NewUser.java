package event.monitor;

import event.monitor.models.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class NewUser extends Activity{
  private User user;
  private EditText name;
  private EditText email;
  private EditText phone;
  private EditText address;
  private String gender;
  private RadioButton gender_male;
  private RadioButton gender_female;

  @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.new_user);

      getViewData();
      setupUser();
      Button CreateUser = (Button)findViewById(R.id.save);
      CreateUser.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
          // TODO Auto-generated method stub
          user.saveAttributes(name.getText().toString(), email.getText().toString(), phone.getText().toString(), address.getText().toString(), gender);
          Toast.makeText(getApplicationContext(), "Successfully saved user!",Toast.LENGTH_SHORT).show();
          finish();
        }
      });

      Button back = (Button)findViewById(R.id.back);
      back.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          // TODO Auto-generated method stub
          Intent myIntent = new Intent(v.getContext(), MainActivity.class);
          startActivityForResult(myIntent,0);
        }
      });
    }

  public void getViewData(){
    name = (EditText)findViewById(R.id.edit_name);
    email = (EditText)findViewById(R.id.edit_email);
    phone = (EditText)findViewById(R.id.edit_phone);
    address = (EditText)findViewById(R.id.edit_address);
    gender_male = (RadioButton)findViewById(R.id.radio0);
    gender_female = (RadioButton)findViewById(R.id.radio1);

    if (gender_male.isChecked()==true) {
      gender = "Male";
    } else
      if (gender_female.isChecked()==true) {
        gender = "Female";
      }
      else
      {
        gender =  "Unknown";
      }

  }

  public void setupUser(){
    user = new User(getApplicationContext(),"users",null,1);
  }

}
