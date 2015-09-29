package br.com.caelum.testerecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.testerecyclerview.R;

/**
 * Created by matheus on 28/09/15.
 */
public class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    private List<String> dados;

    public MyAdapter(List<String> dados) {

        this.dados = dados;
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

        viewHolder.nome.setText(dados.get(position));
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nome;

        public ViewHolder(View view) {
            super(view);
            this.nome = (TextView) view.findViewById(R.id.recycler_layout_nome);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("dados = ", dados.get(getAdapterPosition()));
                    dados.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }

    }
}
