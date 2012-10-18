package event.monitor;

import java.util.ArrayList;

import event.monitor.models.CWorkshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class WorkshopAdapter extends ArrayAdapter{

  Context context;
  ArrayList<CWorkshop> workshops;

  @SuppressWarnings("unchecked")
    public WorkshopAdapter(Context context, int layout_id, ArrayList<CWorkshop> Workshop) {
      super(context, layout_id, Workshop);
      this.context = context;
      this.workshops = Workshop;
      // TODO Auto-generated constructor stub
    }

  public View getView(int position, View convertView, ViewGroup parent){
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View row = inflater.inflate(R.layout.workshop_item, null);
    try{
      // Load
      TextView label_name = (TextView)row.findViewById(R.id.label_name);	
      TextView label_id = (TextView)row.findViewById(R.id.label_id);
      // Set values
      label_id.setText(workshops.get(position)._id);
      label_name.setText(workshops.get(position).name);

      label_id.setVisibility(View.GONE);

    }
    catch(Exception ex){
    }
    return row;
  }

}
