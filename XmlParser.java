package com.example.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class XmlParser {

	public static List<Sms> ParserXml(InputStream in){

		List<Sms> smslist=null;
		Sms sms = null;
		try {
			XmlPullParser xmlPullParser = Xml.newPullParser();
			xmlPullParser.setInput(in, "utf-8");
			int type = xmlPullParser.getEventType();
			while(type!=XmlPullParser.END_DOCUMENT){
				
				if (type==XmlPullParser.START_TAG) {
					if ("smss".equals(xmlPullParser.getName())) {
						smslist = new ArrayList<Sms>();
					}
					
					else if("sms".equals(xmlPullParser.getName())){
						sms = new Sms();
						String id = xmlPullParser.getAttributeValue(0);
						sms.setId(id);
					}
					
					else if("adress".equals(xmlPullParser.getName())){
						sms.setAdress(xmlPullParser.nextText());
					}else if("body".equals(xmlPullParser.getName())){
						sms.setBody(xmlPullParser.nextText());
					}else if("date".equals(xmlPullParser.getName())){
						sms.setDate(xmlPullParser.nextText());
					}
					
				}else if(type==XmlPullParser.END_TAG){
					if ("sms".equals(xmlPullParser.getName())) {
						smslist.add(sms);
					}
				}
				type = xmlPullParser.next();
				
			}
			
			
			
			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return smslist;
	}
}
