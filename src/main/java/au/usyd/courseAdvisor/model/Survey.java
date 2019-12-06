package au.usyd.courseAdvisor.model;

public class Survey {
	
	private int surveyId; // generate on the spot
	private String code; // to come from user Input
	private String username; // to come from logged in user profile
    private boolean feedbackStatus; // default:false, once save, change to true
	private float avgScore;  // average of scores from 5 questions
    private String comment;  // Updated by user
    private float completionStatus;

	public float getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(float completionStatus) {
		this.completionStatus = completionStatus;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(boolean feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	public float getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
