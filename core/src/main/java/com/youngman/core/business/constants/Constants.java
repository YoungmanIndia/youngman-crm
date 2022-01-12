package com.youngman.core.business.constants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Currency;
import java.util.Locale;

public class Constants {

    public static final Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
    public static final Charset UTF_8 = StandardCharsets.UTF_8;

    public final static String TEST_ENVIRONMENT = "TEST";
    public final static String PRODUCTION_ENVIRONMENT = "PROD";
    public final static String CRM_URI = "/crm";

    public static final String ALL_REGIONS = "*";


    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public final static String DEFAULT_DATE_FORMAT_YEAR = "yyyy";
    public final static String DEFAULT_LANGUAGE = "en";
    public final static String DEFAULT_COUNTRY = "IN";

    public final static String EMAIL_CONFIG = "EMAIL_CONFIG";

    public final static String UNDERSCORE = "_";
    public final static String SLASH = "/";
    public final static String TRUE = "true";
    public final static String FALSE = "false";
    public final static String OT_ITEM_PRICE_MODULE_CODE = "itemprice";
    public final static String OT_SUBTOTAL_MODULE_CODE = "subtotal";
    public final static String OT_TOTAL_MODULE_CODE = "total";

    public final static String DEFAULT_STORE = "DEFAULT";

    public final static Locale DEFAULT_LOCALE = Locale.US;
    public final static Currency DEFAULT_CURRENCY = Currency.getInstance(Locale.US);

    public final static String PAYMENT_MODULES = "PAYMENT";


    public final static String GROUP_ADMIN = "ADMIN";
    public final static String PERMISSION_AUTHENTICATED = "AUTH";
    public final static String PERMISSION_CUSTOMER_AUTHENTICATED = "AUTH_CUSTOMER";
    public final static String GROUP_SUPERADMIN = "SUPERADMIN";
    public final static String GROUP_ADMIN_CATALOGUE = "ADMIN_CATALOGUE";
    public final static String GROUP_ADMIN_ORDER = "ADMIN_ORDER";
    public final static String GROUP_ADMIN_RETAIL = "ADMIN_RETAIL";
    public final static String GROUP_CUSTOMER = "CUSTOMER";
    public final static String GROUP_SHIPPING = "SHIPPING";
    public final static String ANONYMOUS_CUSTOMER = "ANONYMOUS_CUSTOMER";

}
