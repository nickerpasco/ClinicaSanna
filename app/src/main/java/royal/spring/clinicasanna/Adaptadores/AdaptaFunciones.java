package royal.spring.clinicasanna.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import royal.spring.clinicasanna.R;
import royal.spring.clinicasanna.clases.FuncionesVitales;

public class AdaptaFunciones extends RecyclerView.Adapter<AdaptaFunciones.MyHolder> {
    List<FuncionesVitales> lista;
    Context contexto;

    public AdaptaFunciones(List<FuncionesVitales> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_funciones, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final FuncionesVitales funcionesVitales = lista.get(position);
        //holder._txtProducto.setText(productoObj.getProducto());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        // TextView _txtProducto;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //  _txtProducto = itemView.findViewById(R.id.txtProductoPd);
        }
    }

}
