package newPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import ca.ualberta.cs.lonelytwitter.Tweet;


public class FileManager {
	private static final String FILENAME = "file.sav";

	public FileManager() {
		
	}
	public ArrayList<Tweet> loadTweets() {
		ArrayList<Tweet> lts = new ArrayList<Tweet>();

		try {
			FileInputStream fis = new FileInputStream(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lts = (ArrayList<Tweet>) ois.readObject();

		} catch (Exception e) {
			Log.i("LonelyTwitter", "Error casting");
			e.printStackTrace();
		} 

		return lts;
	}
	
	public void saveTweets(List<Tweet> lts) {
		try {
			FileOutputStream fos = new FileOutputStream(FILENAME);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lts);
			fos.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
