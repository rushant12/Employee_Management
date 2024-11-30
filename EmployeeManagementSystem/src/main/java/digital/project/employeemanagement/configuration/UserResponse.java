package digital.project.employeemanagement.configuration;

public class UserResponse {
	
	private String msg;
	
	private String url;



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "UserResponse [msg=" + msg + ", url=" + url + "]";
	}


	
	

}
