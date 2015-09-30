package br.com.caelum.testerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.List;

import br.com.caelum.testerecyclerview.adapter.MyAdapterSorteados;
import br.com.caelum.testerecyclerview.application.RecyclerApplication;

/**
 * Created by matheus on 30/09/15.
 */
public class NumerosSorteadosActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Integer> numeros;
    private RecyclerApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        application = (RecyclerApplication) getApplication();

        numeros = application.getNumerosSorteados();
        recycler = (RecyclerView) findViewById(R.id.recycler);
        adapter = new MyAdapterSorteados(numeros);

        recycler.setAdapter(adapter);
        layoutManager = new GridLayoutManager(this, 5);

        recycler.setLayoutManager(layoutManager);


    }
}
