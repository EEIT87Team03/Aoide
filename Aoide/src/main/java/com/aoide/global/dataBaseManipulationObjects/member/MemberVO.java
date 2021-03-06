package com.aoide.global.dataBaseManipulationObjects.member;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.aoide.global.dataBaseManipulationObjects.ValueObject;

public class MemberVO implements java.io.Serializable, ValueObject
{
	private Integer memberId;
	private String account;
	private String password;
	private String name; 
	private String email;
	private Integer registerState;		
	private Integer loginCount;	
	private Timestamp lastLoginDate; 	
	private BigDecimal tokenTotal; 	
	private String picture; 
	private String introductionFilePath; 
	private Integer classType;		
	private Boolean banState; 		
	private String bankInfo;
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId( Integer memberId) {
		this.memberId = memberId;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) 
	{
		this.account = account;
	}
	
	public String getPassword() 
	{
		return password;
	}
	public void setPassword( String password ) 
	{
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName( String name ) 
	{
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail( String email ) 
	{
		this.email = email;
	}
	
	public Integer getRegisterState() 
	{
		return registerState;
	}
	public void setRegisterState( Integer registerState ) 
	{
		this.registerState = registerState;
	}
	
	public Integer getLoginCount() 
	{
		return loginCount;
	}
	public void setLoginCount( Integer loginCount ) 
	{
		this.loginCount = loginCount;
	}
	
	public Timestamp getLastLoginDate() 
	{
		return lastLoginDate;
	}
	public void setLastLoginDate( Timestamp lastLoginDate ) 
	{
		this.lastLoginDate = lastLoginDate;
	}
	
	public BigDecimal getTokenTotal() 
	{
		return tokenTotal;
	}
	public void setTokenTotal( BigDecimal tokenTotal ) 
	{
		this.tokenTotal = tokenTotal;
	}
	
	public String getPicture() 
	{
		return picture;
	}
	public void setPicture( String picture )
	{
		this.picture = picture;
	}
	
	public String getIntroductionFilePath() 
	{
		return introductionFilePath;
	}
	public void setIntroductionFilePath( String introductionFile ) 
	{
		this.introductionFilePath = introductionFile;
	}
	
	public Integer getClassType() 
	{
		return classType;
	}
	public void setClassType( Integer classType ) 
	{
		this.classType = classType;
	}
	
	public Boolean getBanState() 
	{
		return banState;
	}
	public void setBanState( Boolean banState) {
		this.banState = banState;
	}
	
	public String getBankInfo() 
	{
		return bankInfo;
	}
	public void setBankInfo( String bankInfo ) 
	{
		this.bankInfo = bankInfo;
	} 
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( memberId + "\t" ).append( account + "\t" ).append( password + "\t" ).append( name + "\t" )
		  .append( email + "\t" ).append( registerState + "\t" ).append( loginCount + "\t" )
		  .append( lastLoginDate + "\t" ).append( tokenTotal + "\t" ).append( introductionFilePath + "\t" )
		  .append( classType + "\t" ).append( banState + "\t" ).append( bankInfo );
		return sb.toString();
	}
}
