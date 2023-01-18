package org.example.RestassuredTCT.CreditDetails.Preconditions;

import org.example.RestassuredTCT.DB.DBConnection;
import java.io.IOException;

public class PreconditionsFoScript0 {
    Long value = 21100200006917L;
    String DeleteAllValuesFromTheTables =
                    "delete FROM un62.buckets_calc_transaction_cache WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.debt_operation WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.fee_operations WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.min_bill WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.fix_min_bill WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.grace_period WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.interest_charges_v2 WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.late_fee_operations WHERE acc = '"+value+"';\n" +
                    "delete FROM un62.interest_charges_monthly_aggr WHERE external_id = '"+value+"';";
    DBConnection sqlConnection = new DBConnection();
    public PreconditionsFoScript0() throws IOException {}

    public void PreconditionsFoTestCase1 (){
        sqlConnection.doUpdate(DeleteAllValuesFromTheTables);
    }

}
