package ITDA.project.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Member {

	private String userId; // 아이디
	private String userPw; // 비밀번호
	private String userName; // 이름
	private String dateOfBirth; // 생년월일
	private String userBirth; // 생년월일
	private String userGender; // 성별
	private String userPhone; // 전화번호
	private String userAddress1; // 주소
	private String userAddress2; // 상세주소
	private String userPost; // 우편번호
	private String userEmail; // 이메일
	private String userCategory; // 관심 카테고리
	private Timestamp userJoindate; // 가입일시
	private int statusId; // 유저 상태값
	private Timestamp updateDate; // 정보 수정일
	private String userProfile; // 프로필 사진

	
	
	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//	
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public LocalDate getDateOfBirth() {
//		return dateOfBirth;
//	}

//	public void setDateOfBirth(LocalDate dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress1() {
		return userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	public String getUserAddress2() {
		return userAddress2;
	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	public Timestamp getUserJoindate() {
		return userJoindate;
	}

	public void setUserJoindate(Timestamp userJoindate) {
		this.userJoindate = userJoindate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

}
