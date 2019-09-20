package mainscreen.govt.maidi.com.maidi;
import android.app.Activity;


import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ExpandableListView;

import android.os.Bundle;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;



public class Explandable extends Activity implements NavigationView.OnNavigationItemSelectedListener{

    ExpandableListView expListView;

    ExpandableListAdapter expandableListAdapter;

    ArrayList<PlaceNum> listGroupTitles;

    HashMap<String, List<PlaceNum>> listDataMembers;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Get the expandable list

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // Inflate header view

        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.list_header,expListView,false);

        // Add header view to the expandable list

        expListView.addHeaderView(headerView);

        // Setting up list

        setUpExpList();

        expandableListAdapter= new ExpandableListAdapter(this, listGroupTitles, listDataMembers);

        // Setting list adapter

        expListView.setAdapter(expandableListAdapter);



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
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setSupportActionBar(Toolbar toolbar) {
    }


    private void setUpExpList() {

        listGroupTitles= new ArrayList<PlaceNum>();

        listDataMembers= new HashMap<String, List<PlaceNum>>();

        // Adding province names and number of population as groups

        listGroupTitles.add(new PlaceNum("Week 1",null,"null","null"));
        listGroupTitles.add(new PlaceNum("Week 2",null,"null","null"));
        listGroupTitles.add(new PlaceNum("Week 3",null,"null","null"));
        listGroupTitles.add(new PlaceNum("Week 4",null,"null","null"));
        /*listGroupTitles.add(new PlaceNum("Week2",208990));
        listGroupTitles.add(new PlaceNum("Week3",208990));
        listGroupTitles.add(new PlaceNum("Week4",208990));*/

        // Adding district names and number of population as children

        List<PlaceNum> p1Districts= new ArrayList<PlaceNum>();

        p1Districts.add(new PlaceNum("WeekDays","Village","Hrs","Asha Worker"));

        p1Districts.add(new PlaceNum("Monday","Kohalr","2.30","Raja"));
        p1Districts.add(new PlaceNum("Tuesday","Kohalr","2.30","Raja"));
        p1Districts.add(new PlaceNum("Wednesday","Kohalr","2.30","Raja"));
        p1Districts.add(new PlaceNum("Thursday","Kohalr","2.30","Raja"));
        p1Districts.add(new PlaceNum(" Friday","Kohalr","2.30","Raja"));
        p1Districts.add(new PlaceNum(" Saturday","Kohalr","2.30","Raja"));

      //  p1Districts.add(new PlaceNum("Mokkompol", 48333));

        List<PlaceNum> p2Districts= new ArrayList<PlaceNum>();

        p2Districts.add(new PlaceNum("WeekDays","Village","Hrs","Asha Worker"));

        p2Districts.add(new PlaceNum("Monday","Kohalr","2.30","Raja"));
        p2Districts.add(new PlaceNum("Tuesday","Kohalr","2.30","Raja"));
        p2Districts.add(new PlaceNum("Wednesday","Kohalr","2.30","Raja"));
        p2Districts.add(new PlaceNum("Thursday","Kohalr","2.30","Raja"));
        p2Districts.add(new PlaceNum(" Friday","Kohalr","2.30","Raja"));
        p2Districts.add(new PlaceNum(" Saturday","Kohalr","2.30","Raja"));

        listDataMembers.put(listGroupTitles.get(0).getPlace(), p1Districts);
        listDataMembers.put(listGroupTitles.get(1).getVillage(), p1Districts);
        listDataMembers.put(listGroupTitles.get(2).getHrs(), p1Districts);
        listDataMembers.put(listGroupTitles.get(3).getHrs(), p1Districts);

        listDataMembers.put(listGroupTitles.get(1).getPlace(),p2Districts);
        listDataMembers.put(listGroupTitles.get(2).getPlace(),p2Districts);
        listDataMembers.put(listGroupTitles.get(3).getPlace(),p2Districts);

    }

}
