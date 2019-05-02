package co.edu.intecap.notes.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.edu.intecap.notes.R;
import co.edu.intecap.notes.model.datamodels.Note;
import co.edu.intecap.notes.model.repositories.NotesRepository;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class NoteFormActivity extends BaseActivity {
    public static final String EXTRA_NOTE_ID = "note_id";

    private Button btnAddNote;
    private TextInputLayout inputNotoTitle;
    private TextInputLayout inputNoteDescription;
    private Switch swtichNoteFavorite;
    private static final int EMPTY_NOTE = -1;
    private int noteId = EMPTY_NOTE;
    private Note note = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_form);

        btnAddNote = findViewById(R.id.btn_add_note);
        inputNotoTitle = findViewById(R.id.input_note_title);
        inputNotoTitle.getEditText().setSelection(0);

                inputNoteDescription = findViewById(R.id.input_note_description);
        swtichNoteFavorite = findViewById(R.id.sw_note_favorite);

        Intent intent = getIntent();
        if(intent != null){
            noteId = getIntent().getIntExtra(EXTRA_NOTE_ID, EMPTY_NOTE);
        }


        setupNoteInfo(noteId);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(noteId == EMPTY_NOTE){
                   NotesRepository.NOTES_LIST.add(new Note(inputNotoTitle.getEditText().getText().toString(),
                           inputNoteDescription.getEditText().getText().toString(),
                           null, new Date(), swtichNoteFavorite.isChecked()
                   ));
               }else{
                   if(note != null){
                       note.setName(inputNotoTitle.getEditText().getText().toString());
                       note.setDescription(inputNoteDescription.getEditText().getText().toString());
                       note.setFavorite(swtichNoteFavorite.isChecked());
                   }
               }

                finish(); // cerrar esta activity
            }
        });

    }

    private void setupNoteInfo(int noteId) {
        if(noteId != EMPTY_NOTE){
            note =  NotesRepository.NOTES_LIST.get(noteId);
            inputNotoTitle.getEditText().setText(note.getName());
            inputNoteDescription.getEditText().setText(note.getDescription());
            swtichNoteFavorite.setChecked(note.isFavorite());

        }
    }
}
