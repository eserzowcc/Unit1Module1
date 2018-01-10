package edu.wcc.helloed;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HelloEdActivity extends AppCompatActivity {
    private static final String TAG=HelloEdActivity.class.getCanonicalName();
    private static final String COUNTER_TRACKER="COUNTERTRACKING";

    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i( TAG, "----------------------------------------" );
        super.onCreate(savedInstanceState);

        if( savedInstanceState != null ) {
            Log.i( TAG,"Creating our instance state");
        }

        setContentView(R.layout.activity_hello_ed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Log.i( TAG, "In click listener " + TAG );
                counter++;
                Log.i( TAG, "Counter is now at " + counter );
            }
        });
        Log.i( TAG, "Finished with onCreate :: Counter # " + counter );
    }

    @Override
    protected void onStart( ) {
        super.onStart();
        Log.i( TAG, "Finished with onStart :: Counter # " + counter );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_ed, menu);
        return true;
    }

    @Override
    public void onPause( ) {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState( Bundle bundle ) {
        super.onSaveInstanceState(bundle);

        Log.i( TAG, "Saving our instance" );
        bundle.putInt( COUNTER_TRACKER, counter );
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i( TAG, "Restoring our instance state" );
        counter=savedInstanceState.getInt( COUNTER_TRACKER );
    }

    @Override
    public void onDestroy( ) {
        super.onDestroy();
        Log.i( TAG, "onDestroy" );
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
