import java.io.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Human h = new Human("Bob", 23);
        Human h2 = new Human("Kell", 27);

        System.out.println(h + "h object");
        System.out.println(h2 + "h2 object");

        try (FileOutputStream fos = new FileOutputStream("temp.out");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(h);
            oos.writeObject(h2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);

        Human newHuman = null;
        Human newHuman2 = null;
        try (FileInputStream fis = new FileInputStream("temp.out");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            newHuman = (Human) ois.readObject();
            newHuman2 = (Human) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(newHuman + "newHuman object");
        System.out.println(newHuman2 + "newHuman2 object");

    }

}
