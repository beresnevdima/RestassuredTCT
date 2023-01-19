package org.example.RestassuredTCT.CreditDetails.Preconditions;

import org.example.RestassuredTCT.DB.DBConnection;
import java.io.IOException;

public class PreconditionsFoScripts {
    Long acc = 21100200006917L;
    String DeleteAllValuesFromTheTables =
                    "delete FROM un62.buckets_calc_transaction_cache WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.debt_operation WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.fee_operations WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.min_bill WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.fix_min_bill WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.grace_period WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.interest_charges_v2 WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.late_fee_operations WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.interest_charges_monthly_aggr WHERE external_id = '"+acc+"';";

    String PreconditionsFoScript1_1 =
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2023-01-01', '7769690', '*', '"+acc+"', '2023-01-01 12:45:27.000', '2023-01-01 12:45:27.000', 50.00, 0.00, 0.00, NULL, NULL, '2023-01-01 17:14:09.182', '2023-01-01 17:14:09.182');\n" +
            "\n" +
            "INSERT INTO un62.buckets_calc_transaction_cache\n" +
            "(tran_id, tran_date, acc, amount, used_limit_amount, \"type\", fee, term_name, reversed_tran_id, available_balance, overdraft_limit)\n" +
            "VALUES('7769690', '2023-01-01 12:45:27.000', '"+acc+"', 50.00, 50.00, 'DEBIT', 1.00, 'KOTOD03', NULL, 150.00, 200.00);\n" +
            "\n" +
            "INSERT INTO un62.fee_operations\n" +
            "(acc, \"type\", tran_id, tran_date, tran_amount, tran_id_repayment, tran_date_repayment, debt_amount, repayment_amount, date_create, tlm)\n" +
            "VALUES('"+acc+"', 'CASH', '7769690', '2023-01-01 12:45:27.000', 1.00, '*', '2023-01-01 12:45:27.000', 1.00, 0.00, '2023-01-01 17:14:09.176', '2023-01-01 17:14:09.176');\n" +
            "\n" +
            "INSERT INTO un62.grace_period\n" +
            "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
            "VALUES('7769690', '"+acc+"', '2023-01-01', '2023-02-28', NULL, NULL, '2023-01-01 17:14:09.193');\n";

    String PreconditionsFoScript1_2 = PreconditionsFoScript1_1 +
            "INSERT INTO un62.interest_charges_v2\n" +
            "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
            "VALUES('2023-01-01', '"+acc+"', 0.04, 0.04, 'G', 50.00, 50.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
            "\n" +
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2023-01-01', '7769690', '7769691', '"+acc+"', '2023-01-02 13:02:25.000', '2023-01-01 12:45:27.000', 30.00, 0.00, 0.00, NULL, 20.00, '2023-01-02 17:13:40.378', '2023-01-02 13:02:25.000');\n" +
            "\n" +
            "INSERT INTO un62.buckets_calc_transaction_cache\n" +
            "(tran_id, tran_date, acc, amount, used_limit_amount, \"type\", fee, term_name, reversed_tran_id, available_balance, overdraft_limit)\n" +
            "VALUES('7769691', '2023-01-02 13:02:25.000', '"+acc+"', 20.00, 20.00, 'CREDIT', 0.00, 'KOTOD03', NULL, 170.00, 200.00);\n" +
            "\n" +
            "INSERT INTO un62.fee_operations\n" +
            "(acc, \"type\", tran_id, tran_date, tran_amount, tran_id_repayment, tran_date_repayment, debt_amount, repayment_amount, date_create, tlm)\n" +
            "VALUES('"+acc+"', 'CASH', '7769690', '2023-01-01 12:45:27.000', 1.00, '7769691', '2023-01-02 13:02:25.000', 0.00, 1.00, '2023-01-01 17:14:09.176', '2023-01-01 17:14:09.176');";

    DBConnection sqlConnection = new DBConnection();
    public PreconditionsFoScripts() throws IOException {}

    public void DeleteAllValuesFromTheTables (){
        sqlConnection.doUpdate(DeleteAllValuesFromTheTables);
    }

    public void PreconditionsFoScript1_1(){
        sqlConnection.doUpdate(PreconditionsFoScript1_1);
    }

    public void PreconditionsFoScript1_2(){
        sqlConnection.doUpdate(PreconditionsFoScript1_2);
    }

}