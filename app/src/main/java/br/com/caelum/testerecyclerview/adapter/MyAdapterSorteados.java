package br.com.caelum.testerecyclerview.adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.testerecyclerview.R;

/**
 * Created by matheus on 30/09/15.
 */
public class MyAdapterSorteados extends android.support.v7.widget.RecyclerView.Adapter {

    private List<Integer> numeros;

    public MyAdapterSorteados(List<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_verificador_numeros, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.numero.setText(String.valueOf(numeros.get(position)));

    }

    @Override
    public int getItemCount() {
        return numeros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView numero;

        public ViewHolder(final View itemView) {
            super(itemView);
            numero = (TextView) itemView.findViewById(R.id.numeros_sorteados);
            final CardView cardView = (CardView) numero.getParent();

            numero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardView.setCardBackgroundColor(Color.GREEN);
                }
            });
        }
    }
}
