package pers.ctl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class DBHelper {

	private static DBHelper helper = null;

	private DBHelper() {

	}

	public static DBHelper newInstance() {
		if (helper == null) {
			helper = new DBHelper();
		}
		return helper;
	}

	/**
	 * 插入语句返回插入的主键值
	 * 
	 * @param sql
	 * @return
	 */
	public String insertReturnKey(String sql) {
		String result = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			if (!DatabaseProperty.succeed) {
				return null;
			}

			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return null;
			}

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);

			ResultSet rs = preparedStatement.getGeneratedKeys();

			if (rs.next()) {
				result = rs.getString(1);
			} else {
				result = null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = null;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	/**
	 * 带参数的插入语句
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public String insertReturnKey(String sql, Parameter[] parameters) {
		String result = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			if (!DatabaseProperty.succeed) {
				return null;
			}

			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return null;
			}

			preparedStatement = connection.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			setAttributes(preparedStatement, parameters);
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();

			if (rs.next()) {
				result = rs.getString(1);
			} else {
				result = null;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = null;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	/**
	 * sql语句执行
	 * 
	 * @param sql
	 * @return
	 */
	public boolean excuteSQL(String sql) {
		boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			if (!DatabaseProperty.succeed) {
				return false;
			}

			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return false;
			}

			preparedStatement = connection.prepareStatement(sql);

			int excuteRows = preparedStatement.executeUpdate();

			if (excuteRows > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = false;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	/**
	 * 带参数的sql语句
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public boolean excuteSQL(String sql, Parameter[] parameters) {
		boolean result = false;

		if (!DatabaseProperty.succeed) {
			return false;
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return false;
			}

			preparedStatement = connection.prepareStatement(sql);

			setAttributes(preparedStatement, parameters);

			int excuteRows = preparedStatement.executeUpdate();

			if (excuteRows > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = false;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	/**
	 * 返回单个值的查询
	 * 
	 * @param sql
	 * @return
	 */
	public Object querySingle(String sql) {
		Object result = null;

		if (!DatabaseProperty.succeed) {
			return null;
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return null;
			}

			preparedStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE);

			rs = preparedStatement.executeQuery();

			rs.last();
			int rowLength = rs.getRow();
			if (rowLength > 0) {
				rs.beforeFirst();
				int columnCount = rs.getMetaData().getColumnCount();

				if (rowLength == 1 && columnCount == 1) {
					result = new Object();
					rs.next();
					result = rs.getObject(1);
				} else {
					result = null;
				}
			} else {
				result = null;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	/**
	 * 返回单个值的查询 带参数
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public Object querySingle(String sql, Parameter[] parameters) {
		Object result = null;

		if (!DatabaseProperty.succeed) {
			return null;
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return null;
			}

			preparedStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE);

			setAttributes(preparedStatement, parameters);

			rs = preparedStatement.executeQuery();

			rs.last();
			int rowLength = rs.getRow();
			if (rowLength > 0) {
				rs.beforeFirst();
				int columnCount = rs.getMetaData().getColumnCount();

				if (rowLength == 1 && columnCount == 1) {
					result = new Object();
					rs.next();
					result = rs.getObject(1);
				} else {
					result = null;
				}
			} else {
				result = null;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	/**
	 * 查询表 不带参数
	 * 
	 * @param sql
	 * @return
	 */
	public Object[][] query(String sql) {
		Object[][] result = null;

		if (!DatabaseProperty.succeed) {
			return null;
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return null;
			}

			preparedStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE);

			rs = preparedStatement.executeQuery();

			rs.last();
			int rowLength = rs.getRow();
			if (rowLength > 0) {
				rs.beforeFirst();
				int columnCount = rs.getMetaData().getColumnCount();

				result = new Object[rowLength][columnCount];

				int index = 0;
				while (rs.next()) {

					for (int i = 0; i < columnCount; i++) {
						result[index][i] = rs.getObject(i + 1);
					}
					index++;
				}
			} else {
				result = null;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	/**
	 * 带参数的查询
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public Object[][] query(String sql, Parameter[] parameters) {
		Object[][] result = null;

		if (!DatabaseProperty.succeed) {
			return null;
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return null;
			}

			preparedStatement = connection.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_SENSITIVE);

			setAttributes(preparedStatement, parameters);

			rs = preparedStatement.executeQuery();

			rs.last();
			int rowLength = rs.getRow();
			if (rowLength > 0) {
				rs.beforeFirst();
				int columnCount = rs.getMetaData().getColumnCount();

				result = new Object[rowLength][columnCount];

				int index = 0;
				while (rs.next()) {

					for (int i = 0; i < columnCount; i++) {
						result[index][i] = rs.getObject(i + 1);
					}
					index++;
				}
			} else {
				result = null;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = null;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	/**
	 * 事务
	 * 
	 * @param sqls
	 * @return
	 */
	public boolean doTransaction(String[] sqls) {
		boolean result = false;

		if (!DatabaseProperty.succeed) {
			return false;
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return false;
			}

			connection.setAutoCommit(false);
			for (String sql : sqls) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
			}
			connection.commit();
			result = true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					result = false;
				}
			}
			result = false;
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	/**
	 * 调用存储过程
	 * 
	 * @param sql
	 * @param parameters
	 *            参数
	 * @return 如果有返回值，则将返回值放入对象数组返回
	 */
	public Object[] callProcedure(String sql, Parameter[] parameters) {
		Object[] result = null;

		ArrayList<Integer> indexList = null; // 存放out类型的数组

		if (!DatabaseProperty.succeed) {
			return null;
		}

		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			Class.forName(DatabaseProperty.DRIVER);

			connection = DriverManager.getConnection(
					DatabaseProperty.connectString, DatabaseProperty.USER,
					DatabaseProperty.PASSWORD);

			if (connection.isClosed()) {
				return null;
			}

			callableStatement = connection.prepareCall(sql);

			if (parameters != null && parameters.length > 0) {

				indexList = new ArrayList<Integer>();
				for (int i = 0; i < parameters.length; i++) {

					int index = i + 1;
					if (parameters[i].getDirection() == ParameterDirection.Out) {

						if (parameters[i].getType() == ParameterType.Integer) {
							callableStatement.registerOutParameter(index,
									Types.INTEGER);
						} else if (parameters[i].getType() == ParameterType.String) {
							callableStatement.registerOutParameter(index,
									Types.VARCHAR);
						} else if (parameters[i].getType() == ParameterType.Double) {
							callableStatement.registerOutParameter(index,
									Types.DOUBLE);
						}

						indexList.add(index);
					} else {
						callableStatement.setString((i + 1), parameters[i]
								.getData().toString());
					}
				}

			}

			callableStatement.execute();

			if (indexList.size() > 0) {
				result = new Object[indexList.size()];
				for (int i = 0; i < indexList.size(); i++) {
					result[i] = callableStatement.getObject(indexList.get(i));
				}
			} else {
				result = new Object[0];
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			result = null;
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return result;
	}

	/**
	 * 设置属性
	 * @param preparedStatement
	 * @param parameters
	 */
	private void setAttributes(PreparedStatement preparedStatement,
			Parameter[] parameters) {
		try {

			for (int i = 0; i < parameters.length; i++) {

				if (parameters[i].getType() == ParameterType.Double) {
					preparedStatement.setDouble((i + 1), Double
							.parseDouble(parameters[i].getData().toString()));
				} else if (parameters[i].getType() == ParameterType.String) {
					preparedStatement.setString((i + 1), parameters[i]
							.getData().toString());
				} else if (parameters[i].getType() == ParameterType.Integer) {
					preparedStatement.setInt((i + 1), Integer
							.parseInt(parameters[i].getData().toString()));
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
