package com.fengmanfei.ch21;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.*;
import org.eclipse.swt.SWT;

public class JSCodeScanner extends RuleBasedScanner {
	
	private TextAttribute keywords ;//�ؼ��ֵ��ı�����
	private TextAttribute string ;//�ַ������ı�����
	private TextAttribute object ;//���ö�����ı�����
	private TextAttribute comment ;//ע�Ͳ��ֵ��ı�����
	public JSCodeScanner(){
		//�����ѡ���������õ���ɫ����ʼ�����ı�����
		keywords = new TextAttribute (ResourceManager.getColor(Constants.COLOR_KEYWORD),null,SWT.BOLD);
		string = new TextAttribute (ResourceManager.getColor(Constants.COLOR_STRING));
		object = new TextAttribute (ResourceManager.getColor(Constants.COLOR_OBJECT));
		comment = new TextAttribute (ResourceManager.getColor(Constants.COLOR_COMMENT),null,SWT.ITALIC);
		//���ô���Ĺ���
		setupRules();
	}
	private void setupRules() {
		//��һ��List���϶��󱣴����еĹ���
	    List rules = new ArrayList();
	    //�ַ����Ĺ���
	    rules.add(new SingleLineRule("\"", "\"",new Token( string), '\\'));
	    rules.add(new SingleLineRule("'", "'", new Token( string), '\\'));
	    //ע�͵Ĺ���
	    rules.add(new SingleLineRule("/*", "*/", new Token( comment), '\\'));
	    rules.add(new EndOfLineRule("//", new Token( comment),'\\'));
	    //�ո�Ĺ���
	    rules.add(new WhitespaceRule(new IWhitespaceDetector() {
	      public boolean isWhitespace(char c) {
	        return Character.isWhitespace(c);
	      }
	    }));
	    //�ؼ��ֵĹ���
	    WordRule keywordRule = new WordRule(new KeywordDetector());
	    for (int i = 0, n = Constants.JS_SYNTAX_KEYWORD.length; i < n; i++)
	    	keywordRule.addWord(Constants.JS_SYNTAX_KEYWORD[i], new Token( keywords ));
	    rules.add(keywordRule);
	    //���ö���Ĺ���
	    WordRule objectRule = new WordRule(new ObjectDetector());
	    for (int i = 0, n = Constants.JS_SYNTAX_BUILDIB_OBJECT.length; i < n; i++)
	    	objectRule.addWord(Constants.JS_SYNTAX_BUILDIB_OBJECT[i], new Token( object ));
	    rules.add(objectRule);
	    //�������б���Ĺ���ת��Ϊ����
	    IRule[] result = new IRule[rules.size()];
	    rules.toArray(result);
	    //���ø����еķ��������ù���
	    //�˷����ǳ���Ҫ
	    setRules(result);
	}
	
}
