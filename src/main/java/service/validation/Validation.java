package service.validation;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Validation implements ValidationInterface {

    private final Logger logger = LogManager.getLogger(Validation.class);
        public static final String WORD_VALIDATION = "[A-Za-z]*";
        public static final String PARAGRAPH_VALIDATION = "[A-Z].*[\\n\\r\\t\\.]";
        public static final String SENTENCE_VALIDATION = "[A-Z][^\\.]*[\\.]";

    public boolean isValid(List<String> list, String regex) {
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).matches(regex)) {
                logger.log(Level.INFO, "line " + i + " is invalid");
                return false;
            }
        }
        return true;
    }

    public List<String> validation(List<String> list){
      return null;
    }


}
