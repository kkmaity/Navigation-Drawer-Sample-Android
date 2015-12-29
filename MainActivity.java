package bit.com.navigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private DrawerLayout drawerLayout;
    private LinearLayout rightDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private Button btnMenu;
    private TextView textMain;
    private TextView txtvwCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbarCustom = (Toolbar) findViewById(R.id.toolbarMainPage);
        setSupportActionBar(toolbarCustom);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        rightDrawer = (LinearLayout) findViewById(R.id.rightDrawer);
        textMain=(TextView)findViewById(R.id.textMain);
        txtvwCamera=(TextView)findViewById(R.id.txtvwCamera);
        btnMenu=(Button)findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(this);
        txtvwCamera.setOnClickListener(this);
        togleDrawer();

    }
    private void togleDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(rightDrawer))
            drawerLayout.closeDrawer(rightDrawer);
        else
            super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnMenu:
                if (drawerLayout.isDrawerOpen(rightDrawer))
                    drawerLayout.closeDrawer(rightDrawer);
                else
                    drawerLayout.openDrawer(rightDrawer);
                break;
            case R.id.txtvwCamera:
                textMain.setText(txtvwCamera.getText().toString());
                if (drawerLayout.isDrawerOpen(rightDrawer))
                    drawerLayout.closeDrawer(rightDrawer);
                break;


        }
    }
}
