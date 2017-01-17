package io.emaster.gifviwer;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Color;
import org.polaric.colorful.ColorPickerDialog;
import org.polaric.colorful.ColorPickerPreference;
import org.polaric.colorful.Colorful;


public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_COLOR = "extra_color";
    private static final String EXTRA_MODE = "extra_MODE";
    Toolbar toolbar;
    FloatingActionButton fab;
    ColorPickerDialog dialog;
    int prevColor, currentColor;
     //ColorMode mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAllView();

        dialog = new ColorPickerDialog(this);
        dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
            @Override
            public void onColorSelected(Colorful.ThemeColor color) {
                //TODO: Do something with the color
                Log.d("color", ""+ color);
                Colorful.config(getApplication().getApplicationContext())
                        .primaryColor(color) //Colorful.ThemeColor.RED
                        .accentColor(color)  //Colorful.ThemeColor.BLUE
                        .translucent(false)
                        .dark(true)
                        .apply();

                setColorTheme(color);
                setAllView();


                /*
                currentColor = Color.parseColor(String.valueOf(color));
                updateToolbar(prevColor, currentColor);
                Bundle bundle = new Bundle();
                bundle.putInt(EXTRA_COLOR, currentColor);
                onSaveInstanceState(bundle);
                */

            }
        });

    }

    private void setColorTheme(Colorful.ThemeColor color) {
        if(color == Colorful.ThemeColor.AMBER){
            setTheme(R.style.OverlayThemeDeepAmber);
        }
        if(color == Colorful.ThemeColor.BLUE){
            setTheme(R.style.OverlayThemeBlue);
        }
        if(color == Colorful.ThemeColor.CYAN){
            setTheme(R.style.OverlayThemeCyan);
        }
        if(color == Colorful.ThemeColor.DEEP_ORANGE){
            setTheme(R.style.OverlayThemeDeepOrange);
        }
        if(color == Colorful.ThemeColor.DEEP_PURPLE){
            setTheme(R.style.OverlayThemeDeepPurple);
        }
        if(color == Colorful.ThemeColor.GREEN){
            setTheme(R.style.OverlayThemeGreen);
        }
        if(color == Colorful.ThemeColor.INDIGO){
            setTheme(R.style.OverlayThemeIndigo);
        }
        if(color == Colorful.ThemeColor.LIGHT_BLUE){
            setTheme(R.style.OverlayThemeLightBlue);
        }
        if(color == Colorful.ThemeColor.LIGHT_GREEN){
            setTheme(R.style.OverlayThemeGreen);
        }
        if(color == Colorful.ThemeColor.LIME){
            setTheme(R.style.OverlayThemeLime);
        }
        if(color == Colorful.ThemeColor.ORANGE){
            setTheme(R.style.OverlayThemeOrange);
        }
        if(color == Colorful.ThemeColor.PINK){
            setTheme(R.style.OverlayThemePink);
        }
        if(color == Colorful.ThemeColor.PURPLE){
            setTheme(R.style.OverlayThemePurple);
        }
        if(color == Colorful.ThemeColor.RED){
            setTheme(R.style.OverlayThemeRed);
        }
        if(color == Colorful.ThemeColor.TEAL){
            setTheme(R.style.OverlayThemeTeal);
        }
        if(color == Colorful.ThemeColor.YELLOW){
            setTheme(R.style.OverlayThemeYellow);
        }

        //setTheme(R.style.OverlayThemeRed);
    }

    void setAllView(){
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_COLOR, currentColor);
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

    void updateToolbar(int oldColor, int newColor) {
        final TransitionDrawable transition = new TransitionDrawable(new ColorDrawable[]{
                new ColorDrawable(oldColor), new ColorDrawable(newColor)
        });

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            toolbar.setBackground(transition);
        } else {
            toolbar.setBackgroundDrawable(transition);
        }

        transition.startTransition(300);
    }

}
