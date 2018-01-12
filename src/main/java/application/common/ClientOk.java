package application.common;

/**
 * return correct result
 */
public class ClientOk implements ActionResult {
    private Boolean success;
    private Object data;

    public ClientOk(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ClientOk(boolean result, Object... data) {
        this.success = result;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }
}
