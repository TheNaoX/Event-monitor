package event.monitor.models;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.*;
import android.util.Log;


public class Workshop extends SQLiteOpenHelper {
	private static final String DB_TABLE_NAME = "workshop";
	private static final String DB_COLUMN_1_NAME = "name";
	private String sql;
	SQLiteDatabase db;
	private Object sqliteDBInstance;
	
	public Workshop(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE workshop (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void saveAttributes(String name){
		db=getWritableDatabase();
		sql="INSERT INTO workshop (name) VALUES ('" + name + "')";
		db.execSQL(sql);
		db.close();
	}
	
	public void updateAttributes(int workshopId, String name){
		db=getWritableDatabase();
		String strFilter = "_id=" + workshopId;
		ContentValues args = new ContentValues();
		args.put("name", name);
		db.update("workshop", args, strFilter, null);
		db.close();
	}
	
	public void destroy(String name){
		db=getWritableDatabase();
		db.delete("workshop", "name='" + name + "'", null);
		db.close();
	}
	
	public ArrayList<CWorkshop> all(){
		db = getWritableDatabase();
		sql = "SELECT _id,name FROM workshop";
		Cursor cursor = db.rawQuery(sql, null);
		ArrayList<CWorkshop> workshops = new ArrayList<CWorkshop>();

		while (cursor.moveToNext())
		{
			CWorkshop workshop = new CWorkshop();
			workshop._id = cursor.getString(0);
			workshop.name = cursor.getString(1);
			workshops.add(workshop);
		}
		db.close();
		cursor.close();
		return workshops;
	}
	
	public String[] getWorkshopId(String name){
		db = getWritableDatabase();
		String result[] = new String [3];
		sql = "SELECT _id,name FROM workshop WHERE name='" + name + "'";
		Cursor c = this.getReadableDatabase().rawQuery(sql, null);
		int _id;
		_id =c.getColumnIndex("_id");
		c.moveToLast();
		result[0] = c.getString(_id)/*+ " "+c.getString(iwork)+ "\n"*/;
		db.close();
		c.close();
		return result;
	}
	
	public String[] getWorkshopsData(String name){
		db = getWritableDatabase();
		String result[] = new String [5];
		sql = "SELECT _id,name FROM workshop WHERE name='" + name + "'";
		Cursor c = this.getReadableDatabase().rawQuery(sql, null);
		int _id, name1;
		_id =c.getColumnIndex("_id");
		name1 =c.getColumnIndex("name");
		c.moveToLast();
		result[0] = c.getString(_id);
		result[1] = c.getString(name1);
		db.close();
		c.close();
		return result;
	}
	
	
	public void openDB() throws SQLException
    {
        Log.i("openDB", "Checking sqliteDBInstance...");
        if(this.sqliteDBInstance == null)
        {
            Log.i("openDB", "Creating sqliteDBInstance...");
            this.sqliteDBInstance = this.getWritableDatabase();
        }
    }
 
    public void closeDB()
    {
        if(this.sqliteDBInstance != null)
        {
            if(((SQLiteDatabase) this.sqliteDBInstance).isOpen())
                ((Cursor) this.sqliteDBInstance).close();
        }
    }

}
