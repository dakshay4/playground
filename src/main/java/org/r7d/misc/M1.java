package org.r7d.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M1 {

    public static void main(String[] args) {
        String s = ";";
        Foo foo = new Foo() {
            @Override
            public String getMyAss() {
                return "Ass";
            }

            @Override
            public Integer getMyL() {
                return null;
            }
        };
        System.out.println(foo.getMyAss());
        Object[] a = new Object[]{1,2,3,null};
        Object[] b = new Object[]{1,2,3,4};

        populateClassFields(List.of(a,b));
        Boolean res = getAuditedScopeForQuery(new boolean[]{false});
        System.out.println("REsss - "+ res);
    }

    public static void populateClassFields(List<Object[]> result) {
        if (!result.isEmpty()) {
            result.parallelStream().forEach(entry -> {
                if(entry==null) return;
                List<Object> fields = Arrays.asList(entry);
                Integer dutyId = (Integer) fields.get(0);
                /* auditDone i.e. 1st index field is unused */
                Integer issueType = (Integer) fields.get(2);
                Integer tripId = (Integer) fields.get(3);
            });
        }
    }

    private static Boolean getAuditedScopeForQuery(boolean[] audited) {
        Set<Boolean> audits = new HashSet<>();
        for (boolean b : audited) audits.add(b);
        return audits.isEmpty() || (audits.contains(false) && audits.contains(true) ) ? null : audited[0] ;
    }
}
