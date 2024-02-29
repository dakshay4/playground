package org.r7d.misc;


import org.joda.time.LocalDate;

import java.util.Date;

public class M2 {

    boolean b ;

    public static void main(String[] args) {
        Jstar1();
//        Jstar2();
        Jstar3(new Date());
        Jstar4();
//        JStar5();
        JStar6();
    }

    private static void JStar6() {
        Object[] entry = new Object[]{
                491,
                1,
                0.0,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()),
                1,
                212121,
                12121256,
                121212
        };
        int indexPos=-1;
        Integer cabId = (Integer) entry[++indexPos];
        Integer dutyId = (Integer) entry[++indexPos];
        Double doubleDistance = (Double) entry[++indexPos];
        float distanceTravelled = doubleDistance!=null ? Float.parseFloat(doubleDistance.toString()) : 0f;
        Date reportIn = (Date) entry[++indexPos];
        Date reportOff = (Date) entry[++indexPos];
        Integer billingIssueAuditId = (Integer) entry[++indexPos];
        indexPos++; // Not Used 6th index Because it is similar with 1st Index i.e. dutyId
        int directionSum = entry[++indexPos]!=null ? ((Number) entry[indexPos]).intValue() : 0;
        int directionCount = entry[++indexPos]!=null ? ((Number) entry[indexPos]).intValue() : 0;

        System.out.println("M1{" +
                "cabId=" + cabId +
                ", dutyId=" + dutyId +
                ", doubleDistance=" + doubleDistance +
                ", distanceTravelled=" + distanceTravelled +
                ", reportIn=" + reportIn +
                ", reportOff=" + reportOff +
                ", billingIssueAuditId=" + billingIssueAuditId +
                ", directionSum=" + directionSum +
                ", directionCount=" + directionCount +
                '}');

    }

    private static void JStar5() {
        Object a = null;
        Number num = (Number) (a);
        System.out.println(num.intValue());
    }

    private static void Jstar4() {
        Integer t = null;
        System.out.println(nullSafeCompare(null, null));
    }

    public static <T extends Comparable<? super T>> Integer nullSafeCompare(T c1,T c2) {
        if (c1 == c2) {
            return 0;
        } else if (c1 == null) {
            return -1;
        } else if (c2 == null) {
            return 1;
        }
        return c1.compareTo(c2);
    }

    private static void Jstar3(Date date) {
        LocalDate ld = LocalDate.fromDateFields(date);
        System.out.println(ld.getYear());
        System.out.println(ld.getMonthOfYear());
        System.out.println(ld.getDayOfMonth());
        System.out.println(ld.getDayOfWeek());
    }

    private static void Jstar2() {
        Float m = null;
        float mc = m;
    }

    private static void Jstar1() {
        Object a = false;
        System.out.println((boolean) a);
        M2 m2 = new M2();
        m2.setB((Boolean) a);

//        Integer.parseInt(null);
    }

    public void setB(boolean b) {
        this.b = b;
    }


}
