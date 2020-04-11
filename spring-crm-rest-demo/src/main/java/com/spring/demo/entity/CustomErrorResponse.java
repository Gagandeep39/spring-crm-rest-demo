/**
 * Gagandeep
 * 11:24:20 am
 * 11-Apr-2020
 */
package com.spring.demo.entity;

/**
 * The Class CustomErrorResponse.
 */
public class CustomErrorResponse {
	
	/** The status. */
	private int status;
	
	/** The message. */
	private String message;
	
	/** The timestamp. */
	private long timestamp;
	
	public CustomErrorResponse() {
	}
	/**
	 * 
	 * @param status
	 * @param message
	 * @param timestamp
	 */
	public CustomErrorResponse(int status, String message, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Displays oject data on sysout(obj).
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CustomErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
	

}
