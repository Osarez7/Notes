package co.edu.intecap.notes.view.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

import co.edu.intecap.notes.R;
import co.edu.intecap.notes.model.datamodels.Note;
import co.edu.intecap.notes.model.repositories.NotesRepository;
import co.edu.intecap.notes.view.listeners.NoteFormEventListener;

public class NoteFormFragment extends Fragment {

    public static final String ARG_NOTE_ID = "arg_note_id";
    private Button btnAddNote;
    private TextInputLayout inputNotoTitle;
    private TextInputLayout inputNoteDescription;
    private Switch swtichNoteFavorite;
    private static final int EMPTY_NOTE = -1;
    private int noteId = EMPTY_NOTE;
    private Note note = null;
    private NoteFormEventListener noteFormEventListener;


    public static Fragment getInstance(int noteId) {
        NoteFormFragment fragment = new NoteFormFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_NOTE_ID, noteId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            noteId = arguments.getInt(ARG_NOTE_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note_form, container, false);

        btnAddNote = view.findViewById(R.id.btn_add_note);
        inputNotoTitle = view.findViewById(R.id.input_note_title);
        inputNoteDescription = view.findViewById(R.id.input_note_description);
        swtichNoteFavorite = view.findViewById(R.id.sw_note_favorite);

        setupNoteInfo(noteId);
        setupBtnAddNote();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NoteFormEventListener){
            noteFormEventListener = (NoteFormEventListener)context;
        }
    }

    private void setupBtnAddNote() {
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noteId == EMPTY_NOTE) {
                    NotesRepository.NOTES_LIST.add(new Note(inputNotoTitle.getEditText().getText().toString(),
                            inputNoteDescription.getEditText().getText().toString(),
                            null, new Date(), swtichNoteFavorite.isChecked()
                    ));
                } else {
                    if (note != null) {
                        note.setName(inputNotoTitle.getEditText().getText().toString());
                        note.setDescription(inputNoteDescription.getEditText().getText().toString());
                        note.setFavorite(swtichNoteFavorite.isChecked());
                    }
                }

                if(noteFormEventListener != null){
                    noteFormEventListener.onAddNote();
                }
            }
        });
    }


    private void setupNoteInfo(int noteId) {
        if (noteId != EMPTY_NOTE) {
            note = NotesRepository.NOTES_LIST.get(noteId);
            inputNotoTitle.getEditText().setText(note.getName());
            inputNoteDescription.getEditText().setText(note.getDescription());
            swtichNoteFavorite.setChecked(note.isFavorite());
        }
    }

}
