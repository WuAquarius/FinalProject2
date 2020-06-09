package entity;



/**
 * @author wunu
 * @create 2020-06-07 22:49
 * 描述: 密钥
 */
public class InviteCode {
    private String key;

    public InviteCode() {
    }

    public InviteCode(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Key{" +
                "key='" + key + '\'' +
                '}';
    }
}
