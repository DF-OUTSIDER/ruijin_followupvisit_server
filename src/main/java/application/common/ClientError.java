package application.common;

/**
 * return with error message
 */
public class ClientError implements ActionResult {
    private Boolean success;
    private String message;

    public ClientError(Boolean result, String message) {
        this.success = result;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
