package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> notes;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		//TODO implement the Custom ListView

		lv = (ListView)findViewById(R.id.lv) ;
		notes = new ArrayList<Note>();


		DBHelper db = new DBHelper(SecondActivity.this);

		// Insert a task
		ArrayList<Note> data = db.getAllNotes();
		db.close();
		for (int i = 0; i < data.size(); i++) {
			Log.d("Database Content", i +". "+data.get(i).getDescription()+"  "+data.get(i).getRating());
			notes.add(new Note(data.get(i).getId(),data.get(i).getDescription(),data.get(i).getRating()));
//                    txt += data.get(i).getId() + ". " + data.get(i).getDescription()+"  "+ data.get(i).getDate() + "\n";
		}
		aa = new RevisionNotesArrayAdapter(this, R.layout.row, notes);

		lv.setAdapter(aa);
		aa.notifyDataSetChanged();

	}


}
