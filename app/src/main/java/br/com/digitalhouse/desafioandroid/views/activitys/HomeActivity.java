package br.com.digitalhouse.desafioandroid.views.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.desafioandroid.Interface.RecyclerViewOnClick;
import br.com.digitalhouse.desafioandroid.R;
import br.com.digitalhouse.desafioandroid.adapter.RestauranteAdapter;
import br.com.digitalhouse.desafioandroid.model.Pratos;
import br.com.digitalhouse.desafioandroid.model.Restaurantes;

public class HomeActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private RecyclerView recyclerHome;
    private RestauranteAdapter restauranteAdapter;
    public static final String RESTAURANTE_KEY = "restaurante";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupToolbar();
        initViews();

        initAdapterManager();

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(HomeActivity.this, CadastroActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<Restaurantes> popularRestaurantes() {
        List<Restaurantes> listaDeRestaurantes = new ArrayList<>();
        listaDeRestaurantes.add(new Restaurantes(R.drawable.restaurante01, "Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", popularListaPratos()));
        listaDeRestaurantes.add(new Restaurantes(R.drawable.restaurante02, "Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", popularListaPratos()));
        listaDeRestaurantes.add(new Restaurantes(R.drawable.restaurante03, "Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", popularListaPratos()));
        listaDeRestaurantes.add(new Restaurantes(R.drawable.restaurante04, "Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", popularListaPratos()));

        return listaDeRestaurantes;
    }

    public List<Pratos> popularListaPratos() {
        List<Pratos> listaDePratos = new ArrayList<>();
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        return listaDePratos;
    }

    private void initViews() {
        recyclerHome = findViewById(R.id.recyclerHome);
    }

    @Override
    public void onClick(Restaurantes restaurantes) {
        Intent intent = new Intent(HomeActivity.this, CardapioRestauranteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANTE_KEY, restaurantes);
        intent.putExtra(RESTAURANTE_KEY, restaurantes);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initAdapterManager() {
        restauranteAdapter = new RestauranteAdapter(popularRestaurantes(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerHome.setAdapter(restauranteAdapter);
        recyclerHome.setLayoutManager(linearLayoutManager);
    }
}