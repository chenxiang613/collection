package temp;


public class AgDevicePartForm {
	// 属性
	private Long id;
	private String serialNumber;
	private String name;
	private String format;
	private String type;
	private String remark;
	private Long deviceId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getDeviceId() {
		System.err.print("*********getDeviceId************");
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "AgDevicePartForm [id=" + id + ", serialNumber=" + serialNumber + ", name=" + name + ", format=" + format
				+ ", type=" + type + ", remark=" + remark + ", deviceId=" + deviceId + "]";
	}
	
	
}