package co.edu.intecap.notes.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.edu.intecap.notes.R;
import co.edu.intecap.notes.model.datamodels.Note;
import co.edu.intecap.notes.model.repositories.NotesRepository;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class NoteFormActivity extends BaseActivity {
    private Button btnAddNote;
    private TextInputLayout inputNotoTitle;
    private TextInputLayout inputNoteDescription;
    private Switch swtichNoteFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_form);

        btnAddNote = findViewById(R.id.btn_add_note);
        inputNotoTitle = findViewById(R.id.input_note_title);
        inputNotoTitle.getEditText().setSelection(0);

                inputNoteDescription = findViewById(R.id.input_note_description);
        swtichNoteFavorite = findViewById(R.id.sw_note_favorite);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotesRepository.NOTES_LIST.add(new Note(inputNotoTitle.getEditText().getText().toString(),
                        inputNoteDescription.getEditText().getText().toString(),
                        null, new Date(), swtichNoteFavorite.isChecked()
                ));

                finish(); // cerrar esta activity
            }
        });

    }
}
