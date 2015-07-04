package qdsl.visl;

import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import qdsl.visl.Utils.MangaEdenClient;


public class MainActivity extends ActionBarActivity {

    private MangaEdenClient mangaEdenClient;
    Button buttonRetrieveJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mangaEdenClient = new MangaEdenClient();

        buttonRetrieveJson = (Button)findViewById(R.id.buttonRetrieveJson);

        buttonRetrieveJson.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mangaEdenClient.loadMainJSON(MainActivity.this);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
