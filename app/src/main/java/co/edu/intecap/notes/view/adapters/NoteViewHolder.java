package co.edu.intecap.notes.view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.intecap.notes.R;
import co.edu.intecap.notes.view.listeners.NoteEventListener;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private final NoteEventListener noteEventListener;
    TextView txtNoteTitle;
        TextView txtNoteDescription;
        TextView txtNoteDate;
        ImageView imageView;


        public NoteViewHolder(@NonNull View itemView, final NoteEventListener noteEventListener) {
            super(itemView);
            this.noteEventListener = noteEventListener;
            txtNoteTitle = itemView.findViewById(R.id.txt_note_title);
            txtNoteDescription = itemView.findViewById(R.id.txt_note_description);
            txtNoteDate = itemView.findViewById(R.id.txt_date);
            imageView = itemView.findViewById(R.id.iv_note);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(noteEventListener != null){
                        noteEventListener.onClickNote(getAdapterPosition());
                    }
                }
            });
        }
    }