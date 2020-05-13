
package Presentation;

public class SplashClass {
    public static void main(String[] args) {
        Splashscreen sp = new Splashscreen();
        sp.setVisible(true);
        LoginForm Login = new LoginForm();
        try {
            for (int i = 0; i < 101; i++) {
                Thread.sleep(30);
                sp.label1.setText(Integer.toString(i));
                sp.jProgressBar1.setValue(i);
                if(i==100){
                sp.setVisible(false);
                Login.setVisible(true);
                }
                
            }
        } catch (Exception e) {
        }
    }
}
