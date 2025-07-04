public interface Expirable {
    boolean isExpired();

    String getExpirationDate();

    void setExpirationDate(String expirationDate);
}
