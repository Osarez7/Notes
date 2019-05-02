package co.edu.intecap.notes.view.activities;

import co.edu.intecap.notes.R;
import co.edu.intecap.notes.view.fragments.NoteFormFragment;
import co.edu.intecap.notes.view.listeners.NoteFormEventListener;

import android.content.Intent;
import android.os.Bundle;

public class NoteFormActivity extends BaseActivity implements NoteFormEventListener {

    public static final String EXTRA_NOTE_ID = "note_id";
    private int EMPTY_NOTE = -1;
    private int noteId = EMPTY_NOTE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_form);

        Intent intent = getIntent();
        if(intent != null){
            noteId = getIntent().getIntExtra(EXTRA_NOTE_ID, EMPTY_NOTE);
        }

        includeNoteDetailFragment(noteId);
    }

    private void includeNoteDetailFragment(int noteId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.note_form_container, NoteFormFragment.getInstance(noteId))
                .commit();
    }

    @Override
    public void onAddNote() {
        finish();
    }
}
