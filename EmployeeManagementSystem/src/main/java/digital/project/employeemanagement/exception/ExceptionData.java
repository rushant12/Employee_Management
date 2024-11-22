package digital.project.employeemanagement.exception;

public class ExceptionData {
	
    private int code;
    
    private String message;
    
    private long timestamp;
    
    private String path;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ExceptionData [code=" + code + ", message=" + message + ", timestamp=" + timestamp + ", path=" + path
				+ "]";
	}
    
    

}
