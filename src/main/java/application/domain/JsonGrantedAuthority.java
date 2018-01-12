package application.domain;

class JsonGrantedAuthority {
    private String authority;

    public JsonGrantedAuthority() {
    }

    public JsonGrantedAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
