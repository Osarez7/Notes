package co.edu.intecap.notes.view.fragments;


import android.content.Context;
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
import co.edu.intecap.notes.model.datamodels.Note;
import co.edu.intecap.notes.model.repositories.NotesRepository;
import co.edu.intecap.notes.view.activities.MainActivity;
import co.edu.intecap.notes.view.activities.NoteFormActivity;
import co.edu.intecap.notes.view.adapters.NotesAdapter;
import co.edu.intecap.notes.view.listeners.NoteEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment{

    private RecyclerView rvNotes;
    private NotesAdapter adapter;
    private NoteEventListener noteEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  NoteEventListener){
            noteEventListener = (NoteEventListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        rvNotes = view.findViewById(R.id.rv_notes);
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
        adapter =  new NotesAdapter(noteEventListener);
        adapter.setNoteList(NotesRepository.NOTES_LIST);
        rvNotes.setAdapter(adapter);
    }

    public void update() {
        adapter.notifyDataSetChanged();
    }
}
