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

import br.com.digitalhouse.desafioandroid.Interface.RecyclerViewOnClick;
import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.model.Restaurantes;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {
    private List<Restaurantes> listaDeRestaurantes;
    private RecyclerViewOnClick listener;

    public RestauranteAdapter(List<Restaurantes> listaDeRestaurantes, RecyclerViewOnClick listener) {
        this.listaDeRestaurantes = listaDeRestaurantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Restaurantes restaurantes = listaDeRestaurantes.get(position);
        holder.bind(restaurantes);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restaurantes);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDeRestaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagemRestaurante;
        private TextView nomeRestaurante;
        private TextView enderecoRestaurante;
        private TextView horario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemRestaurante = itemView.findViewById(R.id.imagemRestaurante);
            nomeRestaurante = itemView.findViewById(R.id.nomeRestaurante);
            enderecoRestaurante = itemView.findViewById(R.id.enderecoRestaurante);
            horario = itemView.findViewById(R.id.horarioFechamento);

        }

        public void bind(Restaurantes restaurantes) {
            Drawable drawable = itemView.getResources().getDrawable(restaurantes.getImagemRestaurante());
            imagemRestaurante.setImageDrawable(drawable);
            nomeRestaurante.setText(restaurantes.getNomeRestaurante());
            enderecoRestaurante.setText(restaurantes.getEnderecoRestaurante());
            horario.setText(restaurantes.getHorarioFechamento());
        }
    }
}

