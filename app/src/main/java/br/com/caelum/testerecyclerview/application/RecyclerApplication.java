package br.com.caelum.testerecyclerview.application;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matheus on 30/09/15.
 */
public class RecyclerApplication extends Application {

    private List<Integer> numerosSorteados;

    public RecyclerApplication() {
        numerosSorteados = new ArrayList<>();
    }

    public void adicionaNumero(int numero) {
        numerosSorteados.add(numero);
    }

    public List<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }
}
