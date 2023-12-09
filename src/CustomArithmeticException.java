public class CustomArithmeticException extends ArithmeticException {
    private String customMessage;

    public CustomArithmeticException(String message) {
        super(message);
        this.customMessage = message;
    }

    @Override
    public String getMessage() {
        return "Custom Arithmetic Exception: " + customMessage;
    }
}
