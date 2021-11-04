package royal.spring.clinicasanna.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
        final FuncionesVitales funcionesV = lista.get(position);

        /*
        holder.txtPaciente.setText((1+position)+". "+ funcionesV.getPaciente());
        holder.txtComentario.setText(funcionesV.getComentario());
        holder.txtPeso.setText(String.valueOf(funcionesV.getPeso()));
        holder.txtTalla.setText(String.valueOf(funcionesV.getTalla()));
        holder.txtTemperatura.setText(String.valueOf(funcionesV.getTemperatura()));
        holder.txtSaturacion.setText(String.valueOf(funcionesV.getSaturacion()));
        holder.txtIMC.setText(String.valueOf(funcionesV.getIMC()));
        holder.txtComentario.setSelected(true);

         */
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtPaciente, txtComentario, txtTalla, txtPeso, txtTemperatura, txtSaturacion,txtIMC;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txtPaciente = itemView.findViewById(R.id.txtPaciente);
            txtComentario = itemView.findViewById(R.id.txtComentario);
            txtTalla = itemView.findViewById(R.id.txtTalla);
            txtPeso = itemView.findViewById(R.id.txtPeso);
            txtTemperatura = itemView.findViewById(R.id.txtTemperatura);
            txtSaturacion = itemView.findViewById(R.id.txtSaturacion);
            txtIMC = itemView.findViewById(R.id.txtIMC);
        }
    }
}
