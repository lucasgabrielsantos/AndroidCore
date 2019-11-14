package br.com.digitalhouse.desafioandroid.views.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.model.Pratos;

public class DetalhePratoActivity extends AppCompatActivity {
    private static final String PRATO_KEY = "prato";
    private ImageView imagemPratos;
    private TextView titulodetalheprato;
    private TextView descricaodetalheprato;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_prato);

        Toolbar toolbar = findViewById(R.id.toolbardetalhe);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (getIntent() != null) {
            Pratos pratos = getIntent().getExtras().getParcelable(PRATO_KEY);
            initViews();
            titulodetalheprato.setText(pratos.getNomePrato());
            descricaodetalheprato.setText(pratos.getDescPrato());

        }
    }

    public void initViews(){
        imagemPratos = findViewById(R.id.imageDetalhePrato);
        titulodetalheprato = findViewById(R.id.titulodetalheprato);
        descricaodetalheprato = findViewById(R.id.descdetalheprato);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        finish();
////        Intent intent = new Intent(DetalhePratoActivity.this,CardapioRestauranteActivity.class);
////        startActivity(intent);
    }
}
