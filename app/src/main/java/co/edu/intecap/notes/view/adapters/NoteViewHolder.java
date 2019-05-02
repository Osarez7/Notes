package co.edu.intecap.notes.view.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import co.edu.intecap.notes.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView txtNoteName;
        TextView txtNoteDescription;
        TextView txtNoteDate;
        ImageView imageView;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNoteName = itemView.findViewById(R.id.txt_note_name);
            txtNoteDescription = itemView.findViewById(R.id.txt_note_description);
            txtNoteDate = itemView.findViewById(R.id.txt_date);
            imageView = itemView.findViewById(R.id.iv_note);
        }
    }