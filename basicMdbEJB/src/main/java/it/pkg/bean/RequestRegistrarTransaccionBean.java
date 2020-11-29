package it.pkg.bean;

import java.io.Serializable;
import java.util.Date;

public class RequestRegistrarTransaccionBean implements Serializable{
  
  private static final long serialVersionUID = 1L;
  private String            parameterVarchar;
  private String            parameterBlob;
  private Date              parameterDate;
  
  public String getParameterVarchar(){
    return parameterVarchar;
  }
  
  public void setoParameterVarchar( String parameterVarchar ){
    this.parameterVarchar = parameterVarchar;
  }
  
  public String getParameterBlob(){
    return parameterBlob;
  }
  
  public void setoParameterBlob( String parameterBlob ){
    this.parameterBlob = parameterBlob;
  }
  
  public Date getParameterDate(){
    return parameterDate;
  }
  
  public void setParameterDate( Date parameterDate ){
    this.parameterDate = parameterDate;
  }
}
