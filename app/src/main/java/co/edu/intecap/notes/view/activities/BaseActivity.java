package co.edu.intecap.notes.view.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import co.edu.intecap.notes.R;

public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;


    protected void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
    }

    protected void setToolbarTitle(int title) {
        getSupportActionBar().setTitle(title);
    }
}
