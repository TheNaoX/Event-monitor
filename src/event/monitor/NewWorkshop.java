package event.monitor;

import event.monitor.models.Workshop;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewWorkshop extends Activity{
  private Workshop workshop;
  private EditText name;

  @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.new_workshop);

      setupWorkshop();
      getViewData();
      Button CreateWorkshop = (Button)findViewById(R.id.save);
      CreateWorkshop.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
          // TODO Auto-generated method stub
          workshop.saveAttributes(name.getText().toString());
          Toast.makeText(getApplicationContext(), "Successfully saved workshop!",Toast.LENGTH_SHORT).show();
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
  }

  public void setupWorkshop(){
    workshop = new Workshop(getApplicationContext(),"workshop",null,1);
  }

}
