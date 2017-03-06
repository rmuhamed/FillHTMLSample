package html;

import java.util.List;

/**
 * Created by romh on 06/03/2017.
 */

public abstract class TemplateInfo {
    protected String HTML_FILE_URI;

    TemplateInfo() {
        HTML_FILE_URI = this.getHtmlFileUri();
    }

    abstract String getHtmlFileUri();

    public abstract List<String> getTags();

}
