package br.com.digitalhouse.desafioandroid.views.activitys;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.Interface.RecyclerPratosViewOnClick;
import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adapter.PratosAdapter;
import br.com.digitalhouse.desafioandroid.model.Pratos;
import br.com.digitalhouse.desafioandroid.model.Restaurantes;

import static br.com.digitalhouse.desafioandroid.views.activitys.HomeActivity.RESTAURANTE_KEY;

public class CardapioRestauranteActivity extends AppCompatActivity implements RecyclerPratosViewOnClick {
    private static final String PRATO_KEY = "prato";
    private ImageView imagemRestaurante;
    private TextView nomeRestaurante;
    private List<Pratos> listaDePratos = new ArrayList<>();
    private RecyclerView recyclerPratos;
    private PratosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio_restaurante);
        initViews();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (getIntent() != null) {
            Restaurantes restaurantes = getIntent().getExtras().getParcelable(RESTAURANTE_KEY);

            if (restaurantes != null) {

                Drawable drawable = getResources().getDrawable(restaurantes.getImagemRestaurante());
                imagemRestaurante.setImageDrawable(drawable);

                nomeRestaurante.setText(restaurantes.getNomeRestaurante());

                listaDePratos = restaurantes.getListaDePratos();

                adapter = new PratosAdapter(listaDePratos, this);

                GridLayoutManager linearLayout = new GridLayoutManager(this, 2);

                recyclerPratos.setAdapter(adapter);

                recyclerPratos.setLayoutManager(linearLayout);
            }
        }
    }

    public void initViews() {
        imagemRestaurante = findViewById(R.id.imagemRestaurante);
        nomeRestaurante = findViewById(R.id.nomeRestaurante);
        recyclerPratos = findViewById(R.id.recyclerPratos);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(Pratos pratos) {
        Intent intent = new Intent(this, DetalhePratoActivity.class);
        intent.putExtra(PRATO_KEY, pratos);

        startActivity(intent);
    }
}
