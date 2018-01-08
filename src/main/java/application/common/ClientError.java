package application.common;

public class ClientError implements ActionResult{
    private Boolean result;
    private String message;

    public ClientError(Boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
