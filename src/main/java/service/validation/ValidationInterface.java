package service.validation;

import java.util.List;

public interface ValidationInterface {
    boolean isValid(List<String> list, String regex);
}
