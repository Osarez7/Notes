package co.edu.intecap.notes.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.intecap.notes.R;
import co.edu.intecap.notes.model.datamodels.Note;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    List<Note> noteList = new ArrayList<>();

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.txtNoteName.setText(note.getName());
        holder.txtNoteDescription.setText(note.getDescription());
        holder.txtNoteDate.setText(note.getCreationDate().toString());
        holder.imageView.setImageDrawable(null);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }


    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }


}
