package au.usyd.courseAdvisor.model;

public class Course{
	
	private String code;
	private String courseName;
	private String courseDetails;
	private String facultyName;
	private String interest;
	private String session;
	private String specialisation;
	private int credits;
	private float overallRating;
	private String reviewComment;
	
	public String getCode() {
    return code;
    }
	
	public void setCode(String code){
    this.code = code;
	}
	
	public String getCourseName() {
    return courseName;
    }
	
	public void setCourseName(String courseName){
    this.courseName = courseName;
	}
	
	public String getInterest() {
    return interest;
    }
	
    public void setInterest(String interest){
    this.interest = interest;
	}
	
	public String getSession() {
    return session;
    }
	
	public void setSession(String session){
	this.session = session;
	}
	
	public String getSpecialisation() {
    return specialisation;
    }
	
	public void setSpecialisation(String specialisation){
	this.specialisation = specialisation;
	}

	public int getCredits() {
    return credits;
    }
	
	public void setCredits(int credits){
	this.credits = credits;
	}
	
	public String getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public float getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(float overallRating) {
		this.overallRating = overallRating;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	
}