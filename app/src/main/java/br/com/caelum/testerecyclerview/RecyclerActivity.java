package br.com.caelum.testerecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.testerecyclerview.adapter.MyAdapter;
import br.com.caelum.testerecyclerview.application.RecyclerApplication;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerApplication application;
    private int valor = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        application = new RecyclerApplication();

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 5);
        recycler.setLayoutManager(layoutManager);


        List<Integer> numeros = new ArrayList<>();

        for (int i = 1; i <= 75; i++) {
            numeros.add(i);
        }
        adapter = new MyAdapter(numeros, this);

        recycler.setItemAnimator(new DefaultItemAnimator());

        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.numeros_sorteados) {
            Intent intent = new Intent(this, NumerosSorteadosActivity.class);
            startActivity(intent);
            return true;
        } if (id == R.id.troca_layout) {
            valor ++;
            layoutManager =  valor % 2 == 0 ? new GridLayoutManager(this, 3) :  new LinearLayoutManager(this);
            recycler.setLayoutManager(layoutManager);

        }



        return super.onOptionsItemSelected(item);
    }
}
