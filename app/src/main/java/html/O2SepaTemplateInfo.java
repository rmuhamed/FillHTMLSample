package html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmuhamed on 5/3/17.
 */

public final class O2SepaTemplateInfo extends TemplateInfo {

    public static final String URI = "templates/o2banking_sepa_template.html";

    @Override
    public String getHtmlFileUri() {
        return URI;
    }

    @Override
    public List<String> getTags() {
        List<String> tagsForTemplate = new ArrayList<>();

        tagsForTemplate.add(TAGs.IBAN);
        tagsForTemplate.add(TAGs.AMOUNT);
        tagsForTemplate.add(TAGs.TOTAL_AMOUNT);
        tagsForTemplate.add(TAGs.SUBJECT);
        tagsForTemplate.add(TAGs.RECIPIENT);

        return tagsForTemplate;
    }

    public final class TAGs {
        static final String IBAN = "{{IBAN}}";
        static final String AMOUNT = "{{AMOUNT}}";
        static final String TOTAL_AMOUNT = "{{TOTALAMOUNT}}";
        static final String SUBJECT = "{{SUBJECT}}";
        static final String RECIPIENT = "{{RECIPIENT}}";
    }
}
