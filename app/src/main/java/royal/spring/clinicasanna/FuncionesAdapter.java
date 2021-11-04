package royal.spring.clinicasanna;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

import royal.spring.clinicasanna.clases.FuncionesVitales;

public class FuncionesAdapter extends RecyclerView.Adapter<FuncionesAdapter.ViewHolderVentaDelDia> {


    ArrayList<FuncionesVitales> listaVentasdeldia;
    Context mContext;



    public FuncionesAdapter(ArrayList<FuncionesVitales> listaVentasdeldia, Context mContext) {

        this.listaVentasdeldia = listaVentasdeldia;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public FuncionesAdapter.ViewHolderVentaDelDia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, null, false);
        return new FuncionesAdapter.ViewHolderVentaDelDia(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FuncionesAdapter.ViewHolderVentaDelDia holder, int position) {
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        final DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        final FuncionesAdapter.ViewHolderVentaDelDia viewHolder = (FuncionesAdapter.ViewHolderVentaDelDia) holder;
        final FuncionesVitales item = listaVentasdeldia.get(position);
        // holder.TxtNombrePedido.setText(item.getIdVenta());

        holder.textView.setText(item.getPaciente());
        holder.TxtFecha.setText(item.getFecha());
        holder.txtdireccionPedido.setText(item.getDireccion());
        holder.txtEstadoPedido.setText(item.getEstado());
        holder.NroDco.setText(item.getMédico());
        holder.TxtMontoTotal.setText("000000000"+item.getIdFuncionVital());



    }


    @Override
    public int getItemCount() {
        return listaVentasdeldia.size();
    }

    public class ViewHolderVentaDelDia extends RecyclerView.ViewHolder {
        TextView txtNombrellegada, txtdireccionPedido, NroDco, txtEstadoPedido, TxtMontoTotal, TxtFecha;
        TextView tiempo, textView;

        public ViewHolderVentaDelDia(View itemView) {
            super(itemView);
            // TxtNombrePedido = itemView.findViewById(R.id.shopping_cart_item_name_text_view);


            txtdireccionPedido = itemView.findViewById(R.id.txtdireccionPedido);
            txtEstadoPedido = itemView.findViewById(R.id.txtEstadoPedido);
            TxtFecha = itemView.findViewById(R.id.TxtFecha);
            NroDco = itemView.findViewById(R.id.NroDco);
            TxtMontoTotal = itemView.findViewById(R.id.TxtMontoTotal);
            tiempo = itemView.findViewById(R.id.tiempo);
            textView = itemView.findViewById(R.id.TxtTest);
        }
    }
}