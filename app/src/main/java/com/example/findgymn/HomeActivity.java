package com.example.findgymn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
ListView listView;
String mTitle[]={"Avengers Gymn","Rousseuse","Famko Gymn","New World Fitness","Avengers Gymn","Rousseuse","Famko Gymn","New World Fitness"};
String mDescription[]={"Adit mall opp Bank of Uganda,Floor2","Easy View Complex Mbarara Town, Lockup No.2","Adit mall opp Bank of Uganda,Floor2","Easy View Complex Mbarara Town, Lockup No.2","Adit mall opp Bank of Uganda,Floor2","Easy View Complex Mbarara Town, Lockup No.2","Adit mall opp Bank of Uganda,Floor2","Easy View Complex Mbarara Town, Lockup No.2"};
int images[]={R.drawable.gymn_fitness,R.drawable.gymnpic,R.drawable.gymn_fitness,R.drawable.gymnpic,R.drawable.gymn_fitness,R.drawable.gymnpic,R.drawable.gymn_fitness,R.drawable.gymnpic};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView=(ListView)findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(this,mTitle,mDescription,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    startActivity(new Intent(HomeActivity.this,GymnActivity.class));
                }else{
                    Toast.makeText(HomeActivity.this, "Onclick method not yet creatted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
            startActivity(new Intent(this,SettingsActivity.class));
            return true;
        } if (id == R.id.action_logout) {
            startActivity(new Intent(this,LoginActivity.class));
            return true;
        }
        if (id == R.id.action_callUs) {
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+256776239674"));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            // Handle the camera action
            startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
        } else if (id == R.id.nav_home) {
            startActivity(new Intent(HomeActivity.this,GymnActivity.class));

        } else if (id == R.id.nav_location) {
            startActivity(new Intent(HomeActivity.this,MapsActivity.class)) ;
        } else if (id == R.id.nav_help) {
            startActivity(new Intent(HomeActivity.this,SupportActivity.class));
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "Sharing Development still on the way", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_AboutApp) {
            Toast.makeText(this, "AboutApp not yet created...", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_Support_us) {
            startActivity(new Intent(HomeActivity.this,SupportActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        public MyAdapter(Context c,String title[],String description[],int imgs[]) {
            super(c, R.layout.rows,R.id.textview1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.rows,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView mTitle=row.findViewById(R.id.textview1);
            TextView mDescription=row.findViewById(R.id.textview2);

            images.setImageResource(rImgs[position]);
            mTitle.setText(rTitle[position]);
            mDescription.setText(rDescription[position]);
            return row;
        }
    }
}
