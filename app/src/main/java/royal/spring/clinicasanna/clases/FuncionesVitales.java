package royal.spring.clinicasanna.clases;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "FuncionesVitales")
public class FuncionesVitales {

    @DatabaseField(columnName = "IdFuncionVital",generatedId = true)
    private int IdFuncionVital;
    @DatabaseField(columnName = "Campo")
    private int Campo;
    private String Paciente;
    private String Direccion;
    private String Fecha;
    private String Estado;
    private String Médico;

    public int getIdFuncionVital() {
        return IdFuncionVital;
    }




    public void setIdFuncionVital(int idFuncionVital) {
        IdFuncionVital = idFuncionVital;
    }

    public int getCampo() {
        return Campo;
    }

    public void setCampo(int campo) {
        Campo = campo;
    }


    public FuncionesVitales(int idFuncionVital, int campo, String paciente, String direccion, String fecha, String estado, String médico) {
        IdFuncionVital = idFuncionVital;
        Campo = campo;
        Paciente = paciente;
        Direccion = direccion;
        Fecha = fecha;
        Estado = estado;
        Médico = médico;
    }

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String paciente) {
        Paciente = paciente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getMédico() {
        return Médico;
    }

    public void setMédico(String médico) {
        Médico = médico;
    }
}
