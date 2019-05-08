package rozeridilar.com.fragmenttofragmentcommunication;

public interface IMainActivity {
    void setToolBarTitle(String fragmentTag);
    void inflateFragment(String fragmentTag, String message);
}
