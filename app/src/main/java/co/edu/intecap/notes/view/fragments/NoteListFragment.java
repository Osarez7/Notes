package co.edu.intecap.notes.view.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.intecap.notes.R;
import co.edu.intecap.notes.model.repositories.NotesRepository;
import co.edu.intecap.notes.view.activities.MainActivity;
import co.edu.intecap.notes.view.activities.NoteFormActivity;
import co.edu.intecap.notes.view.adapters.NotesAdapter;
import co.edu.intecap.notes.view.listeners.NoteEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment  implements NoteEventListener {

    private RecyclerView rvNotes;
    private FloatingActionButton fabAddNote;
    private NotesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        rvNotes = view.findViewById(R.id.rv_notes);
        fabAddNote = view.findViewById(R.id.btn_add_note);
        fabAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NoteFormActivity.class);
                startActivity(intent);
            }
        });
        setupNoteList();

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void setupNoteList() {
        rvNotes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter =  new NotesAdapter(this);
        adapter.setNoteList(NotesRepository.NOTES_LIST);
        rvNotes.setAdapter(adapter);
    }

    @Override
    public void onClickNote(int noteId) {
        Intent intent = new Intent(getContext(), NoteFormActivity.class);
        intent.putExtra(NoteFormActivity.EXTRA_NOTE_ID, noteId);
        startActivity(intent);

    }

}
