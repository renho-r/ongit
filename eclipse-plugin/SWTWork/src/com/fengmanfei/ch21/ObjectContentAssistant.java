package com.fengmanfei.ch21;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.text.*;
import org.eclipse.jface.text.contentassist.*;

public class ObjectContentAssistant implements IContentAssistProcessor {

	// �ӿ��еķ�����������ݵ���ʾ����
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		IDocument doc = viewer.getDocument();
		//�����ʾ�б��е�����
		List list = computObject(getObjectName(doc, offset), offset);
		return (CompletionProposal[]) list.toArray(new CompletionProposal[list
				.size()]);
	}

	// �ӿ��еķ�������ʵ��
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	// �ӿ��еķ��������ú�ʱ������ʾ�����ﵱ����.ʱ����������ʾ
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { '.' };
	}

	// �ӿ��еķ���
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	// �ӿ��еķ���
	public String getErrorMessage() {
		return null;
	}

	// �ӿ��еķ���
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	//��û����ʾʱ��֮ǰ������ַ�
	public String getObjectName(IDocument doc, int offset) {
		//offsetΪ��ǰ�������λ�ã�Ҳ����ƫ����
		StringBuffer buf = new StringBuffer();
		offset--;
		//���δӵ�ǰλ�ò��ң�ֱ���ַ���Ϊ�ո������"." ʱֹͣ��
		//Ȼ���ַ�����ת
		while (true) {
			try {
				char c = doc.getChar(--offset);//���ǰһ���ַ�
				if (Character.isWhitespace(c))//���Ϊ�ո�����
					break;
				if (c=='.')//���Ϊ��.��������
					break;
				buf.append(c);
			} catch (BadLocationException e) {
				break;
			}
		}
		return buf.reverse().toString();//����ַ���ת
	}

	// ����������ʾ���е�����
	public List computObject(String objName, int offset) {
		//objName���ȿ�objName�Ƿ�Ϊ���õĶ���
		List list = new ArrayList();
		boolean bFind = false;
		for (int i = 0; i < Constants.JS_SYNTAX_BUILDIB_OBJECT.length; i++) {
			String tempString = Constants.JS_SYNTAX_BUILDIB_OBJECT[i];
			if (objName.equals(tempString))
			{
				bFind = true;
				break;
			}
		}
		//��������ö��������еĶ�����ַ���ӵ�������ʾ�б���
		if (bFind) {
			for (int i = 0; i < Constants.JS_SYNTAX_BUILDIB_OBJECT.length; i++) {
				String insert = objName + "."+ Constants.JS_SYNTAX_BUILDIB_OBJECT[i];
				//CompletionProposal����
				CompletionProposal proposal = new CompletionProposal(insert,
						offset - objName.length() - 1, objName.length()+1, insert.length()+1,null,null,null,"aaa"
						);
				list.add(proposal);
				//list.
			}
		}
		return list;
	}

}
