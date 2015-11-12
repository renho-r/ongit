package superCRM.dao;

public class DaoFactory {

	/** �������ݿ����͵ĳ��� */
	public static final String MYSQL = "mysql";

	public static final String ORACLE = "oracle";

	public static final String SQLSERVER = "sql_server";

	/** ���ݿ������ */
	private String dbType = MYSQL;

	private ICustomerDao customerDao;

	private IContactDao contactDao;

	/** ���췽�� */
	public DaoFactory() {
		/** ������ݿ�����Ϊmysql */
		if (dbType.equals(MYSQL)) {
			customerDao = new CustomerDaoMysqlImpl();
			contactDao = new ContactDaoMysqlImpl();
		}
	}

	/** һЩgetter��setter���� */
	public IContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(IContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

}
