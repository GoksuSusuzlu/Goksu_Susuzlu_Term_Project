package com.example.goksususuzlu_termproject;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ModelCardsAdapter extends RecyclerView.Adapter<ModelCardsAdapter.ViewHolder> {
    private String[] modelNames;
    private int[] modelImageIds;
    private Listener listener;
     interface Listener{
        void onClick(int position);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public ModelCardsAdapter(String[] modelNames, int[] modelImageIds) {
        this.modelNames = modelNames;
        this.modelImageIds = modelImageIds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.model_card,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.card_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(),modelImageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(modelNames[position]);
        TextView textView = cardView.findViewById(R.id.card_text);
        textView.setText(modelNames[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }


    }
}
