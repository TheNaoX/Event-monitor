package event.monitor;

import event.monitor.models.User;
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


public class ShowUsers extends Activity{
  private Object users;
  private User user;
  private ListView list_view;

  @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.show_users);

      getViewData();
      setupUser();
      setupAdapter();

      list_view = (ListView) findViewById(R.id.users);
      list_view.setTextFilterEnabled(true);
      list_view.setOnItemClickListener(new OnItemClickListener(){
  		@Override
        public void onItemClick(AdapterView<?> arg0, View v, int position, long id){
          //Con esto obtenemos el contenido de los TextView contenidos en el Item
          String  name=(String)((TextView)v.findViewById(R.id.label_name)).getText();
          String  email=(String)((TextView)v.findViewById(R.id.label_email)).getText();
          String  id1=(String)((TextView)v.findViewById(R.id.label_id)).getText();
          //Aqui se empieza a construir un Alert con la informacion del usuario
          AlertDialog.Builder alertDialog = new AlertDialog.Builder(ShowUsers.this);
          alertDialog.setTitle("User");
          alertDialog.setMessage("El elemento seleccionado es = " + name + " " + email + " " + id1);
          alertDialog.setPositiveButton("Aceptar", null);
          alertDialog.show();
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
    users = (ListView)findViewById(R.id.users);
  }

  public void setupUser(){
    user = new User(getApplicationContext(),"users",null,1);
  }

  private void setupAdapter(){
    if(user.all()!=null)
    {
      UserAdapter adapter = new UserAdapter(this,R.layout.user_item, user.all());
      ((ListView) users).setAdapter(adapter);
    }
  }

  public void onResume(){
    super.onResume();
    setupAdapter();
  }

}
