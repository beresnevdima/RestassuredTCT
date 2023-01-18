package org.example.RestassuredTCT.DTO.Response;

import lombok.*;

import java.util.ArrayList;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ResponseCreditDetails5_8 {

    private ResponseCreditDetailsBody result;

    @Data
    @AllArgsConstructor
    public static class ResponseCreditDetailsBody {

        private String script;
        private String period;
        private String graceSum;
        private String minPaySum;
        private String minBillSum;
        private String lateFeeSum;
        private String interestOnDebt;
        private String interestRate;
        private String interestCharge;
        private String paymentDue;
        private String expiredSum;
        private String totalSum;
        private String graceEnd;
        private String graceStart;
        private ArrayList expiredBillsDetail;
        private String prevMonth;
        private String penaltySum;
        private String dateOfMonth;
        private String fullRepay;
        private String interestGrace;
        private String paymentState;
        private String cashFee;
        private String transferFee;
        private String contractState;
        private String expiredFixSum;
        private String expiredTotalSum;
        private String otherFees;
    }
}
