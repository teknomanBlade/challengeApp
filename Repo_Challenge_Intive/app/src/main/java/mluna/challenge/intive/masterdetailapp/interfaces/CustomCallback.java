package mluna.challenge.intive.masterdetailapp.interfaces;

public interface CustomCallback {
    String initiatingRequest(String[] params);
    void completed(String result);
    void starting();
    void update();
}
