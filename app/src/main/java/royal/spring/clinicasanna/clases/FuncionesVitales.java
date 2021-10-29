package royal.spring.clinicasanna.clases;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "FuncionesVitales")
public class FuncionesVitales {

    @DatabaseField(columnName = "IdFuncionVital",generatedId = true)
    private int IdFuncionVital;
    @DatabaseField(columnName = "Paciente")
    private String Paciente;
    @DatabaseField(columnName = "Temperatura")
    private double Saturacion;
    @DatabaseField(columnName = "Saturacion")
    private double Temperatura;
    @DatabaseField(columnName = "Peso")
    private double Peso;
    @DatabaseField(columnName = "Talla")
    private double Talla;
    @DatabaseField(columnName = "IMC")
    private double IMC;
    @DatabaseField(columnName = "Comentario")
    private String Comentario;

    public int getIdFuncionVital() {
        return IdFuncionVital;
    }

    public void setIdFuncionVital(int idFuncionVital) {
        IdFuncionVital = idFuncionVital;
    }

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String paciente) {
        Paciente = paciente;
    }

    public double getSaturacion() {
        return Saturacion;
    }

    public void setSaturacion(double saturacion) {
        Saturacion = saturacion;
    }

    public double getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(double temperatura) {
        Temperatura = temperatura;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public double getTalla() {
        return Talla;
    }

    public void setTalla(double talla) {
        Talla = talla;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}
