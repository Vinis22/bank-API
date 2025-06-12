package project.bankapp.bank.utils;

import java.util.Optional;
import java.util.function.Supplier;

public class ValidationUtils {

    public static <T> void validateUniqueField(String fieldName, T value, Supplier<Optional<?>> repositoryCall) {
        if (repositoryCall.get().isPresent()) {
            throw new IllegalArgumentException("There is already a record with this" + fieldName);
        }
    }
}