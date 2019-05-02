package co.edu.intecap.notes.view.activities;

import androidx.fragment.app.FragmentManager;
import co.edu.intecap.notes.R;
import co.edu.intecap.notes.view.fragments.NoteListFragment;

import android.os.Bundle;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setToolbarTitle(R.string.app_name);
        includeListFragment();
    }

    private void includeListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.note_list_container, new NoteListFragment())
                .commit();
    }

}
