package com.babenkovladimir.androidlesson9database.sqlite;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.babenkovladimir.androidlesson9database.R;
import java.util.ArrayList;
import java.util.List;

public class SqliteActivity extends AppCompatActivity {

  private ListView listView;

  private static final int MENU_ITEM_VIEW = 111;
  private static final int MENU_ITEM_EDIT = 222;
  private static final int MENU_ITEM_CREATE = 333;
  private static final int MENU_ITEM_DELETE = 444;


  private static final int MY_REQUEST_CODE = 1000;

  private final List<Note> noteList = new ArrayList<Note>();
  private ArrayAdapter<Note> listViewAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sqlite);

    // Get ListView object from xml
    listView = (ListView) findViewById(R.id.listView);

    DatabaseHelper db = new DatabaseHelper(this);
    db.createDefaultNotesIfNeed();

    List<Note> list = db.getAllNotes();
    this.noteList.addAll(list);

    // Define a new Adapter
    // 1 - Context
    // 2 - Layout for the row
    // 3 - ID of the TextView to which the data is written
    // 4 - the List of data

    listViewAdapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, android.R.id.text1, noteList);

    // Assign adapter to ListView
    listView.setAdapter(listViewAdapter);

    // Register the ListView for Context menu
    registerForContextMenu(listView);
  }

  @Override
  public void onCreateContextMenu(ContextMenu menu, View view,
      ContextMenu.ContextMenuInfo menuInfo) {

    super.onCreateContextMenu(menu, view, menuInfo);
    menu.setHeaderTitle("Select The Action");

    // groupId, itemId, order, title
    menu.add(0, MENU_ITEM_VIEW, 0, "View Note");
    menu.add(0, MENU_ITEM_CREATE, 1, "Create Note");
    menu.add(0, MENU_ITEM_EDIT, 2, "Edit Note");
    menu.add(0, MENU_ITEM_DELETE, 4, "Delete Note");
  }

  @Override
  public boolean onContextItemSelected(MenuItem item) {
    AdapterView.AdapterContextMenuInfo
        info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

    final Note selectedNote = (Note) this.listView.getItemAtPosition(info.position);

    if (item.getItemId() == MENU_ITEM_VIEW) {
      Toast.makeText(getApplicationContext(), selectedNote.getNoteContent(), Toast.LENGTH_LONG).show();
    } else if (item.getItemId() == MENU_ITEM_CREATE) {
      Intent intent = new Intent(this, AddEditNoteActivity.class);

      // Start AddEditNoteActivity, (with feedback).
      this.startActivityForResult(intent, MY_REQUEST_CODE);
    } else if (item.getItemId() == MENU_ITEM_EDIT) {
      Intent intent = new Intent(this, AddEditNoteActivity.class);
      intent.putExtra("note", selectedNote);

      // Start AddEditNoteActivity, (with feedback).
      this.startActivityForResult(intent, MY_REQUEST_CODE);
    } else if (item.getItemId() == MENU_ITEM_DELETE) {
      // Ask before deleting.
      new AlertDialog.Builder(this)
          .setMessage(selectedNote.getNoteTitle() + ". Are you sure you want to delete?")
          .setCancelable(false)
          .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
              deleteNote(selectedNote);
            }
          })
          .setNegativeButton("No", null)
          .show();
    } else {
      return false;
    }
    return true;
  }

  // Delete a record
  private void deleteNote(Note note) {
    DatabaseHelper db = new DatabaseHelper(this);
    db.deleteNote(note);
    noteList.remove(note);
    // Refresh ListView.
    listViewAdapter.notifyDataSetChanged();
  }

  // When AddEditNoteActivity completed, it sends feedback.
  // (If you start it using startActivityForResult ())
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE) {
      boolean needRefresh = data.getBooleanExtra("needRefresh", true);
      // Refresh ListView
      if (needRefresh) {
        noteList.clear();
        DatabaseHelper db = new DatabaseHelper(this);
        List<Note> list = db.getAllNotes();
        noteList.addAll(list);

        // Notify the data change (To refresh the ListView).
        listViewAdapter.notifyDataSetChanged();
      }
    }
  }

}
