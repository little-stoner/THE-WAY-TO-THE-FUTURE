package _enums.menu;


import _onjava.Enums;

public enum  SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    Security[] values;
    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }
        enum Bond implements Security {
            MUNICIPLA, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

}
