package superCRM.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import superCRM.pojos.ContactEO;

public class ContactDaoMysqlImpl implements IContactDao {

	public ContactEO findById(int id) {
		int row = -1;
		// ����¼��sql���
		String sql = "select * from contact where contact_id=" + id
				+ " and active_status='Y'";
		ResultSet rs = DbManager.getResultSet(sql);// ִ��sql��䲢����ResultSet
		try {
			rs.last();// �ƶ������һ��
			row = rs.getRow();// �õ��ܼ�¼��
			if (row == 1) {// ���ֻ��ѯ��һ����¼�������ü�¼���ڲ����¸��������
				ContactEO contact = new ContactEO();
				contact.setId( rs.getInt("contact_id"));
				contact.setCustomerId( rs.getInt("customer_id"));
				contact.setDisplayName( rs.getString("display_name"));
				contact.setBirthDate(rs.getString("birth_date"));
				contact.setCategory(rs.getString("contact_type"));
				contact.setJobTitle(rs.getString("job_title"));
				contact.setSex(rs.getString("sex"));
				return contact;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs.getStatement() != null)
					rs.getStatement().close();
				DbManager.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List findBykeywords(String keywords) {
		String sql = "select contact_id from contact where active_status='Y'"
			+"and (display_name like '%"+keywords+"%' or contact_type like '%"+keywords+"%' or sex like '%"+keywords+"%,')";;
		return getContactResult(sql);
	}

	public List getAllContacts() {
		String sql = "select contact_id from contact where active_status='Y'";
		//System.out.println(sql);
		return getContactResult(sql);
	}

	public ContactEO addContact(ContactEO c) {
		String sql = "select contact_id from contact ";
		int row = getContactResult(sql).size()+1;
		sql ="insert into contact values ("+row+","+c.getCustomerId()+",'"+c.getDisplayName()+"'" +
				",'" +c.getCategory()+"','"+c.getSex()+"','"+c.getBirthDate()+"','"+c.getJobTitle()+
				"','"+c.getActiveStatus()+"')";
		try {
			DbManager.excute(sql);
			DbManager.releaseConnection();
			return findById( row ) ;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List getContactResult(String sql) {
		ResultSet rs = DbManager.getResultSet(sql);// ִ��sql��䲢����ResultSet
		List list =  new ArrayList();
		try {
			while(rs.next()){
				int id = rs.getInt("contact_id");
				ContactEO c = findById( id );
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbManager.releaseConnection();
		return list;
	}

}
