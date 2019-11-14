package br.com.digitalhouse.desafioandroid.adapter;


import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.desafioandroid.Interface.RecyclerPratosViewOnClick;
import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.model.Pratos;

public class PratosAdapter extends RecyclerView.Adapter<PratosAdapter.ViewHolder> {
    private List<Pratos> listaDePratos;
    private RecyclerPratosViewOnClick listener;

    public PratosAdapter(List<Pratos> listaDePratos, RecyclerPratosViewOnClick listener) {
        this.listaDePratos = listaDePratos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pratos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Pratos pratos = listaDePratos.get(position);
        holder.bind(pratos);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(pratos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDePratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomePrato;
        private ImageView imagemPrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemPrato = itemView.findViewById(R.id.imagemPrato);
            nomePrato = itemView.findViewById(R.id.nomeDoPrato);

        }

        public void bind(Pratos pratos) {

            Drawable drawable = itemView.getResources().getDrawable(pratos.getImagemPrato());
            imagemPrato.setImageDrawable(drawable);
            nomePrato.setText(pratos.getNomePrato());

        }
    }
}