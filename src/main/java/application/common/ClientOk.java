package application.common;

/**
 * 正常返回数据
 */
public class ClientOk implements ActionResult {
    private Boolean success;
    private Object data;

    public ClientOk(boolean result, Object data) {
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
