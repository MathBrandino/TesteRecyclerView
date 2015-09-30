package br.com.caelum.testerecyclerview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.testerecyclerview.R;
import br.com.caelum.testerecyclerview.application.RecyclerApplication;

/**
 * Created by matheus on 28/09/15.
 */
public class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    private List<Integer> numeros;
    private Activity activity;

    public MyAdapter(List<Integer> numeros, Activity activity) {
        this.numeros = numeros;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        String numero = String.valueOf(numeros.get(position));
        viewHolder.numero.setText(numero);
    }

    @Override
    public int getItemCount() {
        return numeros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView numero;

        public ViewHolder(final View view) {
            super(view);
            this.numero = (TextView) view.findViewById(R.id.numero);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    RecyclerApplication application = (RecyclerApplication) activity.getApplication();
                    application.adicionaNumero((numeros.get(getAdapterPosition())));
                    numeros.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }

    }
}
