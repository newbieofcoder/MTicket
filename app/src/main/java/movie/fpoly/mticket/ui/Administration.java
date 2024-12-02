package movie.fpoly.mticket.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import movie.fpoly.mticket.R;

public class Administration extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Quản lý người dùng");
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_users) {
            toolbar.setTitle("Quản lý người dùng");
        } else if (id == R.id.nav_booking) {
            toolbar.setTitle("Quản lý vé");
        } else if (id == R.id.nav_movies) {
            toolbar.setTitle("Quản lý phim");
        } else if (id == R.id.nav_categories) {
            toolbar.setTitle("Quản lý thể loại");
        } else if (id == R.id.nav_seats) {
            toolbar.setTitle("Quản lý ghế ngồi");
        } else if (id == R.id.nav_schedule) {
            toolbar.setTitle("Quản lý lịch chiếu");
        } else if (id == R.id.nav_room) {
            toolbar.setTitle("Quản lý phòng chiếu");
        } else if (id == R.id.nav_cinemas) {
            toolbar.setTitle("Quản lý rạp");
        } else if (id == R.id.nav_logout) {

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment).commit();
    }
}