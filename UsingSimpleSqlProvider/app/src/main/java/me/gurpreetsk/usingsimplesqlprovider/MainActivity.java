package me.gurpreetsk.usingsimplesqlprovider;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import me.gurpreetsk.usingsimplesqlprovider.model.User;
import me.gurpreetsk.usingsimplesqlprovider.model.UserTable;


//https://github.com/ckurtm/simple-sql-provider

public class MainActivity extends AppCompatActivity {

  TextView textView;
  StringBuilder string = new StringBuilder();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = (TextView) findViewById(R.id.textview);

    insertInDb();
    getData();

  }

  //query data using content resolver
  private void getData() {
    Cursor cursor = getContentResolver().query(UserTable.CONTENT_URI, null, null, null, null);
    List<User> list = UserTable.getRows(cursor, true);
    for (User user : list) {
      string.append(user.getName()).append("\n");
    }
    textView.setText(string.toString());
  }

  //Simple method to insert using content resolver
  private void insertInDb() {
    User user = new User("GurpreetSK95", 0);
    User user1 = new User("Nisrulz", 1);
    User user2 = new User("Snap", 2);
    getContentResolver().insert(UserTable.CONTENT_URI, UserTable.getContentValues(user, false));
    getContentResolver().insert(UserTable.CONTENT_URI, UserTable.getContentValues(user1, false));
    getContentResolver().insert(UserTable.CONTENT_URI, UserTable.getContentValues(user2, false));
  }
}
