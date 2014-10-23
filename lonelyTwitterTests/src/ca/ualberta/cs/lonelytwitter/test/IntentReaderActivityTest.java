package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:
       public void testSendText() {
    	   Intent intent = new Intent();
    	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing send text");
    	   
    	   setActivityIntent(intent);
    	   
    	   IntentReaderActivity ira = getActivity();
    	   assertEquals(ira.getText(),"testing send text");
       }
       
       public void testDisplayText() {
    	   Intent intent = new Intent();
    	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing display text");
    	   
    	   setActivityIntent(intent);
    	   
    	   IntentReaderActivity ira = getActivity();
    	   TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	   
    	   assertEquals(tv.getText(),"testing display text");
       }
       
       public void testDoubleText() {
    	   Intent intent = new Intent();
    	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Bye");
    	   intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
    	   
    	   setActivityIntent(intent);
    	   
    	   IntentReaderActivity ira = getActivity();
    	   
    	   assertEquals(ira.getText(), "ByeBye");

       }
       
       public void testReverseText() {
    	   Intent intent = new Intent();
    	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "reverse testing");
    	   intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
    	   
    	   setActivityIntent(intent);
    	   
    	   IntentReaderActivity ira = getActivity();
    	   
    	   assertEquals(ira.getText(), "gnitset esrever");
    	   
       }
       
       public void testDefaultMessage() {
    	   Intent intent = new Intent();

    	   String emptyString = null;
    	   
    	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, emptyString);
    	   
    	   setActivityIntent(intent);
    	   
    	   IntentReaderActivity ira = getActivity();
    	   assertEquals(ira.getText(),"default text");    	   
       }
       
       public void testVisibleText() {
    	   Intent intent = new Intent();
    	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing visible text");
    	   
    	   setActivityIntent(intent);
    	   
    	   IntentReaderActivity ira = getActivity();
    	   TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	   
    	   ViewAsserts.assertOnScreen(ira.getWindow().getDecorView(), tv);
    	   
       }
}
