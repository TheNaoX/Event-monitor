package event.monitor;

import event.monitor.models.Workshop;
import event.monitor.WorkshopAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class ShowWorkshop extends Activity{
  private Object workshops;
  private Workshop workshop;
  private ListView list_view;

  @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.show_workshop);

      getViewData();
      setupWorkshop();

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
    workshops = (ListView)findViewById(R.id.workshops);
  }

  public void setupWorkshop(){
    workshop = new Workshop(getApplicationContext(),"workshop",null,1);
  }

}
