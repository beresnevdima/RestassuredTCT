package org.example.RestassuredTCT.CreditDetails.Preconditions;

import org.example.RestassuredTCT.DB.DBConnection;
import java.io.IOException;

public class PreconditionsFoScripts {
    Long acc = 21100200006917L;
    String reference = "KT500341";
    String DeleteAllValuesFromTheTables =
                    "delete FROM un62.buckets_calc_transaction_cache WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.debt_operation WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.fee_operations WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.min_bill WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.fix_min_bill WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.grace_period WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.interest_charges_v2 WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.late_fee_operations WHERE acc = '"+acc+"';\n" +
                    "delete FROM un62.interest_charges_monthly_aggr WHERE external_id = '"+acc+"';\n" +
                    "delete from contracts.contracts.contract_attrs WHERE reference = '"+reference+"';";

    String PreconditionsFoScript1_1 =
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2023-01-01', '7769690', '*', '"+acc+"', '2023-01-01 12:45:27.000', '2023-01-01 12:45:27.000', 50.00, 0.00, 0.00, NULL, NULL, '2023-01-01 17:14:09.182', '2023-01-01 17:14:09.182');\n" +
            "\n" +
            "INSERT INTO un62.buckets_calc_transaction_cache\n" +
            "(tran_id, tran_date, acc, amount, used_limit_amount, \"type\", fee, term_name, reversed_tran_id, available_balance, overdraft_limit)\n" +
            "VALUES('7769690', '2023-01-01 12:45:27.000', '"+acc+"', 50.00, 50.00, 'DEBIT', 1.00, 'KOTOD07', NULL, 150.00, 200.00);\n" +
            "\n" +
            "INSERT INTO un62.fee_operations\n" +
            "(acc, \"type\", tran_id, tran_date, tran_amount, tran_id_repayment, tran_date_repayment, debt_amount, repayment_amount, date_create, tlm)\n" +
            "VALUES('"+acc+"', 'CASH', '7769690', '2023-01-01 12:45:27.000', 1.00, '*', '2023-01-01 12:45:27.000', 1.00, 0.00, '2023-01-01 17:14:09.176', '2023-01-01 17:14:09.176');\n" +
            "\n" +
            "INSERT INTO un62.grace_period\n" +
            "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
            "VALUES('7769690', '"+acc+"', '2023-01-01', '2023-02-28', NULL, NULL, '2023-01-01 17:14:09.193');";

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
            "VALUES('7769691', '2023-01-02 13:02:25.000', '"+acc+"', 20.00, 20.00, 'CREDIT', 0.00, 'KOTOD07', NULL, 170.00, 200.00);\n" +
            "\n" +
            "INSERT INTO un62.fee_operations\n" +
            "(acc, \"type\", tran_id, tran_date, tran_amount, tran_id_repayment, tran_date_repayment, debt_amount, repayment_amount, date_create, tlm)\n" +
            "VALUES('"+acc+"', 'CASH', '7769690', '2023-01-01 12:45:27.000', 1.00, '7769691', '2023-01-02 13:02:25.000', 0.00, 1.00, '2023-01-01 17:14:09.176', '2023-01-01 17:14:09.176');";

    String PreconditionsFoScript2_1 =
                    "INSERT INTO un62.debt_operation\n" +
                    "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
                    "VALUES('2022-12-01', '7769690', '*', '"+acc+"', '2022-12-01 12:45:27.000', '2022-12-01 12:45:27.000', 50.00, 0.00, 0.00, NULL, NULL, '2022-12-01 12:45:27.000', '2022-12-01 12:45:27.000');\n" +
                    "\n" +
                    "INSERT INTO un62.fee_operations\n" +
                    "(acc, \"type\", tran_id, tran_date, tran_amount, tran_id_repayment, tran_date_repayment, debt_amount, repayment_amount, date_create, tlm)\n" +
                    "VALUES('"+acc+"', 'CASH', '7769690', '2022-12-01 12:45:27.000', 1.00, '*', '2022-12-01 12:45:27.000', 1.00, 0.00, '2022-12-01 12:45:27.000', '2022-12-01 12:45:27.000');\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2022-12-31', '"+acc+"', 0.04, 5.12, 'G', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2023-01-01', '"+acc+"', 0.04, 5.16, 'G', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2023-01-01', '*', '2023-01-01 00:00:00.000', 10.00, 10.00, 50.00, 50.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.grace_period\n" +
                    "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
                    "VALUES('7769690', '"+acc+"', '2022-12-01', '2023-01-31', NULL, NULL, '2022-12-01 12:45:27.000');";

    String PreconditionsFoScript2_2 = PreconditionsFoScript2_1 +
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2022-12-01', '7769690', '7760691', '"+acc+"', '2023-01-01 13:02:25.000', '2022-12-01 12:45:27.000', 43.00, 0.00, 0.00, NULL, 7.00, '2023-01-02 19:22:58.038', '2023-01-01 13:02:25.000');\n" +
            "\n" +
            "INSERT INTO un62.min_bill\n" +
            "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
            "VALUES('"+acc+"', '2023-01-01', '7760691', '2023-01-01 13:02:25.000', 10.00, 3.00, 50.00, 43.00, '2023-01-02 19:22:57.962', NULL, NULL);";

    String PreconditionsFoScript3_1 = PreconditionsFoScript2_1 +
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2022-12-01', '7769690', '7760691', '"+acc+"', '2023-01-01 13:02:25.000', '2022-12-01 12:45:27.000', 40.00, 0.00, 0.00, NULL, 10.00, '2023-01-02 19:22:58.038', '2023-01-01 13:02:25.000');\n" +
            "\n" +
            "INSERT INTO un62.min_bill\n" +
            "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
            "VALUES('"+acc+"', '2023-01-01', '7760691', '2023-01-01 13:02:25.000', 10.00, 0.00, 50.00, 40.00, '2023-01-02 19:22:57.962', NULL, NULL);";

    String PreconditionsFoScript5_1 =
                    "INSERT INTO un62.debt_operation\n" +
                    "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
                    "VALUES('2022-11-01', '7769690', '*', '"+acc+"', '2022-11-01 12:45:27.000', '2022-11-01 12:45:27.000', 50.00, 0.00, 0.00, NULL, NULL, '2022-12-01 12:45:27.000', '2022-12-01 12:45:27.000');\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-12-01', '*', '2022-12-01 00:00:00.000', 10.00, 10.00, 50.00, 50.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2023-01-01', '*', '2023-01-01 00:00:00.000', 12.00, 12.00, 0.00, 0.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2022-12-31', '"+acc+"', 0.04, 5.12, 'R', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2023-01-01', '"+acc+"', 0.04, 0.04, 'D', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.grace_period\n" +
                    "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
                    "VALUES('7769690', '"+acc+"', '2022-11-01', '2022-12-31', NULL, NULL, '2022-12-01 12:45:27.000');";

    String PreconditionsFoScript5_2 = PreconditionsFoScript5_1 +
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2022-11-01', '7769690', '7769691', '"+acc+"', '2023-01-01 13:02:25.000', '2022-11-01 12:45:27.000', 43.00, 0.00, 0.00, NULL, 7.00, '2023-01-02 19:18:42.278', '2023-01-01 13:02:25.000');\n" +
            "\n" +
            "INSERT INTO un62.min_bill\n" +
            "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
            "VALUES('"+acc+"', '2022-12-01', '7769691', '2023-01-01 13:02:25.000', 10.00, 3.00, 50.00, 50.00, '2023-01-02 19:18:42.204', NULL, NULL);";

    String PreconditionsFoScript6_1 =
                    "INSERT INTO un62.debt_operation\n" +
                    "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
                    "VALUES('2022-10-01', '7769690', '*', '"+acc+"', '2022-10-01 12:45:27.000', '2022-10-01 12:45:27.000', 50.00, 0.00, 0.00, NULL, NULL, '2022-10-01 12:45:27.000', '2022-10-01 12:45:27.000');\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-11-01', '*', '2022-11-01 00:00:00.000', 10.00, 10.00, 50.00, 50.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-12-01', '*', '2022-12-01 00:00:00.000', 12.00, 12.00, 0.00, 0.00, '2021-11-18 13:04:10.142', NULL, NULL);\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2023-01-01', '*', '2023-01-01 00:00:00.000', 15.00, 15.00, 0.00, 0.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2022-12-31', '"+acc+"', 0.04, 5.12, 'R', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2023-01-01', '"+acc+"', 0.04, 0.04, 'D', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.grace_period\n" +
                    "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
                    "VALUES('7769690', '"+acc+"', '2022-10-01', '2022-11-30', NULL, NULL, '2022-12-01 12:45:27.000');";

    String PreconditionsFoScript6_2 = PreconditionsFoScript6_1 +
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2022-10-01', '7769690', '7769691', '"+acc+"', '2023-01-01 13:02:25.000', '2022-10-01 12:45:27.000', 43.00, 0.00, 0.00, NULL, 7.00, '2023-01-02 20:51:45.319', '2023-01-01 13:02:25.000');\n" +
            "\n" +
            "INSERT INTO un62.min_bill\n" +
            "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
            "VALUES('"+acc+"', '2022-11-01', '7769691', '2023-01-01 13:02:25.000', 10.00, 3.00, 50.00, 50.00, '2023-01-02 20:51:45.316', NULL, NULL);";

    String PreconditionsFoScript7_1 =
                    "INSERT INTO un62.debt_operation\n" +
                    "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
                    "VALUES('2022-09-01', '7769690', '*', '"+acc+"', '2022-09-01 12:45:27.000', '2022-09-01 12:45:27.000', 50.00, 0.00, 0.00, NULL, NULL, '2022-09-01 12:45:27.000', '2022-09-01 12:45:27.000');\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-10-01', '*', '2022-10-01 00:00:00.000', 10.00, 10.00, 50.00, 50.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-11-01', '*', '2022-11-01 00:00:00.000', 12.00, 12.00, 0.00, 0.00, '2021-11-18 13:04:10.142', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-12-01', '*', '2022-12-01 00:00:00.000', 14.00, 14.00, 0.00, 0.00, '2021-11-18 13:04:10.142', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2023-01-01', '*', '2023-01-01 00:00:00.000', 15.00, 15.00, 0.00, 0.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2022-12-31', '"+acc+"', 0.04, 5.12, 'R', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2023-01-01', '"+acc+"', 0.04, 0.04, 'D', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.grace_period\n" +
                    "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
                    "VALUES('7769690', '"+acc+"', '2022-09-01', '2022-10-31', NULL, NULL, '2022-12-01 12:45:27.000');";

    String PreconditionsFoScript7_2 = PreconditionsFoScript7_1 +
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2022-09-01', '7769690', '7769691', '"+acc+"', '2023-01-01 13:02:25.000', '2022-09-01 12:45:27.000', 43.00, 0.00, 0.00, NULL, 7.00, '2023-01-02 21:31:29.767', '2023-01-01 13:02:25.000');\n" +
            "\n" +
            "INSERT INTO un62.min_bill\n" +
            "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
            "VALUES('"+acc+"', '2022-10-01', '7769691', '2023-01-01 13:02:25.000', 10.00, 3.00, 50.00, 50.00, '2023-01-02 21:31:29.708', NULL, NULL);";

    String PreconditionsFoScript8_1 =
                    "INSERT INTO un62.debt_operation\n" +
                    "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
                    "VALUES('2022-08-01', '7769690', '*', '"+acc+"', '2022-08-01 12:45:27.000', '2022-08-01 12:45:27.000', 50.00, 0.00, 0.00, NULL, NULL, '2022-08-01 12:45:27.000', '2022-08-01 12:45:27.000');\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-09-01', '*', '2022-09-01 00:00:00.000', 10.00, 10.00, 50.00, 50.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-10-01', '*', '2022-10-01 00:00:00.000', 11.00, 11.00, 0.00, 0.00, '2021-11-18 13:04:10.142', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-11-01', '*', '2022-11-01 00:00:00.000', 12.00, 12.00, 0.00, 0.00, '2021-11-18 13:04:10.142', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2022-12-01', '*', '2022-12-01 00:00:00.000', 14.00, 14.00, 0.00, 0.00, '2021-11-18 13:04:10.142', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.min_bill\n" +
                    "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
                    "VALUES('"+acc+"', '2023-01-01', '*', '2023-01-01 00:00:00.000', 15.00, 15.00, 0.00, 0.00, '2023-01-01 00:25:00.000', NULL, NULL);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2022-12-31', '"+acc+"', 0.04, 5.12, 'R', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.interest_charges_v2\n" +
                    "(date_calc, acc, interest, accum, state, amount, debit, credit, is_double, is_end_of_grace, rate, client_id)\n" +
                    "VALUES('2023-01-01', '"+acc+"', 0.04, 0.04, 'D', 50.00, 0.00, 0.00, NULL, NULL, 25.90, 500341);\n" +
                    "\n" +
                    "INSERT INTO un62.grace_period\n" +
                    "(tran_id, acc, grace_start, grace_end, tran_id_repaid, grace_repaid, tlm)\n" +
                    "VALUES('7769690', '"+acc+"', '2022-08-01', '2022-09-30', NULL, NULL, '2022-12-01 12:45:27.000');\n";

    String PreconditionsFoScript8_2 = PreconditionsFoScript8_1 +
            "INSERT INTO un62.debt_operation\n" +
            "(date_calc, tran_id, tran_id_repayment, acc, tran_date_time, debt_date_time, amt_debt, interest_rate, interest, count_day, amt_repayment, tlm, tran_tlm)\n" +
            "VALUES('2022-08-01', '7769690', '7769691', '"+acc+"', '2023-01-01 13:02:25.000', '2022-08-01 12:45:27.000', 43.00, 0.00, 0.00, NULL, 7.00, '2023-01-02 21:48:33.916', '2023-01-01 13:02:25.000');\n" +
            "\n" +
            "INSERT INTO un62.min_bill\n" +
            "(acc, billing_date, tran_id_repaid, date_time_repaid, bill, outstanding_bill, grace_bill, grace_outstanding_bill, tlm, lp_done, lp_done_date)\n" +
            "VALUES('"+acc+"', '2022-09-01', '7769691', '2023-01-01 13:02:25.000', 10.00, 3.00, 50.00, 50.00, '2023-01-02 21:48:33.913', NULL, NULL);\n";


            DBConnection sqlConnection = new DBConnection();
    public PreconditionsFoScripts() throws IOException {}

    public void deleteAllValuesFromTheTables (){
        sqlConnection.doUpdate(DeleteAllValuesFromTheTables);
    }

    public void preconditionsFoScript1_1(){
        sqlConnection.doUpdate(PreconditionsFoScript1_1);
    }

    public void preconditionsFoScript1_2(){
        sqlConnection.doUpdate(PreconditionsFoScript1_2);
    }

    public void preconditionsFoScript2_1(){
        sqlConnection.doUpdate(PreconditionsFoScript2_1);
    }

    public void preconditionsFoScript2_2(){
        sqlConnection.doUpdate(PreconditionsFoScript2_2);
    }

    public void preconditionsFoScript3_1(){
        sqlConnection.doUpdate(PreconditionsFoScript3_1);
    }

    public void preconditionsFoScript5_1(){
        sqlConnection.doUpdate(PreconditionsFoScript5_1);
    }

    public void preconditionsFoScript5_2(){
        sqlConnection.doUpdate(PreconditionsFoScript5_2);
    }

    public void preconditionsFoScript6_1(){
        sqlConnection.doUpdate(PreconditionsFoScript6_1);
    }

    public void preconditionsFoScript6_2(){
        sqlConnection.doUpdate(PreconditionsFoScript6_2);
    }

    public void preconditionsFoScript7_1(){
        sqlConnection.doUpdate(PreconditionsFoScript7_1);
    }

    public void preconditionsFoScript7_2(){
        sqlConnection.doUpdate(PreconditionsFoScript7_2);
    }

    public void preconditionsFoScript8_1(){
        sqlConnection.doUpdate(PreconditionsFoScript8_1);
    }

    public void preconditionsFoScript8_2(){
        sqlConnection.doUpdate(PreconditionsFoScript8_2);
    }

}