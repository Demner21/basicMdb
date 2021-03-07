package it.pkg.service;

import javax.jms.TextMessage;

import it.pkg.bean.DataMessageObject;

public interface BasicMdbService {

  String iniciarService(DataMessageObject datosProgramarCambioCiclo, String messageID);
}
