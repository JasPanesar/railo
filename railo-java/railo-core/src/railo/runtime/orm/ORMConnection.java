package railo.runtime.orm;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import railo.runtime.PageContext;
import railo.runtime.exp.PageException;

public class ORMConnection implements Connection {

	private ORMSession session;
	private PageContext pc;
	private boolean autoCommit=false;
	private int isolation=Connection.TRANSACTION_SERIALIZABLE;
	private ORMTransaction trans;

	/**
	 * Constructor of the class
	 * @param session
	 * @throws PageException 
	 */
	public ORMConnection(PageContext pc,ORMSession session) {
		this.pc=pc;
		this.session=session;
		trans = session.getTransaction();
		trans.begin();
	}
	
	/**
	 * @see java.sql.Connection#clearWarnings()
	 */
	public void clearWarnings() throws SQLException {}

	public void close() throws SQLException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see java.sql.Connection#commit()
	 */
	public void commit() {
		trans.commit();
	}

	/**
	 * @see java.sql.Connection#createStatement()
	 */
	public Statement createStatement() throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#createStatement(int, int)
	 */
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#createStatement(int, int, int)
	 */
	public Statement createStatement(int resultSetType,int resultSetConcurrency, int resultSetHoldability)throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#getAutoCommit()
	 */
	public boolean getAutoCommit() throws SQLException {
		return autoCommit;
	}

	/**
	 * @see java.sql.Connection#getTransactionIsolation()
	 */
	public int getTransactionIsolation() throws SQLException {
		return isolation;
	}

	/**
	 * @see java.sql.Connection#setTransactionIsolation(int)
	 */
	public void setTransactionIsolation(int isolation) throws SQLException {
		this.isolation=isolation;
	}

	/**
	 * @see java.sql.Connection#getCatalog()
	 */
	public String getCatalog() throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#getHoldability()
	 */
	public int getHoldability() throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#getMetaData()
	 */
	public DatabaseMetaData getMetaData() throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#getTypeMap()
	 */
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#getWarnings()
	 */
	public SQLWarning getWarnings() throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#isClosed()
	 */
	public boolean isClosed() throws SQLException {
		return !session.isValid();
	}

	/**
	 * @see java.sql.Connection#isReadOnly()
	 */
	public boolean isReadOnly() throws SQLException {
		return false;
	}

	/**
	 * @see java.sql.Connection#nativeSQL(java.lang.String)
	 */
	public String nativeSQL(String sql) throws SQLException {
		return sql;
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String)
	 */
	public CallableStatement prepareCall(String sql) throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
	 */
	public CallableStatement prepareCall(String sql, int resultSetType,int resultSetConcurrency) throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
	 */
	public CallableStatement prepareCall(String sql, int resultSetType,int resultSetConcurrency, int resultSetHoldability)throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String)
	 */
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
	 */
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
	 */
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 */
	public PreparedStatement prepareStatement(String sql, String[] columnNames)throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
	 */
	public PreparedStatement prepareStatement(String sql, int resultSetType,int resultSetConcurrency) throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
	 */
	public PreparedStatement prepareStatement(String sql, int resultSetType,int resultSetConcurrency, int resultSetHoldability)throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
	 */
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
	}

	/**
	 * @see java.sql.Connection#rollback()
	 */
	public void rollback() {
		trans.rollback();
	}

	/**
	 * @see java.sql.Connection#rollback(java.sql.Savepoint)
	 */
	public void rollback(Savepoint savepoint) throws SQLException {
		rollback();
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		this.autoCommit=autoCommit;
		if(autoCommit)
			trans.end();
	}

	/**
	 * @see java.sql.Connection#setCatalog(java.lang.String)
	 */
	public void setCatalog(String catalog) throws SQLException {
	}

	/**
	 * @see java.sql.Connection#setHoldability(int)
	 */
	public void setHoldability(int holdability) throws SQLException {
	}

	/**
	 * @see java.sql.Connection#setReadOnly(boolean)
	 */
	public void setReadOnly(boolean readOnly) throws SQLException {
		
	}

	/**
	 * @see java.sql.Connection#setSavepoint()
	 */
	public Savepoint setSavepoint() throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#setSavepoint(java.lang.String)
	 */
	public Savepoint setSavepoint(String name) throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#setTypeMap(java.util.Map)
	 */
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		throw notSupported();
	}

	private SQLException toSQLException(PageException pe) {
		SQLException e = new SQLException(pe.getMessage());
		e.initCause(pe);
		return e;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw notSupported();
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		throw notSupported();
	}

	public Clob createClob() throws SQLException {
		throw notSupported();
	}

	public Blob createBlob() throws SQLException {
		throw notSupported();
	}

	public boolean isValid(int timeout) throws SQLException {
		throw notSupported();
	}

	public void setClientInfo(String name, String value) {
		throw notSupportedEL();
	}

	public void setClientInfo(Properties properties) {
		throw notSupportedEL();
	}

	public String getClientInfo(String name) throws SQLException {
		throw notSupported();
	}

	public Properties getClientInfo() throws SQLException {
		throw notSupported();
	}

	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		throw notSupported();
	}

	/**
	 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
	 */
	public Struct createStruct(String typeName, Object[] attributes)throws SQLException {
		throw notSupported();
	}

	private SQLException notSupported() {
		return new SQLException("this feature is not supported");
	}
	private RuntimeException notSupportedEL() {
		return new RuntimeException(new SQLException("this feature is not supported"));
	}

	
	//JDK6: uncomment this for compiling with JDK6 
	 
	public NClob createNClob() throws SQLException {
		throw notSupported();
	}

	public SQLXML createSQLXML() throws SQLException {
		throw notSupported();
	}
	
	
}
