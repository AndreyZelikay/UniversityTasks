package WorkShops.AutoRepairShop;

import Сustom.CustomRandomAccessFile;

public class TransformFile {

    public static void writeToStringEnd(Object object, String file, int numberOfString) {
        try {
            CustomRandomAccessFile raf = new CustomRandomAccessFile(file);
            raf.goToStringEnd(numberOfString);
            raf.writeBytes(object.toString());
            raf.writeBytes(" ");
            raf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
