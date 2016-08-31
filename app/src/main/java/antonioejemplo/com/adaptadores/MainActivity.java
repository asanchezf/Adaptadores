package antonioejemplo.com.adaptadores;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Tipos> arrayListTipos;
    private ListView lista;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        lista= (ListView) findViewById(R.id.lista);

        arrayListTipos=new ArrayList<Tipos>();

        //El ArrayList se llena con objetos del tipo Tipos
        arrayListTipos.add(new Tipos("HTML 5","Lenguaje html5",R.drawable.html5));
        arrayListTipos.add(new Tipos("JAVA","Lenguaje Java",R.drawable.java));
        arrayListTipos.add(new Tipos("PHP","Lenguaje PHP",R.drawable.php));
        arrayListTipos.add(new Tipos("WORDPRESS","Lengueje WordPress",R.drawable.wp_plugins));
        arrayListTipos.add(new Tipos("XAMPP","Servidor XAMPP",R.drawable.xampp));

        //Creamos un objeto del tipo Adaptador que está personalizado
        adaptador=new Adaptador(MainActivity.this,arrayListTipos);
        //Seteamos el ListView con el Adaptador personalizado
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Se ha seleccionado el elemento "+arrayListTipos.get(i).toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
