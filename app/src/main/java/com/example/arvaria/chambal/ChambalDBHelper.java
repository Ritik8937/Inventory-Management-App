package com.example.arvaria.chambal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.arvaria.Person;

import java.util.LinkedList;
import java.util.List;

public class ChambalDBHelper extends SQLiteOpenHelper {
    public static final String chambalDATABASE_NAME="chambal.db";
    public static final int DATABASE_VERSION=3;
    public static final String chambalTABLE_NAME="Chambal";
    public static final String Column_Id ="id";
    public static final String Column_Person_Name ="name";
    public static final String Column_Person_Age ="age";
    public static final String Column_Person_Occupation ="occupation";


    public ChambalDBHelper(@Nullable Context context) {
        super(context,chambalDATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1;
      query1="CREATE TABLE Chambal ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL , age Number NOT NULL, occupation TEXT NOT NULL)";
      db.execSQL(query1);




//                        Column_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                        Column_Person_Name + " TEXT NOT NULL, " +
//                        Column_Person_Age + " NUMBER NOT NULL, " +
//                        Column_Person_Occupation + " TEXT NOT NULL);"
//                //COLUMN_PERSON_IMAGE + " BLOB NOT NULL);"
//        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(" DROP TABLE IF EXISTS "+chambalTABLE_NAME);
            this.onCreate(db);
    }
    public void saveNewPerson(Person person)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values1=new ContentValues();
        values1.put(Column_Person_Name, person.getName());

        values1.put(Column_Person_Age, person.getAge());

        values1.put(Column_Person_Occupation, person.getOccupation());
        Log.e("CHECKING",values1.toString());
        db.insert("Chambal",null,values1);
        db.close();
    }
    public List<Person> peopleList(String filter) {
        String query;
        if(filter.equals("")){
            //regular query
            query = "SELECT  * FROM " + chambalTABLE_NAME;
        }else{
            if(filter=="Variant")
            {
                //filter results by filter option provided
                query = "SELECT  * FROM " + chambalTABLE_NAME + " ORDER BY " + "Name";
            }
            else if(filter.equals("Boxes"))
            {
                query = "SELECT  * FROM " + chambalTABLE_NAME + " ORDER BY " + "Age";

            }
            else
            {
                query = "SELECT  * FROM " + chambalTABLE_NAME + " ORDER BY " + "Occupation";

            }
        }

        List<Person> personLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Person person;

        if (cursor.moveToFirst()) {
            do {
                person = new Person();

                person.setId(cursor.getLong(cursor.getColumnIndex(Column_Id)));
                person.setName(cursor.getString(cursor.getColumnIndex(Column_Person_Name)));
                person.setAge(cursor.getString(cursor.getColumnIndex(Column_Person_Age)));
                person.setOccupation(cursor.getString(cursor.getColumnIndex(Column_Person_Occupation)));
//                person.setImage(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_IMAGE)));
                personLinkedList.add(person);
            } while (cursor.moveToNext());
        }


        return personLinkedList;
    }

    public Person getPerson(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + chambalTABLE_NAME + " WHERE id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        Person receivedPerson = new Person();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedPerson.setName(cursor.getString(cursor.getColumnIndex(Column_Person_Name)));
            receivedPerson.setAge(cursor.getString(cursor.getColumnIndex(Column_Person_Age)));
            receivedPerson.setOccupation(cursor.getString(cursor.getColumnIndex(Column_Person_Occupation)));
            //receivedPerson.setImage(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_IMAGE)));
        }



        return receivedPerson;


    }
    public void deleteChambalRecord(long id,Context context)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+chambalTABLE_NAME+" WHERE id='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }
    /**update record**/
    public void updateChambalRecord(long personId, Context context, Person updatedchambal) {
        SQLiteDatabase db = this.getWritableDatabase();
        //you can use the constants above instead of typing the column names
        // db.execSQL("UPDATE  "+TABLE_NAME+" SET name ='"+ updatedperson.getName() + "', age ='" + updatedperson.getAge()+ "', occupation ='"+ updatedperson.getOccupation() + "', image ='"+ updatedperson.getImage() + "'  WHERE _id='" + personId + "'");
        db.execSQL("UPDATE  "+chambalTABLE_NAME+" SET name ='"+ updatedchambal.getName() + "', age ='" + updatedchambal.getAge()+ "', occupation ='"+ updatedchambal.getOccupation() + "'  WHERE id='" + personId + "'");

        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();


    }

}
