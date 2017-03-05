package html;

/**
 * Created by rmuhamed on 5/3/17.
 */

final class TemplateInfo {
    static final String HTML_FILE_URI = "templates/o2banking_sepa_template.html";


    final class TAGs {
        static final String IBAN = "{{IBAN}}";
        static final String AMOUNT = "{{AMOUNT}}";
        static final String TOTAL_AMOUNT = "{{TOTALAMOUNT}}";
        static final String SUBJECT = "{{SUBJECT}}";
        static final String RECIPIENT = "{{RECIPIENT}}";
    }
}
