package ar.com.ale94.spring_jpa_crud_example.exception;

public class IdNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "%s with id %s does not exist";

    public IdNotFoundException(String resource, Long id) {
        super(String.format(ERROR_MESSAGE, resource, id));
    }
}
