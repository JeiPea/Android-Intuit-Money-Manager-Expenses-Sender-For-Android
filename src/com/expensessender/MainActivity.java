package com.expensessender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LinearLayout list = (LinearLayout) findViewById(R.id.category_list);
        
        String [] categoryList = CategoryManager.getCategories();
        
        Button currB;
               
        for (int iter=0;iter < categoryList.length; iter++)
        {
        	currB = new Button(this);
        	currB.setText(categoryList[iter]);
        	//currB.setLayoutParams(params);

        	currB.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg) {
					Button btn = (Button) arg;
					
					String cat = (String) btn.getText();
					
					Intent move = new Intent(MainActivity.this, ExpenseActivity.class);
					move.putExtra("Category", cat);
					startActivity(move);
					
				}
        		
        		
        	});
        	
        	list.addView(currB);
        }
        
    }
}