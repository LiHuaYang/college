package pers.ctl;

public class Parameter {

	private Object data;
	private ParameterDirection direction;
	private ParameterType type;

	public Object getData() {
		return data;
	}

	public ParameterDirection getDirection() {
		return direction;
	}

	public ParameterType getType() {
		return type;
	}

	/**
	 * 自定义类型
	 * @param data
	 * @param direction
	 * @param type
	 */
	public Parameter(Object data, ParameterDirection direction,
			ParameterType type) {
		this.data = data;
		this.direction = direction;
		this.type = type;
	}

	/**
	 * 输入类型
	 * @param data
	 * @param type
	 */
	public Parameter(Object data, ParameterType type) {
		this.data = data;
		this.direction = ParameterDirection.In;
		this.type = type;
	}
	
	/**
	 * 输出类型
	 * @param type
	 */
	public Parameter(ParameterType type) {
		this.data = new Object();
		this.direction = ParameterDirection.Out;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProcedureParameter [data=" + data + ", direction=" + direction
				+ ", type=" + type + "]";
	}

}
