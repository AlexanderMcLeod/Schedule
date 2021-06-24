package accesslayer;

import java.io.*;

import schedule.Schedule;

public class AccessLayer {

    public static void saveSchedule(Schedule schedule, String path) throws IOException{

        new FileOutputStream(path).close(); // Clears the file just in case

        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream obj = new ObjectOutputStream(file);

        obj.writeObject(schedule);

        file.close();
        obj.close();

    }

    public static Schedule getSchedule(String path) throws IOException, FileNotFoundException, ClassNotFoundException {

        FileInputStream file = new FileInputStream(path);
        ObjectInputStream obj = new ObjectInputStream(file);

        final Schedule OPENED_SCHEDULE = (Schedule) obj.readObject();

        file.close();
        obj.close();

        return OPENED_SCHEDULE;

    }
    
}
