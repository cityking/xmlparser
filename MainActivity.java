package com.example.parser;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView textView = (TextView) findViewById(R.id.tv);
		
		StringBuffer sb = new StringBuffer();
		try {
			InputStream in = getAssets().open("sms_bac2.xml");
			List<Sms> smss = XmlParser.ParserXml(in);
			for (Sms sms : smss) {
				sb.append(sms.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		textView.setText(sb.toString());
	}


}
