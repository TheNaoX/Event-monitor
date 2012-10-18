package event.monitor;

import java.util.ArrayList;

import event.monitor.models.CUser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter{

  Context context;
  ArrayList<CUser> users;

  @SuppressWarnings("unchecked")
    public UserAdapter(Context context, int layout_id, ArrayList<CUser> Users) {
      super(context, layout_id, Users);
      this.context = context;
      this.users = Users;
      // TODO Auto-generated constructor stub
    }

  public View getView(int position, View convertView, ViewGroup parent){
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View row = inflater.inflate(R.layout.user_item, null);
    try{
      // Load
      TextView label_name = (TextView)row.findViewById(R.id.label_name);	
      TextView label_email = (TextView)row.findViewById(R.id.label_email);	
      TextView label_id = (TextView)row.findViewById(R.id.label_id);
      // Set values
      label_id.setText(users.get(position)._id);
      label_name.setText(users.get(position).name);
      label_email.setText(users.get(position).email);

      label_id.setVisibility(View.GONE);

    }
    catch(Exception ex){
    }
    return row;
  }

}
