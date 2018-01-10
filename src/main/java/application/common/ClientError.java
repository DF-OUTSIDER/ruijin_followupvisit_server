package application.common;

/**
 * 发生错误时的返回对象
 */
public class ClientError implements ActionResult{
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
