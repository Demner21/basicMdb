package it.pkg.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DatosProgramarCambioCicloFactType")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataMessageObject implements Serializable {
  private static final long serialVersionUID = 1L;

  private String coIdPub;
  private String codDoc;
  private String csBillcycleNew;
  private String csBillcycleOld;
  private String csIdPub;
  private String cscode;
  private String customerEmail;
  private String customerFirstName;
  private String customerLastName;
  private String idTransaccion;
  private String msisdn;
  private String nombreSistemaOrigen;
  private String scheduleDate;
  private String tipoDoc;
  private String userID;
  private String usrAplicacion;

  public String getCoIdPub() {
    return coIdPub;
  }

  public void setCoIdPub(String coIdPub) {
    this.coIdPub = coIdPub;
  }

  public String getCodDoc() {
    return codDoc;
  }

  public void setCodDoc(String codDoc) {
    this.codDoc = codDoc;
  }

  public String getCsBillcycleNew() {
    return csBillcycleNew;
  }

  public void setCsBillcycleNew(String csBillcycleNew) {
    this.csBillcycleNew = csBillcycleNew;
  }

  public String getCsBillcycleOld() {
    return csBillcycleOld;
  }

  public void setCsBillcycleOld(String csBillcycleOld) {
    this.csBillcycleOld = csBillcycleOld;
  }

  public String getCsIdPub() {
    return csIdPub;
  }

  public void setCsIdPub(String csIdPub) {
    this.csIdPub = csIdPub;
  }

  public String getCscode() {
    return cscode;
  }

  public void setCscode(String cscode) {
    this.cscode = cscode;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public String getCustomerFirstName() {
    return customerFirstName;
  }

  public void setCustomerFirstName(String customerFirstName) {
    this.customerFirstName = customerFirstName;
  }

  public String getCustomerLastName() {
    return customerLastName;
  }

  public void setCustomerLastName(String customerLastName) {
    this.customerLastName = customerLastName;
  }

  public String getIdTransaccion() {
    return idTransaccion;
  }

  public void setIdTransaccion(String idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

  public String getMsisdn() {
    return msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }

  public String getNombreSistemaOrigen() {
    return nombreSistemaOrigen;
  }

  public void setNombreSistemaOrigen(String nombreSistemaOrigen) {
    this.nombreSistemaOrigen = nombreSistemaOrigen;
  }

  public String getScheduleDate() {
    return scheduleDate;
  }

  public void setScheduleDate(String scheduleDate) {
    this.scheduleDate = scheduleDate;
  }

  public String getTipoDoc() {
    return tipoDoc;
  }

  public void setTipoDoc(String tipoDoc) {
    this.tipoDoc = tipoDoc;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getUsrAplicacion() {
    return usrAplicacion;
  }

  public void setUsrAplicacion(String usrAplicacion) {
    this.usrAplicacion = usrAplicacion;
  }

}