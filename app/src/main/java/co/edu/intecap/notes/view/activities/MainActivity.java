package co.edu.intecap.notes.view.activities;

import co.edu.intecap.notes.R;
import co.edu.intecap.notes.view.fragments.NoteFormFragment;
import co.edu.intecap.notes.view.fragments.NoteListFragment;
import co.edu.intecap.notes.view.listeners.NoteEventListener;
import co.edu.intecap.notes.view.listeners.NoteFormEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity implements NoteEventListener, NoteFormEventListener {
    FrameLayout noteFormContainer;
    private FloatingActionButton fabAddNote;
    private NoteListFragment noteListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteFormContainer = findViewById(R.id.note_form_container);
        setupToolbar();
        setToolbarTitle(R.string.app_name);
        includeListFragment();
        setupActionButton();

    }

    private void setupActionButton() {
        fabAddNote = findViewById(R.id.btn_add_note);
        fabAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteFormActivity.class);
                startActivity(intent);
            }
        });
    }

    private void includeListFragment() {

        noteListFragment = new NoteListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.note_list_container, noteListFragment)
                .commit();
    }


    @Override
    public void onClickNote(int noteId) {
        if (noteFormContainer == null) {
            Intent intent = new Intent(MainActivity.this, NoteFormActivity.class);
            intent.putExtra(NoteFormActivity.EXTRA_NOTE_ID, noteId);
            startActivity(intent);
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.note_form_container, NoteFormFragment.getInstance(noteId))
                    .commit();
        }
    }


    @Override
    public void onAddNote() {
        if(noteListFragment != null){
            noteListFragment.update();
        }

    }
}
