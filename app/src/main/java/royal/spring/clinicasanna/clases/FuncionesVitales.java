package royal.spring.clinicasanna.clases;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "FuncionesVitales")
public class FuncionesVitales {

    @DatabaseField(columnName = "IdFuncionVital",generatedId = true)
    private int IdFuncionVital;
    @DatabaseField(columnName = "Campo")
    private int Campo;

}
