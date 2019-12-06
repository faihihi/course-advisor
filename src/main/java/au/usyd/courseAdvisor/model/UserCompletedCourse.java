package au.usyd.courseAdvisor.model;

public class UserCompletedCourse {

	private String username;
	private String code;
	private String courseName;
	private String occurrence;
	private int yearOfCompletion;
	private String session;
	private int completedCredits;
	private int remainingCredits;
	private int credits;
	
	private String notCompleteStatusStyle;
	private String completeStatusStyle;

	public String getNotCompleteStatusStyle() {
		return notCompleteStatusStyle;
	}
	public void setNotCompleteStatusStyle(String style) {
		this.notCompleteStatusStyle = style;
	}
	public String getCompleteStatusStyle() {
		return completeStatusStyle;
	}
	public void setCompleteStatusStyle(String style) {
		this.completeStatusStyle = style;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getOccurrence() {
		return occurrence;
	}
	public void setOccurrence(String occurrence) {
		this.occurrence = occurrence;
	}
	public int getYearOfCompletion() {
		return yearOfCompletion;
	}
	public void setYearOfCompletion(int yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public int getCompletedCredits() {
		return completedCredits;
	}
	public void setCompletedCredits(int completedCredits) {
		this.completedCredits = completedCredits;
	}
	public int getRemainingCredits() {
		return remainingCredits;
	}
	public void setRemainingCredits(int remainingCredits) {
		this.remainingCredits = remainingCredits;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}


}
