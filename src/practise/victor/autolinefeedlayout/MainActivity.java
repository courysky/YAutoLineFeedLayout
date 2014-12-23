package practise.victor.autolinefeedlayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final boolean DEBUG = true;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        AutoLineFeedLayout alflTags = (AutoLineFeedLayout) findViewById(R.id.alfl_tags);
        for (int i = 3; i < 15; i++) {
            
            View childView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, null);
            TextView codeTextView = (TextView) childView.findViewById(R.id.tlt_code);
            
            TextView bodyTextView = (TextView) childView.findViewById(R.id.tlt_body);
            codeTextView.setText("code"+i);
            bodyTextView.setText("bodybody"+i*i);
            bodyTextView.setTag(i);
            bodyTextView.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    if (DEBUG) Log.v(TAG, "onClick()");
                    Toast.makeText(MainActivity.this, "点击"+v.getTag(), Toast.LENGTH_SHORT).show();
                    
                }
            });
            alflTags.addView(childView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

}
