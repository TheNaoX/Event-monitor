package event.monitor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button NewUser = (Button)findViewById(R.id.button1);
        NewUser.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent myIntent = new Intent(v.getContext(), NewUser.class);
            startActivityForResult(myIntent,0);
          }
        });

        Button NewWorkshop = (Button)findViewById(R.id.button2);
        NewWorkshop.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent myIntent = new Intent(v.getContext(), NewWorkshop.class);
            startActivityForResult(myIntent,0);
          }
        });

        Button ShowUsers = (Button)findViewById(R.id.button3);
        ShowUsers.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent myIntent = new Intent(v.getContext(), ShowUsers.class);
            startActivityForResult(myIntent,0);
          }
        });

        Button ShowWorkshops = (Button)findViewById(R.id.button4);
        ShowWorkshops.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent myIntent = new Intent(v.getContext(), ShowWorkshops.class);
            startActivityForResult(myIntent,0);
          }
        });
    }

    @Override
      public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
      }
}
