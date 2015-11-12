package com.fengmanfei.ch13;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.widgets.Text;

public class TextPrinter extends Thread {

	private Text content;//��ʾ�ַ����ı������
	private Printer printer;//��ӡ����
	private GC gc;//���ڻ��Ƶ�ͼ�������Ķ���
	private FontData[] printerFontData;//��ӡ����������
	private RGB printerForeground, printerBackground;//��ӡ��ǰ��ɫ�ͱ���ɫ
	private int lineHeight = 0;//��ӡ���и�
	private int tabWidth = 0;//Tab���Ĵ�С
	private int leftMargin, rightMargin, topMargin, bottomMargin;//�������ҵ�ҳ�߾�
	private int x, y;//��ӡ���к��е�ֵ
	private int index, end;//�ַ���ǰ��ӡ������ֵ���ܳ���
	private String textToPrint;//��Ҫ��ӡ���ַ�
	private String tabs;//Tab��
	private StringBuffer wordBuffer;//��ӡ�ַ�����ʱ����

	public TextPrinter(String name, Text text, Printer printer) {
		super(name);
		this.content = text;
		this.printer = printer;
		init();
	}
	//��ʼ�����Եķ���
	public void init() {
		textToPrint = content.getText();
		printerFontData = content.getFont().getFontData();
		printerForeground = content.getForeground().getRGB();
		printerBackground = content.getBackground().getRGB();
		//Ĭ��һ��Tab����ʾ4���ո�
		int tabSize = 4; 
		StringBuffer tabBuffer = new StringBuffer(tabSize);
		for (int i = 0; i < tabSize; i++)
			tabBuffer.append(' ');
		tabs = tabBuffer.toString();
		
		//�����������ұ߾�ֵ
		Rectangle clientArea = printer.getClientArea();
		Rectangle trim = printer.computeTrim(0, 0, 0, 0);
		Point dpi = printer.getDPI();
		leftMargin = dpi.x + trim.x; 
		rightMargin = clientArea.width - dpi.x + trim.x + trim.width; 
		topMargin = dpi.y + trim.y; 
		bottomMargin = clientArea.height - dpi.y + trim.y + trim.height; 
	}

	public void run() {
		//������ӡ������������������򷵻�
		if (!printer.startJob("Text Print"))
			return;
		//��ʼ��ӡ
		print();
	}

	public void print() {
		//����ͼ�������Ķ���
		gc = new GC(printer);
		//�������壬ǰ��ɫ������ɫ����
		Font printerFont = new Font(printer, printerFontData);
		Color printerForegroundColor = new Color(printer, printerForeground);
		Color printerBackgroundColor = new Color(printer, printerBackground);
		//�����壬ǰ��ɫ������ɫ���ø�gc����
		gc.setFont(printerFont);
		gc.setForeground(printerForegroundColor);
		gc.setBackground(printerBackgroundColor);
		tabWidth = gc.stringExtent(tabs).x;
		lineHeight = gc.getFontMetrics().getHeight();
		//��ӡ�ַ�
		printText();
		//������ӡ����
		printer.endJob();
		//�ͷ���Դ
		printerFont.dispose();
		printerForegroundColor.dispose();
		printerBackgroundColor.dispose();
		gc.dispose();
	}

	void printText() {
		//��ʼ��ӡһҳ
		printer.startPage();
		wordBuffer = new StringBuffer();
		x = leftMargin;
		y = topMargin;
		index = 0;
		end = textToPrint.length();
		//ѭ��ÿ���ַ�����ÿ���ַ�
		while (index < end) {
			char c = textToPrint.charAt(index);
			System.out.println(c);
			index++;
			if (c == 0)
				continue;
			//����ַ���\n���з���\r�س���
			if (c == '\n' || c == '\r'){
				//����ַ�\r\nͬʱ���֣���ֻ��ӡһ��
				if (c == '\r' && index < end && textToPrint.charAt(index) == '\n') {
					index++; 
				}
				printWordBuffer();
				newline();
			} else {
				//����ַ��ǲ���Tab�������ӡ���ַ�
				if (c != '\t') {
					wordBuffer.append(c);
				}
				if (Character.isWhitespace(c)) {
					printWordBuffer();
					if (c == '\t') {//Tab��
						x += tabWidth;
					}
				}
			}
		}
		if (y + lineHeight <= bottomMargin) {
			printer.endPage();
		}
	}
	//��ӡ�ַ���Ҫ�ж��Ƿ��Ѿ������е�ĩβ���������ĩβ��Ҫ����
	void printWordBuffer() {
		if (wordBuffer.length() > 0) {
			String word = wordBuffer.toString();
			int wordWidth = gc.stringExtent(word).x;
			if (x + wordWidth > rightMargin) {
				newline();
			}
			gc.drawString(word, x, y, false);
			x += wordWidth;
			wordBuffer = new StringBuffer();
		}
	}
	//���У��������ҳβ����Ҫ��ӡ��һҳ
	void newline() {
		x = leftMargin;
		y += lineHeight;
		if (y + lineHeight > bottomMargin) {
			printer.endPage();
			if (index + 1 < end) {
				y = topMargin;
				printer.startPage();
			}
		}
	}

}
