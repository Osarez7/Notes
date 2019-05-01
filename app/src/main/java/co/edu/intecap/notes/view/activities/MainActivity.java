package co.edu.intecap.notes.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.intecap.notes.R;
import co.edu.intecap.notes.model.repositories.NotesRepository;
import co.edu.intecap.notes.view.adapters.NotesAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNotes;
    private FloatingActionButton fabAddNote;
    private  NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNotes = findViewById(R.id.rv_notes);
        fabAddNote = findViewById(R.id.btn_add_note);
        fabAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NoteFormActivity.class);
                startActivity(intent);
            }
        });
        setupNoteList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void setupNoteList() {
        rvNotes.setLayoutManager(new LinearLayoutManager(this));

        adapter =  new NotesAdapter();
        adapter.setNoteList(NotesRepository.NOTES_LIST);
        rvNotes.setAdapter(adapter);
    }
}
